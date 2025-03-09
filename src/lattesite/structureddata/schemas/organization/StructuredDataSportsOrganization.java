package lattesite.structureddata.schemas.organization;

import lattesite.structureddata.enumeration.IsicV4Category;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;

/**
 * Represents a Schema.org {@code SportsOrganization}.
 *
 * @see <a href="https://schema.org/SportsOrganization">Schema.org/SportsOrganization</a>
 */
public class StructuredDataSportsOrganization extends StructuredDataOrganization {

    public StructuredDataSportsOrganization(
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
        return "SportsOrganization";
    }

}
