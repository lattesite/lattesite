package lattesite.structured.data.schemas;

import lattesite.structured.data.enumeration.GenderType;

public class StructuredDataPeopleAudience {

    private final StructuredDataCountry geographicArea;
    private final String audienceType;
    private final GenderType suggestedGender;

    public StructuredDataPeopleAudience(
            StructuredDataCountry geographicArea,
            String audienceType,
            GenderType suggestedGender
    ) {
        this.geographicArea = geographicArea;
        this.audienceType = audienceType;
        this.suggestedGender = suggestedGender;
    }

    public StructuredDataCountry getGeographicArea() {
        return this.geographicArea;
    }

    public String getAudienceType() {
        return this.audienceType;
    }

    public GenderType getSuggestedGender() {
        return this.suggestedGender;
    }

}
