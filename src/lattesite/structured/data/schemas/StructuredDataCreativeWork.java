package lattesite.structured.data.schemas;

public class StructuredDataCreativeWork implements StructuredDataSchema {

    private final String name;
    private final String description;
    private final String url;
    private String image;
    private String headline;
    private StructuredDataPerson creatorPerson;
    private StructuredDataPerson authorPerson;
    private StructuredDataPerson publisherPerson;

    public StructuredDataCreativeWork(
            String name,
            String description,
            String url
    ) {
        this.name = name;
        this.description = description;
        this.url = url;
        this.headline = null;
        this.image = null;
        this.creatorPerson = null;
        this.authorPerson = null;
        this.publisherPerson = null;
    }

    @Override
    public String getType() {
        return "CreativeWork";
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

    public void setImage(String image) {
        this.image = image;
    }

    public String getImage() {
        return this.image;
    }

    public StructuredDataPerson getPublisherPerson() {
        return publisherPerson;
    }

    public void setPublisher(StructuredDataPerson publisherPerson) {
        this.publisherPerson = publisherPerson;
    }

    public StructuredDataPerson getAuthorPerson() {
        return authorPerson;
    }

    public void setAuthor(StructuredDataPerson authorPerson) {
        this.authorPerson = authorPerson;
    }

    public StructuredDataPerson getCreatorPerson() {
        return creatorPerson;
    }

    public void setCreator(StructuredDataPerson creatorPerson) {
        this.creatorPerson = creatorPerson;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }
}
