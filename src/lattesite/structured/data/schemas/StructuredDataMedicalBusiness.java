package lattesite.structured.data.schemas;

public class StructuredDataMedicalBusiness extends StructuredDataOrganization {

    public StructuredDataMedicalBusiness(
            String name,
            String url,
            String description,
            StructuredDataCountry areaServed,
            String[] isicV4Categories,
            String keywords,
            String knowsAbout
    ) {
        super(
                "MedicalBusiness",
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
