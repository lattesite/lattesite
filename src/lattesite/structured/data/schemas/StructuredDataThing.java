package lattesite.structured.data.schemas;

public class StructuredDataThing implements StructuredDataSchema {

    private final String name;

    public StructuredDataThing(
            String name
    ) {
        this.name = name;
    }

    @Override
    public String getType() {
        return "Thing";
    }

    public String getName() {
        return name;
    }

}
