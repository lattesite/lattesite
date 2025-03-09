package lattesite.structureddata.schemas.product;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.audience.StructuredDataPeopleAudience;
import lattesite.structureddata.schemas.brand.StructuredDataBrand;
import lattesite.structureddata.schemas.offer.StructuredDataOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Schema.org {@code Product}.
 *
 * <p>EAN, GTIN, awards, and reviews are optional and can be set after construction.
 * Additional properties can be added incrementally via {@link #addAdditionalProperty}.</p>
 *
 * @see <a href="https://schema.org/Product">Schema.org/Product</a>
 */
public class StructuredDataProduct extends StructuredDataSchema {

    private final String name;
    private final String description;
    private final List<String> categories;
    private final List<String> imageURLs;
    private final String sku;
    private final StructuredDataOffer offers;
    private final StructuredDataPeopleAudience audience;
    private final StructuredDataBrand brand;
    private final List<StructuredDataPropertyValue> additionalProperties;
    private List<String> awards;
    private String ean;
    private String gtin;
    private List<StructuredDataReview> reviews;

    /**
     * @param id          the JSON-LD {@code @id} for this product
     * @param name        the product name
     * @param description a short description of the product
     * @param categories  the product categories
     * @param imageURLs   URLs of product images
     * @param sku         the stock-keeping unit identifier
     * @param offers      the product offer with pricing information
     * @param audience    the intended audience; may be {@code null}
     * @param brand       the product brand; may be {@code null}
     */
    public StructuredDataProduct(
            String id,
            String name,
            String description,
            List<String> categories,
            List<String> imageURLs,
            String sku,
            StructuredDataOffer offers,
            StructuredDataPeopleAudience audience,
            StructuredDataBrand brand
    ) {
        super(id);
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.imageURLs = imageURLs;
        this.sku = sku;
        this.offers = offers;
        this.audience = audience;
        this.brand = brand;
        this.additionalProperties = new ArrayList<>();
        this.awards = new ArrayList<>();
        this.ean = "";
        this.gtin = "";
        this.reviews = new ArrayList<>();
    }

    @Override
    public String getType() {
        return "Product";
    }

    public String getGtin() {
        return this.gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = gtin;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public List<String> getCategories() {
        return this.categories;
    }

    public List<String> getImageURLs() {
        return this.imageURLs;
    }

    public String getSKU() {
        return this.sku;
    }

    public String getEAN() {
        return this.ean;
    }

    public void setEAN(String ean) {
        this.ean = ean;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public StructuredDataBrand getBrand() {
        return this.brand;
    }

    public StructuredDataPeopleAudience getAudience() {
        return this.audience;
    }

    public List<String> getAwards() {
        return this.awards;
    }

    public StructuredDataOffer getOffers() {
        return this.offers;
    }

    public List<StructuredDataPropertyValue> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void addAdditionalProperty(StructuredDataPropertyValue structuredDataPropertyValue) {
        this.additionalProperties.add(structuredDataPropertyValue);
    }

    public void setReviews(List<StructuredDataReview> reviews) {
        this.reviews = reviews;
    }

    public List<StructuredDataReview> getReviews() {
        return this.reviews;
    }

}
