package lattesite.structureddata.schemas.offer;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.geo.StructuredDataDefinedRegion;

/**
 * Represents a Schema.org {@code OfferShippingDetails} — shipping rate, destination, and delivery time for an offer.
 *
 * @see <a href="https://schema.org/OfferShippingDetails">Schema.org/OfferShippingDetails</a>
 */
public class StructuredDataOfferShippingDetails extends StructuredDataSchema {

    private final StructuredDataMonetaryAmount shippingRate;
    private final StructuredDataDefinedRegion shippingDestination;
    private final StructuredDataShippingDeliveryTime deliveryTime;

    /**
     * @param id                  the JSON-LD {@code @id} for these shipping details
     * @param shippingRate        the shipping cost
     * @param shippingDestination the region this shipping applies to
     * @param deliveryTime        the estimated delivery time
     */
    public StructuredDataOfferShippingDetails(
            String id,
            StructuredDataMonetaryAmount shippingRate,
            StructuredDataDefinedRegion shippingDestination,
            StructuredDataShippingDeliveryTime deliveryTime
    ) {
        super(id);
        this.shippingRate = shippingRate;
        this.shippingDestination = shippingDestination;
        this.deliveryTime = deliveryTime;
    }

    @Override
    public String getType() {
        return "OfferShippingDetails";
    }

    public StructuredDataMonetaryAmount getShippingRate() {
        return this.shippingRate;
    }

    public StructuredDataDefinedRegion getShippingDestination() {
        return this.shippingDestination;
    }

    public StructuredDataShippingDeliveryTime getDeliveryTime() {
        return this.deliveryTime;
    }

}
