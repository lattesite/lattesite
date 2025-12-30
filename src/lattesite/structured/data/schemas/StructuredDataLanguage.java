package lattesite.structured.data.schemas;

public class StructuredDataLanguage implements StructuredDataSchema {

    private final String name;

    public StructuredDataLanguage(
            String name
    ) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Language";
    }

    public String getName() {
        return name;
    }
    
}
