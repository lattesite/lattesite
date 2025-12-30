package lattesite.structured.data.schemas;

import lattesite.structured.data.enumeration.IsicV4Category;

public class StructuredDataOrganizationMedicalClinic extends StructuredDataOrganization {

    public StructuredDataOrganizationMedicalClinic(
            String name,
            String url,
            String description,
            StructuredDataCountry areaServed,
            IsicV4Category[] isicV4Categories,
            String keywords,
            String knowsAbout
    ) {
        super(
                name,
                url,
                description,
                areaServed,
                isicV4Categories,
                keywords,
                knowsAbout
        );
    }

    public String getType() {
        return "MedicalClinic";
    }

}
