package lattesite.structureddata.schemas.offer;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code QuantitativeValue} — a numeric range with a unit of measurement.
 *
 * <p>Used to express durations such as handling or transit time in shipping.</p>
 *
 * @see <a href="https://schema.org/QuantitativeValue">Schema.org/QuantitativeValue</a>
 */
public class StructuredDataQuantitativeValue extends StructuredDataSchema {

    private final int minValue;
    private final int maxValue;
    private final UnitCode unitCode;

    /**
     * Creates a quantitative value without a JSON-LD {@code @id}.
     *
     * @param minValue the minimum value of the range
     * @param maxValue the maximum value of the range
     * @param unitCode the unit of measurement
     */
    public StructuredDataQuantitativeValue(
            int minValue,
            int maxValue,
            UnitCode unitCode
    ) {
        this(null, minValue, maxValue, unitCode);
    }

    /**
     * @param id       the JSON-LD {@code @id} for this value; may be {@code null}
     * @param minValue the minimum value of the range
     * @param maxValue the maximum value of the range
     * @param unitCode the unit of measurement
     */
    public StructuredDataQuantitativeValue(
            String id,
            int minValue,
            int maxValue,
            UnitCode unitCode
    ) {
        super(id);
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.unitCode = unitCode;
    }

    @Override
    public String getType() {
        return "QuantitativeValue";
    }

    public int getMinValue() {
        return this.minValue;
    }

    public int getMaxValue() {
        return this.maxValue;
    }

    public UnitCode getUnitCode() {
        return this.unitCode;
    }

    /**
     * UN/CEFACT unit codes used by {@code QuantitativeValue}.
     *
     * @see <a href="https://www.unece.org/cefact/codesfortrade/codes_index.html">UN/CEFACT Codes</a>
     */
    public enum UnitCode {
        /**
         * Day — UN/CEFACT unit code {@code DAY}.
         */
        DAY;

        /**
         * @return the UN/CEFACT string code for this unit
         */
        public String getValue() {
            return this.name();
        }
    }

}
