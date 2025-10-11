package lattesite.structured.data.schemas;

import lattesite.structured.data.enumeration.IsicV4Category;

public class StructuredDataMedicalClinic extends StructuredDataOrganization {

    public StructuredDataMedicalClinic(
            String name,
            String url,
            String description,
            StructuredDataCountry areaServed,
            IsicV4Category[] isicV4Categories,
            String keywords,
            String knowsAbout
    ) {
        super(
                "MedicalClinic",
                name,
                url,
                description,
                areaServed,
                isicV4Categories,
                keywords,
                knowsAbout
        );
    }

}
