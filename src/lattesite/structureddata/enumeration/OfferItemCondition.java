package lattesite.structureddata.enumeration;

/**
 * Schema.org {@code OfferItemCondition} enumeration for use with {@code Offer} structured data.
 *
 * @see <a href="https://schema.org/OfferItemCondition">Schema.org/OfferItemCondition</a>
 */
public enum OfferItemCondition {

    /**
     * New item condition ({@code https://schema.org/NewCondition}).
     */
    NEW("https://schema.org/NewCondition"),
    /**
     * Used item condition ({@code https://schema.org/UsedCondition}).
     */
    USED("https://schema.org/UsedCondition");

    private final String value;

    OfferItemCondition(String value) {
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
