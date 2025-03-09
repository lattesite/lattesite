package lattesite.structureddata.schemas.offer;

import lattesite.structureddata.enumeration.ItemAvailability;
import lattesite.structureddata.enumeration.OfferItemCondition;
import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.organization.StructuredDataOrganization;

/**
 * Represents a Schema.org {@code Offer} — a product or service offer with pricing details.
 *
 * <p>Shipping details, return policy, availability, condition, and category are optional
 * and can be set after construction.</p>
 *
 * @see <a href="https://schema.org/Offer">Schema.org/Offer</a>
 */
public class StructuredDataOffer extends StructuredDataSchema {

    private final String url;
    private final String priceCurrency;
    private final String price;
    private final String priceValidUntil;
    private final StructuredDataOrganization seller;
    private StructuredDataOfferShippingDetails shippingDetails;
    private StructuredDataMerchantReturnPolicy hasMerchantReturnPolicy;
    private ItemAvailability availability;
    private OfferItemCondition itemCondition;
    private String category;

    /**
     * @param id              the JSON-LD {@code @id} for this offer
     * @param url             the URL of the product page for this offer
     * @param priceCurrency   the ISO 4217 currency code (e.g. {@code "SEK"})
     * @param price           the offer price as a string (e.g. {@code "299.00"})
     * @param priceValidUntil the date until which the price is valid (ISO 8601 date)
     * @param seller          the organization making this offer
     */
    public StructuredDataOffer(
            String id,
            String url,
            String priceCurrency,
            String price,
            String priceValidUntil,
            StructuredDataOrganization seller
    ) {
        super(id);
        this.url = url;
        this.priceCurrency = priceCurrency;
        this.price = price;
        this.priceValidUntil = priceValidUntil;
        this.seller = seller;
        this.shippingDetails = null;
        this.hasMerchantReturnPolicy = null;
        this.availability = null;
        this.itemCondition = null;
        this.category = null;
    }

    @Override
    public String getType() {
        return "Offer";
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return this.category;
    }

    public void setShippingDetails(StructuredDataOfferShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public void setHasMerchantReturnPolicy(StructuredDataMerchantReturnPolicy hasMerchantReturnPolicy) {
        this.hasMerchantReturnPolicy = hasMerchantReturnPolicy;
    }

    public void setAvailability(ItemAvailability availability) {
        this.availability = availability;
    }

    public void setItemCondition(OfferItemCondition itemCondition) {
        this.itemCondition = itemCondition;
    }

    public String getURL() {
        return this.url;
    }

    public String getPriceCurrency() {
        return this.priceCurrency;
    }

    public String getPrice() {
        return this.price;
    }

    public String getPriceValidUntil() {
        return this.priceValidUntil;
    }

    public ItemAvailability getAvailability() {
        return this.availability;
    }

    public OfferItemCondition getItemCondition() {
        return this.itemCondition;
    }

    public StructuredDataOrganization getSeller() {
        return this.seller;
    }

    public StructuredDataOfferShippingDetails getShippingDetails() {
        return this.shippingDetails;
    }

    public StructuredDataMerchantReturnPolicy getHasMerchantReturnPolicy() {
        return this.hasMerchantReturnPolicy;
    }

}
