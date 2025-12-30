package lattesite.structured.data.schemas;

public class StructuredDataWebPage implements StructuredDataSchema {

    private final String name;
    private final String url;
    private final String description;
    private final StructuredDataWebSite isPartOf;
    private final StructuredDataLanguage inLanguage;
    private StructuredDataPeopleAudience audience;

    public StructuredDataWebPage(
            String name,
            String url,
            String description,
            StructuredDataWebSite isPartOf,
            StructuredDataLanguage inLanguage
    ) {
        this.name = name;
        this.url = url;
        this.description = description;
        this.isPartOf = isPartOf;
        this.inLanguage = inLanguage;
        this.audience = null;
    }

    @Override
    public String getType() {
        return "WebPage";
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

    public StructuredDataLanguage getInLanguage() {
        return inLanguage;
    }

}
