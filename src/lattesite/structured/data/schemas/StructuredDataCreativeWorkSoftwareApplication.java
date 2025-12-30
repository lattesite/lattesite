package lattesite.structured.data.schemas;

public class StructuredDataCreativeWorkSoftwareApplication extends StructuredDataCreativeWork {

    private final String operatingSystem;
    private final String applicationCategory;
    private String applicationSubCategory;

    public StructuredDataCreativeWorkSoftwareApplication(
            String name,
            String description,
            String url,
            String operatingSystem,
            String applicationCategory
    ) {
        super(
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
        return applicationSubCategory;
    }

    public void setApplicationSubCategory(String applicationSubCategory) {
        this.applicationSubCategory = applicationSubCategory;
    }

}
