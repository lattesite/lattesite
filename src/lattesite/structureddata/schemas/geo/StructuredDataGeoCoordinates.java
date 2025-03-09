package lattesite.structureddata.schemas.geo;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code GeoCoordinates} — a geographic location defined by latitude and longitude.
 *
 * <p>An optional address country can be set via {@link #setAddressCountry(StructuredDataCountry)}.</p>
 *
 * @see <a href="https://schema.org/GeoCoordinates">Schema.org/GeoCoordinates</a>
 */
public class StructuredDataGeoCoordinates extends StructuredDataSchema {

    private final String latitude;
    private final String longitude;
    private StructuredDataCountry addressCountry;

    /**
     * @param id        the JSON-LD {@code @id} for these coordinates
     * @param latitude  the latitude in decimal degrees (e.g. {@code "59.3293"})
     * @param longitude the longitude in decimal degrees (e.g. {@code "18.0686"})
     */
    public StructuredDataGeoCoordinates(
            String id,
            String latitude,
            String longitude
    ) {
        super(id);
        this.latitude = latitude;
        this.longitude = longitude;
        this.addressCountry = null;
    }

    @Override
    public String getType() {
        return "GeoCoordinates";
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
        return this.addressCountry;
    }
}
