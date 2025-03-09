package lattesite.structureddata.schemas.thing;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code Thing} — the most generic structured data type.
 *
 * @see <a href="https://schema.org/Thing">Schema.org/Thing</a>
 */
public class StructuredDataThing extends StructuredDataSchema {

    private final String name;

    /**
     * @param id   the JSON-LD {@code @id} for this thing
     * @param name the name of this thing
     */
    public StructuredDataThing(
            String id,
            String name
    ) {
        super(id);
        this.name = name;
    }

    @Override
    public String getType() {
        return "Thing";
    }

    public String getName() {
        return this.name;
    }

}
