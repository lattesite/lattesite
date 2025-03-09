package lattesite.structureddata.schemas.product;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code PropertyValue} — a name/value pair used for product attributes.
 *
 * @see <a href="https://schema.org/PropertyValue">Schema.org/PropertyValue</a>
 */
public class StructuredDataPropertyValue extends StructuredDataSchema {

    private final String name;
    private final String value;

    /**
     * Creates a property value without a JSON-LD {@code @id}.
     *
     * @param name  the property name (e.g. {@code "Color"})
     * @param value the property value (e.g. {@code "Red"})
     */
    public StructuredDataPropertyValue(
            String name,
            String value
    ) {
        this(null, name, value);
    }

    /**
     * @param id    the JSON-LD {@code @id} for this property value; may be {@code null}
     * @param name  the property name (e.g. {@code "Color"})
     * @param value the property value (e.g. {@code "Red"})
     */
    public StructuredDataPropertyValue(
            String id,
            String name,
            String value
    ) {
        super(id);
        this.name = name;
        this.value = value;
    }

    @Override
    public String getType() {
        return "PropertyValue";
    }

    public String getName() {
        return this.name;
    }

    public String getValue() {
        return this.value;
    }

}
