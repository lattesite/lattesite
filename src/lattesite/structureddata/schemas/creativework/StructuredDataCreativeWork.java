package lattesite.structureddata.schemas.creativework;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.offer.StructuredDataOffer;
import lattesite.structureddata.schemas.organization.StructuredDataOrganization;
import lattesite.structureddata.schemas.person.StructuredDataPerson;

/**
 * Represents a Schema.org {@code CreativeWork} — the base class for creative works such as software and web apps.
 *
 * <p>Image, headline, creator, author, publisher, and offers are optional and can be set after construction.</p>
 *
 * @see <a href="https://schema.org/CreativeWork">Schema.org/CreativeWork</a>
 */
public class StructuredDataCreativeWork extends StructuredDataSchema {

    private final String name;
    private final String description;
    private final String url;
    private String image;
    private String headline;
    private StructuredDataPerson creatorPerson;
    private StructuredDataPerson authorPerson;
    private StructuredDataOrganization publisherOrganization;
    private StructuredDataPerson publisherPerson;
    private StructuredDataOffer offers;

    /**
     * @param id          the JSON-LD {@code @id} for this creative work
     * @param name        the name of the work
     * @param description a short description of the work
     * @param url         the canonical URL of the work
     */
    public StructuredDataCreativeWork(
            String id,
            String name,
            String description,
            String url
    ) {
        super(id);
        this.name = name;
        this.description = description;
        this.url = url;
        this.headline = null;
        this.image = null;
        this.creatorPerson = null;
        this.authorPerson = null;
        this.publisherOrganization = null;
        this.publisherPerson = null;
        this.offers = null;
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

    public StructuredDataOrganization getPublisherOrganization() {
        return this.publisherOrganization;
    }

    public StructuredDataPerson getPublisherPerson() {
        return this.publisherPerson;
    }

    public void setPublisher(StructuredDataOrganization publisherOrganization) {
        this.publisherOrganization = publisherOrganization;
    }

    public void setPublisher(StructuredDataPerson publisherPerson) {
        this.publisherPerson = publisherPerson;
    }

    public StructuredDataPerson getAuthorPerson() {
        return this.authorPerson;
    }

    public void setAuthor(StructuredDataPerson authorPerson) {
        this.authorPerson = authorPerson;
    }

    public StructuredDataPerson getCreatorPerson() {
        return this.creatorPerson;
    }

    public void setCreator(StructuredDataPerson creatorPerson) {
        this.creatorPerson = creatorPerson;
    }

    public String getHeadline() {
        return this.headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public void setOffers(StructuredDataOffer offers) {
        this.offers = offers;
    }

    public StructuredDataOffer getOffers() {
        return this.offers;
    }

}
