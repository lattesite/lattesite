package lattesite.structured.data.schemas;

import java.util.ArrayList;
import java.util.List;

public class StructuredDataProduct implements StructuredDataSchema {

    private final String name;
    private final String description;
    private final List<String> categories;
    private final List<String> imageURLs;
    private final String sku;
    private final double price;
    private final boolean inStock;
    private final StructuredDataOffer offers;
    private final StructuredDataPeopleAudience audience;
    private final StructuredDataBrand brand;
    private final List<StructuredDataPropertyValue> additionalProperties;
    private List<String> awards;
    private String ean;
    private String gtin;

    public StructuredDataProduct(
            String name,
            String description,
            List<String> categories,
            List<String> imageURLs,
            String sku,
            double price,
            boolean inStock,
            StructuredDataOffer offers,
            StructuredDataPeopleAudience audience,
            StructuredDataBrand brand
    ) {
        this.name = name;
        this.description = description;
        this.categories = categories;
        this.imageURLs = imageURLs;
        this.sku = sku;
        this.price = price;
        this.inStock = inStock;
        this.offers = offers;
        this.audience = audience;
        this.brand = brand;
        this.additionalProperties = new ArrayList<>();
        this.awards = new ArrayList<>();
        this.ean = "";
        this.gtin = "";
    }

    @Override
    public String getType() {
        return "Product";
    }

    public String getGtin() {
        return this.gtin;
    }

    public void setGtin(String gtin) {
        this.gtin = this.gtin;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public List<String> getImageURLs() {
        return imageURLs;
    }

    public String getSKU() {
        return sku;
    }

    public String getEAN() {
        return ean;
    }

    public void setEAN(String ean) {
        this.ean = ean;
    }

    public void setAwards(List<String> awards) {
        this.awards = awards;
    }

    public double getPrice() {
        return price;
    }

    public boolean isInStock() {
        return inStock;
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

}
