package lattesite.localization.utils;

import lattesite.common.utils.StringUtil;
import lattesite.localization.locale.Locale;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/** Utility methods for building localized URLs. */
public final class LocalizationUtil {

    /**
     * URL-encodes the given value using UTF-8.
     *
     * @param value the raw string to encode
     * @return the percent-encoded string
     */
    public static String qpEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    /**
     * Prepends the base URL of the given locale to a path.
     *
     * @param locale          the locale whose base URL is used
     * @param pathWithSlashes the path to append (e.g. {@code "/about/"})
     * @return the absolute URL
     */
    public static String addBaseURL(Locale locale, String pathWithSlashes) {
        return addBaseURL(locale.getBaseURL(), pathWithSlashes);
    }

    /**
     * Prepends a base URL to a path, stripping any trailing slash from the base URL first.
     *
     * @param baseURL         the base URL (e.g. {@code "https://example.com/en/"})
     * @param pathWithSlashes the path to append (e.g. {@code "/about/"})
     * @return the absolute URL
     */
    public static String addBaseURL(String baseURL, String pathWithSlashes) {
        // Make sure that the base URL does not end with a forward slash
        if (baseURL.endsWith("/")) {
            baseURL = baseURL.substring(0, baseURL.length() - 1);
        }
        return baseURL + pathWithSlashes;
    }

    /**
     * Prepends the locale's output sub-folder to a path, unless the sub-folder is empty.
     *
     * @param locale          the locale to localize for
     * @param pathWithSlashes the path to prefix (e.g. {@code "/about/"})
     * @return the localized path (e.g. {@code "/de/about/"}) or the original path if the locale has no sub-folder
     */
    public static String localizeURL(Locale locale, String pathWithSlashes) {
        if (StringUtil.isEmpty(locale.getOutputSubFolderName())) {
            return pathWithSlashes;
        }
        return "/" + locale.getOutputSubFolderName() + pathWithSlashes;
    }

}
