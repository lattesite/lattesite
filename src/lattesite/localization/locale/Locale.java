package lattesite.localization.locale;

public class Locale {

    private final String code;
    private final String baseURL;

    /**
     * Create a new Locale.
     *
     * @param code    For example be "en" or "en-US", etc.
     * @param baseURL Base URL for the locale, for example "https://www.domain.com/de/" or "https://www.domain.de"
     */

    public Locale(String code, String baseURL) {
        this.code = code;
        this.baseURL = baseURL;
    }

    /**
     * Returns the locale code.
     *
     * @return Returns the locale code.
     */
    public String getCode() {
        return this.code;
    }

    /**
     * Returns the code;
     *
     * @return Returns the code.
     */
    @Override
    public String toString() {
        return this.code;
    }

    /**
     * Returns the base URL.
     *
     * @return The base URL.
     */
    public String getBaseURL() {
        return this.baseURL;
    }

}
