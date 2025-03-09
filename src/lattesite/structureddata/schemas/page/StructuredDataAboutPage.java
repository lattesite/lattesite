package lattesite.structureddata.schemas.page;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.organization.StructuredDataOrganization;

/**
 * Represents a Schema.org {@code AboutPage} — a web page that describes an organization.
 *
 * @see <a href="https://schema.org/AboutPage">Schema.org/AboutPage</a>
 */
public class StructuredDataAboutPage extends StructuredDataSchema {

    private final String name;
    private final String url;
    private final StructuredDataOrganization organization;

    /**
     * @param id           the JSON-LD {@code @id} for this page
     * @param name         the page title
     * @param url          the canonical URL of the page
     * @param organization the organization this page is about
     */
    public StructuredDataAboutPage(
            String id,
            String name,
            String url,
            StructuredDataOrganization organization
    ) {
        super(id);
        this.name = name;
        this.url = url;
        this.organization = organization;
    }

    @Override
    public String getType() {
        return "AboutPage";
    }

    public String getURL() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public StructuredDataOrganization getOrganization() {
        return this.organization;
    }

}
