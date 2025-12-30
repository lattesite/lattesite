package lattesite.structured.data.schemas;

public class StructuredDataArticle {

    private final String type;
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
    private StructuredDataPerson reviewer;

    public StructuredDataArticle(
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
        this(
                "Article",
                headline,
                articleSection,
                articleBody,
                image,
                description,
                dateModified,
                datePublished,
                url,
                audience
        );
    }

    protected StructuredDataArticle(
            String type,
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
        this.type = type;
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
        this.reviewer = null;
    }

    public void setPublisherOrganization(StructuredDataOrganization publisherOrganization) {
        this.publisherOrganization = publisherOrganization;
    }

    public void setAuthor(StructuredDataPerson author) {
        this.author = author;
    }

    public void setReviewer(StructuredDataPerson reviewer) {
        this.reviewer = reviewer;
    }

    public String getHeadline() {
        return headline;
    }

    public String getArticleSection() {
        return articleSection;
    }

    public String getArticleBody() {
        return articleBody;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getDateModified() {
        return dateModified;
    }

    public String getDatePublished() {
        return this.datePublished;
    }

    public String getURL() {
        return url;
    }

    public StructuredDataPerson getAuthor() {
        return author;
    }

    public StructuredDataPerson getReviewer() {
        return reviewer;
    }

    public StructuredDataPeopleAudience getAudience() {
        return this.audience;
    }

    public StructuredDataOrganization getPublisherOrganization() {
        return this.publisherOrganization;
    }

    public String getType() {
        return this.type;
    }

}
