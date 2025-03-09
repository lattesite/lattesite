package lattesite.structureddata.schemas.creativework;

/**
 * Represents a Schema.org {@code SoftwareApplication}.
 *
 * <p>An optional sub-category can be set via {@link #setApplicationSubCategory(String)}.</p>
 *
 * @see <a href="https://schema.org/SoftwareApplication">Schema.org/SoftwareApplication</a>
 */
public class StructuredDataSoftwareApplication extends StructuredDataCreativeWork {

    private final String operatingSystem;
    private final String applicationCategory;
    private String applicationSubCategory;

    /**
     * @param id                  the JSON-LD {@code @id} for this application
     * @param name                the application name
     * @param description         a short description of the application
     * @param url                 the canonical URL of the application
     * @param operatingSystem     the operating system(s) the application runs on (e.g. {@code "Windows"})
     * @param applicationCategory the Schema.org application category (e.g. {@code "GameApplication"})
     */
    public StructuredDataSoftwareApplication(
            String id,
            String name,
            String description,
            String url,
            String operatingSystem,
            String applicationCategory
    ) {
        super(
                id,
                name,
                description,
                url
        );
        this.operatingSystem = operatingSystem;
        this.applicationCategory = applicationCategory;
        this.applicationSubCategory = null;
    }

    @Override
    public String getType() {
        return "SoftwareApplication";
    }

    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    public String getApplicationCategory() {
        return this.applicationCategory;
    }

    public String getApplicationSubCategory() {
        return this.applicationSubCategory;
    }

    public void setApplicationSubCategory(String applicationSubCategory) {
        this.applicationSubCategory = applicationSubCategory;
    }

}
