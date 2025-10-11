package lattesite.localization.version;

public class Version {

    private final String slug;
    private final String baseURL;

    /**
     * Create a new version of your site.
     *
     * @param slug    For example be "en" "en-US", "main" or "test", etc.
     * @param baseURL Base URL for the version, for example "https://www.domain.com/de/", "https://www.domain.de", "https://test.domain.com/"
     */

    public Version(String slug, String baseURL) {
        this.slug = slug;
        this.baseURL = baseURL;
    }

    /**
     * Returns the slug.
     *
     * @return Returns the slug.
     */
    public String getSlug() {
        return this.slug;
    }

    /**
     * Returns the slug;
     *
     * @return Returns the code.
     */
    @Override
    public String toString() {
        return this.slug;
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
