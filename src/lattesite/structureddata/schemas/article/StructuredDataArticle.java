package lattesite.structureddata.schemas.article;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.audience.StructuredDataPeopleAudience;
import lattesite.structureddata.schemas.organization.StructuredDataOrganization;
import lattesite.structureddata.schemas.person.StructuredDataPerson;

/**
 * Base class for Schema.org article types ({@code Article}, {@code BlogPosting}, {@code TechArticle}).
 *
 * <p>Publisher and author are optional and can be set after construction. Subclasses override
 * {@link #getType()} to return the specific Schema.org type name.</p>
 *
 * @see <a href="https://schema.org/Article">Schema.org/Article</a>
 */
public class StructuredDataArticle extends StructuredDataSchema {

    private final String inLanguage;
    private final String headline;
    private final String articleSection;
    private final String articleBody;
    private final String image;
    private final String description;
    private final String dateModified;
    private final String datePublished;
    private final String url;
    private final StructuredDataPeopleAudience audience;
    private StructuredDataOrganization publisherOrganization;
    private StructuredDataPerson author;

    /**
     * @param id             the JSON-LD {@code @id} for this article
     * @param inLanguage     the BCP 47 language tag (e.g. {@code "en"})
     * @param headline       the article headline
     * @param articleSection the section or category of the article
     * @param articleBody    the full text body of the article
     * @param image          the URL of the article's main image
     * @param description    a short description of the article
     * @param dateModified   the date the article was last modified (ISO 8601)
     * @param datePublished  the date the article was first published (ISO 8601)
     * @param url            the canonical URL of the article
     * @param audience       the intended audience; may be {@code null}
     */
    protected StructuredDataArticle(
            String id,
            String inLanguage,
            String headline,
            String articleSection,
            String articleBody,
            String image,
            String description,
            String dateModified,
            String datePublished,
            String url,
            StructuredDataPeopleAudience audience
    ) {
        super(id);
        this.inLanguage = inLanguage;
        this.headline = headline;
        this.articleSection = articleSection;
        this.articleBody = articleBody;
        this.image = image;
        this.description = description;
        this.dateModified = dateModified;
        this.datePublished = datePublished;
        this.url = url;
        this.publisherOrganization = null;
        this.audience = audience;
        this.author = null;
    }

    @Override
    public String getType() {
        return "Article";
    }

    public void setPublisherOrganization(StructuredDataOrganization publisherOrganization) {
        this.publisherOrganization = publisherOrganization;
    }

    public void setAuthor(StructuredDataPerson author) {
        this.author = author;
    }

    public String getHeadline() {
        return this.headline;
    }

    public String getArticleSection() {
        return this.articleSection;
    }

    public String getArticleBody() {
        return this.articleBody;
    }

    public String getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public String getDateModified() {
        return this.dateModified;
    }

    public String getDatePublished() {
        return this.datePublished;
    }

    public String getURL() {
        return this.url;
    }

    public StructuredDataPerson getAuthor() {
        return this.author;
    }

    public StructuredDataPeopleAudience getAudience() {
        return this.audience;
    }

    public StructuredDataOrganization getPublisherOrganization() {
        return this.publisherOrganization;
    }

    public String getInLanguage() {
        return this.inLanguage;
    }

    public String getDateCreated() {
        return this.getDatePublished();
    }

}
