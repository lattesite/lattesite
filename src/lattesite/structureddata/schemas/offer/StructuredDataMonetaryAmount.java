package lattesite.structureddata.schemas.offer;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code MonetaryAmount} — a monetary value with an ISO 4217 currency code.
 *
 * @see <a href="https://schema.org/MonetaryAmount">Schema.org/MonetaryAmount</a>
 */
public class StructuredDataMonetaryAmount extends StructuredDataSchema {

    private final int value;
    private final String currency;

    /**
     * Creates a monetary amount without a JSON-LD {@code @id}.
     *
     * @param value    the integer monetary value
     * @param currency the ISO 4217 currency code (e.g. {@code "SEK"}, {@code "USD"})
     */
    public StructuredDataMonetaryAmount(
            int value,
            String currency
    ) {
        this(null, value, currency);
    }

    /**
     * @param id       the JSON-LD {@code @id} for this amount; may be {@code null}
     * @param value    the integer monetary value
     * @param currency the ISO 4217 currency code (e.g. {@code "SEK"}, {@code "USD"})
     */
    public StructuredDataMonetaryAmount(
            String id,
            int value,
            String currency
    ) {
        super(id);
        this.value = value;
        this.currency = currency;
    }

    @Override
    public String getType() {
        return "MonetaryAmount";
    }

    public int getValue() {
        return this.value;
    }

    public String getCurrency() {
        return this.currency;
    }

}
