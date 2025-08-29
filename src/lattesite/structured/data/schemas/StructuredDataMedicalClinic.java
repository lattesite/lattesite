package lattesite.structured.data.schemas;

public class StructuredDataMedicalClinic extends StructuredDataOrganization {

    public StructuredDataMedicalClinic(
            String name,
            String url,
            String description,
            StructuredDataCountry areaServed,
            String[] isicV4Categories,
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
