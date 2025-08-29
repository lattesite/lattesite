package lattesite.structured.data.schemas;

public class StructuredDataGeoCoordinates {

    private final String latitude;
    private final String longitude;
    private StructuredDataCountry addressCountry;

    public StructuredDataGeoCoordinates(
            String latitude,
            String longitude
    ) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.addressCountry = null;
    }

    public String getLatitude() {
        return this.latitude;
    }

    public String getLongitude() {
        return this.longitude;
    }

    public void setAddressCountry(StructuredDataCountry addressCountry) {
        this.addressCountry = addressCountry;
    }

    public StructuredDataCountry getAddressCountry() {
        return addressCountry;
    }
}
