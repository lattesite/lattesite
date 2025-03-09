package lattesite.structureddata.schemas.offer;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code ShippingDeliveryTime} — the estimated time from order to delivery.
 *
 * @see <a href="https://schema.org/ShippingDeliveryTime">Schema.org/ShippingDeliveryTime</a>
 */
public class StructuredDataShippingDeliveryTime extends StructuredDataSchema {

    private final StructuredDataQuantitativeValue handlingTime;
    private final StructuredDataQuantitativeValue transitTime;

    /**
     * @param id           the JSON-LD {@code @id} for this delivery time
     * @param handlingTime the time to prepare and dispatch the order
     * @param transitTime  the time for the shipment to travel to the destination
     */
    public StructuredDataShippingDeliveryTime(
            String id,
            StructuredDataQuantitativeValue handlingTime,
            StructuredDataQuantitativeValue transitTime
    ) {
        super(id);
        this.handlingTime = handlingTime;
        this.transitTime = transitTime;
    }

    @Override
    public String getType() {
        return "ShippingDeliveryTime";
    }

    public StructuredDataQuantitativeValue getHandlingTime() {
        return this.handlingTime;
    }

    public StructuredDataQuantitativeValue getTransitTime() {
        return this.transitTime;
    }

}
