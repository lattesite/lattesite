package lattesite.structureddata.enumeration;

/**
 * Schema.org {@code GenderType} enumeration for use with {@code Person} structured data.
 *
 * @see <a href="https://schema.org/GenderType">Schema.org/GenderType</a>
 */
public enum GenderType {

    /**
     * Female gender ({@code https://schema.org/Female}).
     */
    FEMALE("https://schema.org/Female"),
    /**
     * Male gender ({@code https://schema.org/Male}).
     */
    MALE("https://schema.org/Male");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }

}
