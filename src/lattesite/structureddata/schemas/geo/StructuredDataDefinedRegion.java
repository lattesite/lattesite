package lattesite.structureddata.schemas.geo;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code DefinedRegion} identified by an ISO 3166-1 country code.
 *
 * <p>Used to specify geographic regions for shipping destinations and similar purposes.</p>
 *
 * @see <a href="https://schema.org/DefinedRegion">Schema.org/DefinedRegion</a>
 */
public class StructuredDataDefinedRegion extends StructuredDataSchema {

    private final String addressCountry;

    /**
     * @param id             the JSON-LD {@code @id} for this region
     * @param addressCountry the ISO 3166-1 alpha-2 country code (e.g. {@code "SE"})
     */
    public StructuredDataDefinedRegion(
            String id,
            String addressCountry
    ) {
        super(id);
        this.addressCountry = addressCountry;
    }

    @Override
    public String getType() {
        return "DefinedRegion";
    }

    public String getAddressCountry() {
        return this.addressCountry;
    }

}
