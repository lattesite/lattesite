package lattesite.googlemerchant.examples;

import lattesite.googlemerchant.enumerations.*;
import lattesite.googlemerchant.interfaces.GoogleMerchantProduct;
import lattesite.googlemerchant.services.GoogleMerchantService;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Demonstrates minimal usage of {@link lattesite.google.merchant.services.GoogleMerchantService}.
 *
 * <p>Run {@link #main} to generate a sample XML feed and print it to standard output.
 */
public class MainQuickExample {

    /**
     * Entry point. Creates a {@link lattesite.google.merchant.services.GoogleMerchantService}, adds two
     * example products, generates the XML feed, and prints it.
     *
     * @param args command-line arguments (unused)
     * @throws Exception if feed generation fails
     */
    public static void main(String[] args) throws Exception {

        GoogleMerchantService googleMerchantService = new GoogleMerchantService(
                "My awesome online store!",
                "Here you can buy the next big thing!",
                "https://www.store.com/"
        );

        List<MyProduct> products = new ArrayList<>();
        products.add(new MyProduct("Anna", "sku_anna", "199"));
        products.add(new MyProduct("Steve", "sku_steve", "149.99"));

        String xml = googleMerchantService.generate(products);
        System.out.println(xml);
    }

    /**
     * A minimal {@link lattesite.google.merchant.interfaces.Product} implementation used by this example.
     * In a real application, implement {@link lattesite.google.merchant.interfaces.Product} against your own domain model.
     */
    public static class MyProduct implements GoogleMerchantProduct {

        private final String title;
        private final String sku;
        private final String price;

        /**
         * @param title the product title
         * @param sku   the stock-keeping unit, also used as the product ID
         * @param price the price string (e.g. {@code "19.99"})
         */
        public MyProduct(String title, String sku, String price) {
            this.title = title;
            this.sku = sku;
            this.price = price;
        }

        @Override
        public String getID() {
            return this.sku;
        }

        @Override
        public String getSKU() {
            return this.sku;
        }

        @Override
        public String getGroupID() {
            return null;
        }

        @Override
        public String getEAN() {
            return null;
        }

        @Override
        public String getDescription() {
            return "This is a super fancy dress!";
        }

        @Override
        public String getTitle() {
            return this.title;
        }

        @Override
        public String getCurrency() {
            return "USD";
        }

        @Override
        public String getPrice() {
            return this.price;
        }

        @Override
        public List<String> getImageURLs() {
            List<String> imageURLs = new ArrayList<>();
            imageURLs.add("https://www.store.com/product/" + this.sku + "/1.jpg");
            imageURLs.add("https://www.store.com/product/" + this.sku + "/2.jpg");
            imageURLs.add("https://www.store.com/product/" + this.sku + "/3.jpg");
            return imageURLs;
        }

        @Override
        public ProductCategory getProductCategory() {
            return ProductCategory.DRESSES;
        }

        @Override
        public String getBrand() {
            return "My Brand";
        }

        @Override
        public String getLink() {
            return "https://www.store.com/product/" + this.sku + "/";
        }

        @Override
        public ProductAvailability getAvailability() {
            return ProductAvailability.IN_STOCK;
        }

        @Override
        public Map<String, String> getProperties() {
            Map<String, String> properties = new LinkedHashMap<>();
            properties.put("Sleeves", "Sleeveless");
            return properties;
        }

        @Override
        public String getAvailabilityDate() {
            return null;
        }

        @Override
        public List<String> getTypes() {
            List<String> types = new ArrayList<>();
            types.add("Product > Women > Dresses");
            return types;
        }

        @Override
        public String getGTIN() {
            return null;
        }

        @Override
        public String getMPN() {
            return null;
        }

        @Override
        public Condition getCondition() {
            return Condition.NEW;
        }

        @Override
        public AgeGroup getAgeGroup() {
            return AgeGroup.ADULT;
        }

        @Override
        public boolean isAdult() {
            return false;
        }

        @Override
        public String getColor() {
            return "Green";
        }

        @Override
        public Gender getGender() {
            return Gender.FEMALE;
        }

        @Override
        public String getMaterial() {
            return "Cotton";
        }

        @Override
        public String getSize() {
            return "XL";
        }

        @Override
        public SizeSystem getSizeSystem() {
            return SizeSystem.EU;
        }

        @Override
        public String getProductLength() {
            return "160 cm";
        }

        @Override
        public String getProductHeight() {
            return null;
        }

        @Override
        public String getProductWidth() {
            return null;
        }

        @Override
        public String getProductWeight() {
            return "240 grams";
        }

    }

}
