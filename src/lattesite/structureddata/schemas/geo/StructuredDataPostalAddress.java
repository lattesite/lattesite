package lattesite.structureddata.schemas.geo;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code PostalAddress}.
 *
 * <p>An optional address region (state or province) can be set via {@link #setAddressRegion(String)}.</p>
 *
 * @see <a href="https://schema.org/PostalAddress">Schema.org/PostalAddress</a>
 */
public class StructuredDataPostalAddress extends StructuredDataSchema {

    private final String streetAddress;
    private final String postalCode;
    private final String addressLocality;
    private final StructuredDataCountry addressCountry;
    private String addressRegion;

    /**
     * @param id              the JSON-LD {@code @id} for this address
     * @param streetAddress   the street address (e.g. {@code "123 Main St"})
     * @param postalCode      the postal or ZIP code
     * @param addressLocality the city or locality name
     * @param addressCountry  the country
     */
    public StructuredDataPostalAddress(
            String id,
            String streetAddress,
            String postalCode,
            String addressLocality,
            StructuredDataCountry addressCountry
    ) {
        super(id);
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.addressLocality = addressLocality;
        this.addressCountry = addressCountry;
        this.addressRegion = null;
    }

    @Override
    public String getType() {
        return "PostalAddress";
    }

    public void setAddressRegion(String addressRegion) {
        this.addressRegion = addressRegion;
    }

    public String getStreetAddress() {
        return this.streetAddress;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public String getAddressLocality() {
        return this.addressLocality;
    }

    public StructuredDataCountry getAddressCountry() {
        return this.addressCountry;
    }

    public String getAddressRegion() {
        return this.addressRegion;
    }

}
