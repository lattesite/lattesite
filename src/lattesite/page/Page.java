package lattesite.page;

import lattesite.css.StyleContext;
import lattesite.html.elements.HTMLBodyElement;
import lattesite.html.elements.HTMLHeadElement;
import lattesite.localization.locale.Locale;

/** Represents a single page in the site, responsible for producing its head and body content. */
public interface Page {

    /** @return {@code true} if this page should be excluded from sitemaps and navigation */
    boolean isHidden();

    /**
     * @param locale the locale for which the path is resolved
     * @return the URL path for this page, starting and ending with {@code /} (e.g. {@code "/about/"})
     */
    String getPathWithSlashes(Locale locale) throws Exception;

    /**
     * @param primaryLocale the locale used to look up the title text
     * @return the page title for use in {@code <title>} and Open Graph tags
     */
    String getTitle(Locale primaryLocale) throws Exception;

    /**
     * Appends all {@code <head>} child elements for this page.
     *
     * @param locale       the locale being rendered
     * @param styleContext the shared style context; add CSS blocks here
     * @param parent       the {@code <head>} element to append into
     */
    void appendHeadElements(Locale locale, StyleContext styleContext, HTMLHeadElement parent) throws Exception;

    /**
     * Appends all {@code <body>} child elements for this page.
     *
     * @param locale       the locale being rendered
     * @param styleContext the shared style context; add CSS blocks here
     * @param parent       the {@code <body>} element to append into
     */
    void appendBodyElements(Locale locale, StyleContext styleContext, HTMLBodyElement parent) throws Exception;

}
