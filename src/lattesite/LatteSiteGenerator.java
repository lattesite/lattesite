package lattesite;

import lattesite.common.services.FileService;
import lattesite.common.services.LogService;
import lattesite.localization.locale.Locale;
import lattesite.page.Page;
import lattesite.page.services.PageGeneratorService;
import lattesite.settings.SiteSettings;
import lattesite.sitemap.services.SitemapService;

import java.util.List;

/** Orchestrates site generation: page rendering, static file copying, and sitemap creation. */
public class LatteSiteGenerator {

    private final LogService logService;
    private final SiteSettings siteSettings;
    private final FileService fileService;
    private final PageGeneratorService pageGeneratorService;
    private final SitemapService sitemapService;

    public LatteSiteGenerator(
            LogService logService,
            SiteSettings siteSettings,
            FileService fileService,
            PageGeneratorService pageGeneratorService,
            SitemapService sitemapService
    ) {
        this.logService = logService;
        this.siteSettings = siteSettings;
        this.fileService = fileService;
        this.pageGeneratorService = pageGeneratorService;
        this.sitemapService = sitemapService;
    }

    public void generate(List<? extends Page> pages) throws Exception {
        generate(pages, true);
    }

    /**
     * Generates the full site output.
     *
     * @param pages        the pages to render
     * @param deletePublic if {@code true}, the public folder is wiped before generation
     */
    public void generate(List<? extends Page> pages, boolean deletePublic) throws Exception {

        if (this.siteSettings.getLocales().isEmpty()) {
            throw new Exception("Cannot generate site. No locales were specified in site settings.");
        }

        // Clear the public folder
        if (deletePublic) {
            this.fileService.deleteDirectory(siteSettings.getPublicFolder());
        } else {
            this.logService.log("Won't delete the public folder.");
        }

        // Generate pages
        this.pageGeneratorService.generate(pages);

        // Copy over the static main folder to the public main folder
        this.fileService.copyDirectory(siteSettings.getStaticRootFolder(), siteSettings.getPublicFolder());

        // Copy over the static locale folder to the public locale folders
        for (Locale locale : this.siteSettings.getLocales()) {
            this.fileService.copyDirectory(siteSettings.getStaticLocaleFolder(), siteSettings.getPublicFolder() + locale.getOutputSubFolderName() + "/");
        }

        // Generate the index sitemap
        String fileIndex = this.siteSettings.getPublicFolder() + "sitemap-index.xml";
        this.sitemapService.writeIndexFile(siteSettings.getLocales(), fileIndex);

        // Generate sitemap for each locale
        for (Locale primaryLocale : this.siteSettings.getLocales()) {
            String fileLocale = this.siteSettings.getPublicFolder() + primaryLocale.getOutputSubFolderName() + "/sitemap.xml";
            this.sitemapService.writeLocaleFile(primaryLocale, siteSettings.getLocales(), pages, fileLocale);
        }

    }

}
