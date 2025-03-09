package lattesite.page.services;

import lattesite.common.services.FileService;
import lattesite.common.services.LogService;
import lattesite.common.utils.StringUtil;
import lattesite.css.StyleBlock;
import lattesite.css.StyleContext;
import lattesite.css.keyframes.KeyFrames;
import lattesite.css.services.StyleGeneratorServiceInterface;
import lattesite.html.elements.HTMLBodyElement;
import lattesite.html.elements.HTMLHeadElement;
import lattesite.html.elements.HTMLRootElement;
import lattesite.html.elements.HTMLStyleElement;
import lattesite.html.generator.ElementGenerator;
import lattesite.localization.locale.Locale;
import lattesite.page.Page;
import lattesite.settings.SiteSettings;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/** Renders each {@link Page} for each configured locale and writes the resulting HTML files to disk. */
public class PageGeneratorService {

    private final SiteSettings settings;
    private final LogService logService;
    private final ElementGenerator elementGenerator;
    private final StyleGeneratorServiceInterface styleGeneratorService;
    private final FileService fileService;
    private final String nl;

    public PageGeneratorService(
            SiteSettings settings,
            LogService logService,
            ElementGenerator elementGenerator,
            StyleGeneratorServiceInterface styleGeneratorService,
            FileService fileService
    ) {
        this(settings, logService, elementGenerator, styleGeneratorService, fileService, "\n");
    }

    public PageGeneratorService(
            SiteSettings settings,
            LogService logService,
            ElementGenerator elementGenerator,
            StyleGeneratorServiceInterface styleGeneratorService,
            FileService fileService,
            String nl
    ) {
        this.settings = settings;
        this.logService = logService;
        this.elementGenerator = elementGenerator;
        this.styleGeneratorService = styleGeneratorService;
        this.fileService = fileService;
        this.nl = nl;
    }

    /**
     * Renders every page for every configured locale.
     *
     * @param pages the pages to render
     */
    public void generate(List<? extends Page> pages) throws Exception {
        this.logService.log("Generating " + pages.size() + " pages over " + this.settings.getLocales().size() + " locales.");
        for (Locale locale : this.settings.getLocales()) {
            for (Page page : pages) {
                generate(locale, page);
            }
        }
    }

    /**
     * Renders a single page for a single locale and writes the HTML file to disk.
     *
     * @param locale the locale to render
     * @param page   the page to render
     */
    public void generate(Locale locale, Page page) throws Exception {

        this.logService.log("Generating page " + page.getClass().getSimpleName() + " for locale " + locale + ".");

        String pageFolder;
        if (StringUtil.isEmpty(locale.getOutputSubFolderName())) {
            pageFolder = "public" + page.getPathWithSlashes(locale);
        } else {
            pageFolder = "public/" + locale.getOutputSubFolderName() + page.getPathWithSlashes(locale);
        }

        StyleContext styleContext = new StyleContext();

        HTMLRootElement htmlElement = new HTMLRootElement("html");
        htmlElement.setAttribute("lang", locale.getCode());

        HTMLHeadElement head = new HTMLHeadElement(htmlElement);

        page.appendHeadElements(locale, styleContext, head);

        HTMLBodyElement body = new HTMLBodyElement(htmlElement);

        page.appendBodyElements(locale, styleContext, body);

        // Add any styles that might have gotten added

        if (!styleContext.getBlocks().isEmpty() || !styleContext.getKeyFrames().isEmpty()) {
            Set<String> styles = new LinkedHashSet<>();
            for (StyleBlock sc : styleContext.getBlocks()) {
                styles.add(this.styleGeneratorService.toCSS(sc));
            }
            for (KeyFrames kf : styleContext.getKeyFrames()) {
                styles.add(this.styleGeneratorService.toCSS(kf));
            }
            String css = String.join("", styles);
            new HTMLStyleElement(head, css);
        }

        String html = "";
        html += "<!DOCTYPE html>" + this.nl;
        html += this.elementGenerator.generate(htmlElement);

        this.fileService.writeFile(pageFolder + "index.html", html);

    }

}
