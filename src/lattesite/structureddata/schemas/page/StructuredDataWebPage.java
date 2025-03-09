package lattesite.structureddata.schemas.page;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.audience.StructuredDataPeopleAudience;
import lattesite.structureddata.schemas.language.StructuredDataLanguage;
import lattesite.structureddata.schemas.person.StructuredDataPerson;
import lattesite.structureddata.schemas.website.StructuredDataWebSite;

/**
 * Represents a Schema.org {@code WebPage}.
 *
 * <p>Optional audience and reviewer can be set after construction.</p>
 *
 * @see <a href="https://schema.org/WebPage">Schema.org/WebPage</a>
 */
public class StructuredDataWebPage extends StructuredDataSchema {

    private final String name;
    private final String url;
    private final String description;
    private final StructuredDataWebSite isPartOf;
    private final StructuredDataLanguage inLanguage;
    private StructuredDataPeopleAudience audience;
    private StructuredDataPerson reviewedBy;

    /**
     * @param id          the JSON-LD {@code @id} for this page
     * @param name        the page title
     * @param url         the canonical URL of the page
     * @param description a short description of the page
     * @param isPartOf    the website this page belongs to
     * @param inLanguage  the primary language of the page content
     */
    public StructuredDataWebPage(
            String id,
            String name,
            String url,
            String description,
            StructuredDataWebSite isPartOf,
            StructuredDataLanguage inLanguage
    ) {
        super(id);
        this.name = name;
        this.url = url;
        this.description = description;
        this.isPartOf = isPartOf;
        this.inLanguage = inLanguage;
        this.audience = null;
        this.reviewedBy = null;
    }

    @Override
    public String getType() {
        return "WebPage";
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public String getURL() {
        return this.url;
    }

    public StructuredDataWebSite getIsPartOf() {
        return this.isPartOf;
    }

    public void setAudience(StructuredDataPeopleAudience audience) {
        this.audience = audience;
    }

    public StructuredDataPeopleAudience getAudience() {
        return this.audience;
    }

    public StructuredDataLanguage getInLanguage() {
        return this.inLanguage;
    }

    public void setReviewedBy(StructuredDataPerson reviewedBy) {
        this.reviewedBy = reviewedBy;
    }

    public StructuredDataPerson getReviewedBy() {
        return this.reviewedBy;
    }

}
