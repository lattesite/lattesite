package lattesite.structured.data.schemas;

public class StructuredDataWebPage {

    private final String name;
    private final String url;
    private final String description;
    private final StructuredDataWebSite isPartOf;
    private StructuredDataPeopleAudience audience;

    public StructuredDataWebPage(
            String name,
            String url,
            String description,
            StructuredDataWebSite isPartOf
    ) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.isPartOf = isPartOf;
        this.audience = null;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getURL() {
        return this.url;
    }

    public StructuredDataWebSite getIsPartOf() {
        return this.isPartOf;
    }

    public void setAudience(StructuredDataPeopleAudience audience) {
        this.audience = audience;
    }

    public StructuredDataPeopleAudience getAudience() {
        return this.audience;
    }

}
