package lattesite.structured.data.schemas;

public class StructuredDataPostalAddress {

    private final String streetAddress;
    private final String postalCode;
    private final String addressLocality;
    private final StructuredDataCountry addressCountry;
    private String addressRegion;

    public StructuredDataPostalAddress(
            String streetAddress,
            String postalCode,
            String addressLocality,
            StructuredDataCountry addressCountry
    ) {
        this.streetAddress = streetAddress;
        this.postalCode = postalCode;
        this.addressLocality = addressLocality;
        this.addressCountry = addressCountry;
        this.addressRegion = null;
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
