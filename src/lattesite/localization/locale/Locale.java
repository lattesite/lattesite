package lattesite.localization.locale;

public class Locale {

    private final String code;
    private final String baseURL;
    private final String outputSubFolderName;

    /**
     * Create a new Locale.
     *
     * @param code    For example be "en" or "en-US", etc.
     * @param baseURL Base URL for the locale, for example "https://www.domain.com/de/" or "https://www.domain.de"
     */

    public Locale(String code, String baseURL) {
        this(code, baseURL, code.toLowerCase());
    }

    /**
     * Create a new Locale.
     *
     * @param code                For example be "en" or "en-US", etc.
     * @param baseURL             Base URL for the locale, for example "https://www.domain.com/de/" or "https://www.domain.de"
     * @param outputSubFolderName The output subfolder, for example "en" or "es", or "" (for the public folder directly)
     */

    public Locale(String code, String baseURL, String outputSubFolderName) {
        this.code = code;
        this.baseURL = baseURL;
        this.outputSubFolderName = outputSubFolderName;
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

    public String getOutputSubFolderName() {
        return this.outputSubFolderName;
    }

}
