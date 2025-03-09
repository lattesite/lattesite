package lattesite.structureddata.schemas.audience;

import lattesite.structureddata.enumeration.SuggestedGender;
import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;

/**
 * Represents a Schema.org {@code PeopleAudience} — a target audience defined by geography and gender.
 *
 * @see <a href="https://schema.org/PeopleAudience">Schema.org/PeopleAudience</a>
 */
public class StructuredDataPeopleAudience extends StructuredDataSchema {

    private final StructuredDataCountry geographicArea;
    private final String audienceType;
    private final SuggestedGender suggestedGender;

    /**
     * @param id              the JSON-LD {@code @id} for this audience
     * @param geographicArea  the country this audience is in
     * @param audienceType    a description of the audience type (e.g. {@code "Adults"})
     * @param suggestedGender the suggested gender for this audience
     */
    public StructuredDataPeopleAudience(
            String id,
            StructuredDataCountry geographicArea,
            String audienceType,
            SuggestedGender suggestedGender
    ) {
        super(id);
        this.geographicArea = geographicArea;
        this.audienceType = audienceType;
        this.suggestedGender = suggestedGender;
    }

    @Override
    public String getType() {
        return "PeopleAudience";
    }

    public StructuredDataCountry getGeographicArea() {
        return this.geographicArea;
    }

    public String getAudienceType() {
        return this.audienceType;
    }

    public SuggestedGender getSuggestedGender() {
        return this.suggestedGender;
    }

}
