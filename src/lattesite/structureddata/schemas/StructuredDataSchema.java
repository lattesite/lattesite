package lattesite.structureddata.schemas;

/**
 * Base class for all Schema.org structured data objects.
 *
 * <p>Every schema object has a JSON-LD {@code @id} and a {@code @type} string that maps to
 * a Schema.org type name. Subclasses must implement {@link #getType()}.</p>
 *
 * @see <a href="https://schema.org/Thing">Schema.org/Thing</a>
 */
abstract public class StructuredDataSchema {

    private final String id;

    /**
     * @param id the JSON-LD {@code @id} for this object, typically an absolute URL; may be {@code null}
     */
    public StructuredDataSchema(String id) {
        this.id = id;
    }

    /**
     * @return the JSON-LD {@code @id} value, or {@code null} if not set
     */
    final public String getID() {
        return this.id;
    }

    /**
     * @return the Schema.org type name used as the JSON-LD {@code @type} value (e.g. {@code "Product"})
     */
    abstract public String getType();

}
