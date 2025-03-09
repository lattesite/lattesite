package lattesite.structureddata.schemas.geo;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code Country}.
 *
 * @see <a href="https://schema.org/Country">Schema.org/Country</a>
 */
public class StructuredDataCountry extends StructuredDataSchema {

    private final String name;

    /**
     * @param id   the JSON-LD {@code @id} for this country
     * @param name the country name (e.g. {@code "Sweden"})
     */
    public StructuredDataCountry(
            String id,
            String name
    ) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    @Override
    final public String getType() {
        return "Country";
    }

}
