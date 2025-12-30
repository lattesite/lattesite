package lattesite.structured.data.schemas;

public class StructuredDataWebSite implements StructuredDataSchema {

    private final String name;
    private final String description;
    private final String url;
    private StructuredDataLanguage inLanguage;

    public StructuredDataWebSite(
            String name,
            String description,
            String url,
            StructuredDataLanguage inLanguage
    ) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.inLanguage = inLanguage;
    }

    @Override
    public String getType() {
        return "WebSite";
    }

    public String getURL() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return description;
    }

    public StructuredDataLanguage getInLanguage() {
        return inLanguage;
    }

    public void setInLanguage(StructuredDataLanguage inLanguage) {
        this.inLanguage = inLanguage;
    }

}
