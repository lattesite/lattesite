package lattesite.structureddata.schemas.organization;

import lattesite.structureddata.enumeration.IsicV4Category;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;

/**
 * Represents an online business organization.
 *
 * <p>This class does not override {@link #getType()} and therefore serializes with the
 * {@code "Organization"} type. Use this when no more specific Schema.org online-business
 * subtype applies.</p>
 *
 * @see <a href="https://schema.org/Organization">Schema.org/Organization</a>
 */
public class StructuredDataOrganizationOnlineBusiness extends StructuredDataOrganization {

    public StructuredDataOrganizationOnlineBusiness(
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

}
