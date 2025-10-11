package lattesite;

import lattesite.localization.locale.Locale;
import lattesite.page.Page;
import lattesite.services.FileService;
import lattesite.services.LogService;
import lattesite.services.PageGeneratorService;
import lattesite.services.SitemapService;
import lattesite.settings.SiteSettings;

import java.util.List;

public class LatteSite {

    private final LogService logService;
    private final SiteSettings siteSettings;
    private final FileService fileService;
    private final PageGeneratorService pageGeneratorService;
    private final SitemapService sitemapService;

    public LatteSite(
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
//        if (siteSettings.getStaticRootFolder() == null) {
//            this.logService.log("Static root folder is null. Skipping copying files.");
//        } else {
        this.fileService.copyDirectory(siteSettings.getStaticRootFolder(), siteSettings.getPublicFolder());
//        }

        // Copy over the static locale folder to the public locale folders
//        if (siteSettings.getStaticLocaleFolder() == null) {
//            this.logService.log("Static locale folder is null. Skipping copying files.");
//        } else {
        for (Locale locale : this.siteSettings.getLocales()) {
            this.fileService.copyDirectory(siteSettings.getStaticLocaleFolder(), siteSettings.getPublicFolder() + locale.getCode().toLowerCase() + "/");
        }
//        }

        // Generate the index sitemap
        String fileIndex = this.siteSettings.getPublicFolder() + "sitemap-index.xml";
        this.sitemapService.writeIndexFile(siteSettings.getLocales(), fileIndex);

        // Generate sitemap for each locale
        for (Locale primaryLocale : this.siteSettings.getLocales()) {
            String fileLocale = this.siteSettings.getPublicFolder() + primaryLocale.getOutputSubFolderName() + "/sitemap.xml";
            this.sitemapService.writeLocaleFile(primaryLocale, siteSettings.getLocales(), pages, fileLocale);
        }

    }

//    /**
//     * Generates a Google Merchant Feed (XML) given the products to the given file.
//     *
//     * @param products Products that should be in the feed
//     * @param file     The XML file that should be generated
//     */
//    public void generateGoogleMerchantFeed(List<? extends Product> products, String file) throws Exception {
//        String xml = this.googleMerchantService.generate(products);
//        this.fileService.writeFile(file, xml);
//    }

}
