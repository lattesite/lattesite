package lattesite.googlemerchant.interfaces;

import lattesite.googlemerchant.enumerations.*;

import java.util.List;
import java.util.Map;

/**
 * Represents a product to be included in a Google Merchant Center feed.
 * Implement this interface to adapt your domain model to the feed generator.
 */
public interface GoogleMerchantProduct {

    /**
     * @return the unique product identifier (maps to {@code g:id})
     */
    String getID();

    /**
     * @return the stock-keeping unit, or {@code null} to omit the field
     */
    String getSKU();

    /**
     * @return the item group ID for product variants, or {@code null} to omit the field
     */
    String getGroupID();

    /**
     * @return the European Article Number, or {@code null} to omit the field
     */
    String getEAN();

    /**
     * @return the product description (maps to {@code g:description})
     */
    String getDescription() throws Exception;

    /**
     * @return the product title (maps to {@code g:title})
     */
    String getTitle();

    /**
     * @return the ISO 4217 currency code (e.g. {@code "USD"}, {@code "EUR"})
     */
    String getCurrency();

    /**
     * @return the price as a string (e.g. {@code "19.99"}), combined with {@link #getCurrency()} in the feed
     */
    String getPrice() throws Exception;

    /**
     * @return list of image URLs; the first entry maps to {@code g:image_link}, the rest to {@code g:additional_image_link}
     */
    List<String> getImageURLs();

    /**
     * @return the Google product category (maps to {@code g:google_product_category})
     */
    ProductCategory getProductCategory();

    /**
     * @return the brand name (maps to {@code g:brand})
     */
    String getBrand();

    /**
     * @return the canonical product URL (maps to {@code g:link})
     */
    String getLink() throws Exception;

    /**
     * @return the availability status (maps to {@code g:availability})
     */
    ProductAvailability getAvailability();

    /**
     * @return additional product-specific key/value attributes written as {@code g:product_detail} entries,
     * or {@code null} to omit the section
     */
    Map<String, String> getProperties() throws Exception;

    /**
     * @return the date the product becomes available in ISO 8601 format, or {@code null} to omit the field
     */
    String getAvailabilityDate();

    /**
     * @return the list of product type breadcrumbs (maps to {@code g:product_type}); may be empty
     */
    List<String> getTypes();

    /**
     * @return the Global Trade Item Number, or {@code null} to omit the field
     */
    String getGTIN();

    /**
     * @return the Manufacturer Part Number, or {@code null} to omit the field
     */
    String getMPN();

    /**
     * @return the product condition (maps to {@code g:condition})
     */
    Condition getCondition();

    /**
     * @return the target age group, or {@code null} to omit the field
     */
    AgeGroup getAgeGroup();

    /**
     * @return {@code true} if the product is restricted to adults (maps to {@code g:adult})
     */
    boolean isAdult();

    /**
     * @return the product color (maps to {@code g:color})
     */
    String getColor();

    /**
     * @return the target gender (maps to {@code g:gender})
     */
    Gender getGender();

    /**
     * @return the primary material (maps to {@code g:material})
     */
    String getMaterial();

    /**
     * @return the size value (maps to {@code g:size})
     */
    String getSize();

    /**
     * @return the size system used (maps to {@code g:size_system})
     */
    SizeSystem getSizeSystem();

    /**
     * @return the product length with unit (e.g. {@code "30 cm"}), or {@code null} to omit the field
     */
    String getProductLength();

    /**
     * @return the product height with unit (e.g. {@code "10 cm"}), or {@code null} to omit the field
     */
    String getProductHeight();

    /**
     * @return the product width with unit (e.g. {@code "20 cm"}), or {@code null} to omit the field
     */
    String getProductWidth();

    /**
     * @return the product weight with unit (e.g. {@code "500 grams"}), or {@code null} to omit the field
     */
    String getProductWeight();

}
