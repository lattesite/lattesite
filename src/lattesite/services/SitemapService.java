package lattesite.services;

import lattesite.localization.locale.Locale;
import lattesite.page.Page;
import lattesite.settings.SiteSettings;
import lattesite.utils.URLUtil;

import java.util.List;

public class SitemapService {

    private final SiteSettings siteSettings;
    private final String indentation;
    private final String nl;
    private final FileService fileService;
    private final LogService logService;

    public SitemapService(SiteSettings siteSettings, LogService logService, FileService fileService) {
        this(siteSettings, logService, fileService, "    ", "\n");
    }

    public SitemapService(SiteSettings siteSettings, LogService logService, FileService fileService, String indentation, String nl) {
        this.siteSettings = siteSettings;
        this.logService = logService;
        this.fileService = fileService;
        this.indentation = indentation;
        this.nl = nl;
    }

    public void writeLocaleFile(Locale primaryLocale, List<Locale> allLocales, List<? extends Page> pages, String file) throws Exception {
        String xml = generateLocaleFile(primaryLocale, allLocales, pages);
        this.fileService.writeFile(file, xml);
    }

    public String generateLocaleFile(Locale primaryLocale, List<Locale> allLocales, List<? extends Page> pages) throws Exception {

        this.logService.log("Generating sitemap with " + pages.size() + " pages for locale \"" + primaryLocale + "\".");

//        List<Locale> locales = this.siteSettings.getLocales();

        if (primaryLocale == null) {
            throw new Exception("Cannot generate sitemap. No primary locale was specified.");
        }

        String xml = "";

        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + this.nl;
        xml += "<urlset xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\" xmlns:xhtml=\"http://www.w3.org/1999/xhtml\">" + this.nl;

        for (Page page : pages) {
            if (page.isHidden()) {
                continue;
            }

            xml += this.indentation + "<url>" + this.nl;
            xml += this.indentation.repeat(2) + "<loc>" + URLUtil.addBaseURL(primaryLocale.getBaseURL(), page.getPathWithSlashes(primaryLocale)) + "</loc>" + this.nl;
            if (allLocales.size() >= 2) {
                for (Locale locale : allLocales) {
                    xml += this.indentation.repeat(2) + "<xhtml:link rel=\"alternate\" hreflang=\"" + locale.getCode() + "\" href=\"" + URLUtil.addBaseURL(locale.getBaseURL(), page.getPathWithSlashes(locale)) + "\"/>" + this.nl;
                }
            }
            xml += this.indentation + "</url>" + this.nl;
        }

        xml += "</urlset>" + this.nl;

        return xml;

    }

    public void writeIndexFile(List<Locale> allLocales, String file) throws Exception {
        String xml = generateIndexFile(allLocales);
        this.fileService.writeFile(file, xml);
    }

    public String generateIndexFile(List<Locale> allLocales) {

        this.logService.log("Generating index sitemap for " + allLocales.size() + " locales.");

        String xml = "";

        xml += "<?xml version=\"1.0\" encoding=\"UTF-8\"?>" + this.nl;
        xml += "<sitemapindex xmlns=\"http://www.sitemaps.org/schemas/sitemap/0.9\">" + this.nl;

        for (Locale locale : allLocales) {
            xml += this.indentation + "<sitemap>" + this.nl;
            xml += this.indentation.repeat(2) + "<loc>" + URLUtil.addBaseURL(locale.getBaseURL(), "/sitemap.xml") + "</loc>" + this.nl;
            xml += this.indentation + "</sitemap>" + this.nl;
        }

        xml += "</sitemapindex>" + this.nl;

        return xml;

    }

}
