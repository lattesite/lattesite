package lattesite.structureddata.enumeration;

/**
 * Schema.org {@code ItemAvailability} enumeration for use with {@code Offer} structured data.
 *
 * @see <a href="https://schema.org/ItemAvailability">Schema.org/ItemAvailability</a>
 */
public enum ItemAvailability {

    /**
     * Item is in stock ({@code https://schema.org/InStock}).
     */
    IN_STOCK("https://schema.org/InStock"),
    /**
     * Item is out of stock ({@code https://schema.org/OutOfStock}).
     */
    OUT_OF_STOCK("https://schema.org/OutOfStock");

    private final String value;

    ItemAvailability(String value) {
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
