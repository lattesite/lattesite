package lattesite.sitemap.services;

import lattesite.common.services.FileService;
import lattesite.common.services.LogService;
import lattesite.localization.locale.Locale;
import lattesite.localization.utils.LocalizationUtil;
import lattesite.page.Page;

import java.util.List;

/**
 * Generates XML sitemaps for one or more locales.
 * <p>
 * Supports per-locale sitemap files with {@code hreflang} alternate links,
 * and a sitemap index file that references each locale's sitemap.
 */
public class SitemapService {

    private final String indentation;
    private final String nl;
    private final FileService fileService;
    private final LogService logService;

    public SitemapService(LogService logService, FileService fileService) {
        this(logService, fileService, "    ", "\n");
    }

    public SitemapService(LogService logService, FileService fileService, String indentation, String nl) {
        this.logService = logService;
        this.fileService = fileService;
        this.indentation = indentation;
        this.nl = nl;
    }

    /**
     * Generates a per-locale sitemap and writes it to a file.
     *
     * @param primaryLocale the locale whose base URL is used for {@code <loc>} entries
     * @param allLocales    all locales to include as {@code hreflang} alternate links (requires at least 2)
     * @param pages         the pages to include; hidden pages are skipped
     * @param file          the output file path
     */
    public void writeLocaleFile(Locale primaryLocale, List<Locale> allLocales, List<? extends Page> pages, String file) throws Exception {
        String xml = generateLocaleFile(primaryLocale, allLocales, pages);
        this.fileService.writeFile(file, xml);
    }

    /**
     * Generates a per-locale sitemap as an XML string.
     *
     * @param primaryLocale the locale whose base URL is used for {@code <loc>} entries
     * @param allLocales    all locales to include as {@code hreflang} alternate links (requires at least 2)
     * @param pages         the pages to include; hidden pages are skipped
     * @return the sitemap XML
     */
    public String generateLocaleFile(Locale primaryLocale, List<Locale> allLocales, List<? extends Page> pages) throws Exception {

        if (primaryLocale == null) {
            throw new Exception("Cannot generate sitemap. No primary locale was specified.");
        }

        this.logService.log("Generating sitemap with " + pages.size() + " pages for locale \"" + primaryLocale + "\".");

        StringBuilder xml = new StringBuilder();

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(nl);
        xml.append("<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">").append(nl);

        for (Page page : pages) {
            if (page.isHidden()) {
                continue;
            }

            xml.append(indentation).append("<url>").append(nl);
            xml.append(indentation.repeat(2)).append("<loc>").append(LocalizationUtil.addBaseURL(primaryLocale.getBaseURL(), page.getPathWithSlashes(primaryLocale))).append("</loc>").append(nl);
            if (allLocales.size() >= 2) {
                for (Locale locale : allLocales) {
                    xml.append(indentation.repeat(2)).append("<xhtml:link rel=\"alternate\" hreflang=\"").append(locale.getCode()).append("\" href=\"").append(LocalizationUtil.addBaseURL(locale.getBaseURL(), page.getPathWithSlashes(locale))).append("\"/>").append(nl);
                }
            }
            xml.append(indentation).append("</url>").append(nl);
        }

        xml.append("</urlset>").append(nl);

        return xml.toString();

    }

    /**
     * Generates a sitemap index file referencing each locale's sitemap and writes it to a file.
     *
     * @param allLocales all locales to include
     * @param file       the output file path
     */
    public void writeIndexFile(List<Locale> allLocales, String file) throws Exception {
        String xml = generateIndexFile(allLocales);
        this.fileService.writeFile(file, xml);
    }

    /**
     * Generates a sitemap index file as an XML string, with one entry per locale.
     *
     * @param allLocales all locales to include
     * @return the sitemap index XML
     */
    public String generateIndexFile(List<Locale> allLocales) {

        this.logService.log("Generating index sitemap for " + allLocales.size() + " locales.");

        StringBuilder xml = new StringBuilder();

        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(nl);
        xml.append("<sitemapindex xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">").append(nl);

        for (Locale locale : allLocales) {
            xml.append(indentation).append("<sitemap>").append(nl);
            xml.append(indentation.repeat(2)).append("<loc>").append(LocalizationUtil.addBaseURL(locale.getBaseURL(), "/sitemap.xml")).append("</loc>").append(nl);
            xml.append(indentation).append("</sitemap>").append(nl);
        }

        xml.append("</sitemapindex>").append(nl);

        return xml.toString();

    }

}
