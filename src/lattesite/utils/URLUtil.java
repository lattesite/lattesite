package lattesite.utils;

import lattesite.localization.locale.Locale;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

/**
 * Various String utility methods.
 */
public final class URLUtil {

    public static String qpEncode(String value) {
        return URLEncoder.encode(value, StandardCharsets.UTF_8);
    }

    public static String addBaseURL(Locale locale, String pathWithSlashes) {
        return addBaseURL(locale.getBaseURL(), pathWithSlashes);
    }

    public static String addBaseURL(String baseURL, String pathWithSlashes) {
        // Make sure that the base URL does not end with a forward slash
        if (baseURL.endsWith("/")) {
            baseURL = baseURL.substring(0, baseURL.length() - 1);
        }
        return baseURL + pathWithSlashes;
    }

    public static String localizeURL(Locale locale, String pathWithSlashes) {
        return "/" + locale.getCode() + pathWithSlashes;
    }

}
