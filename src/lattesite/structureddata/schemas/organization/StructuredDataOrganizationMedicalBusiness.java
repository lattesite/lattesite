package lattesite.structureddata.schemas.organization;

import lattesite.structureddata.enumeration.IsicV4Category;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;

/**
 * Represents a Schema.org {@code MedicalBusiness} organization.
 *
 * @see <a href="https://schema.org/MedicalBusiness">Schema.org/MedicalBusiness</a>
 */
public class StructuredDataOrganizationMedicalBusiness extends StructuredDataOrganization {

    public StructuredDataOrganizationMedicalBusiness(
            String id,
            String name,
            String url,
            String description,
            StructuredDataCountry areaServed,
            IsicV4Category[] isicV4Categories,
            String keywords,
            String knowsAbout
    ) {
        super(
                id,
                name,
                url,
                description,
                areaServed,
                isicV4Categories,
                keywords,
                knowsAbout
        );
    }

    @Override
    final public String getType() {
        return "MedicalBusiness";
    }

}
