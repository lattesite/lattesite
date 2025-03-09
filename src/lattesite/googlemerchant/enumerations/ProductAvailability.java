package lattesite.googlemerchant.enumerations;

/**
 * Availability status of a product, as defined by Google Merchant Center.
 *
 * @see <a href="https://support.google.com/merchants/answer/6324448">Google documentation</a>
 */
public enum ProductAvailability {

    PREORDER("preorder"),
    BACKORDER("backorder"),
    IN_STOCK("in_stock"),
    OUT_OF_STOCK("out_of_stock");

    private final String code;

    ProductAvailability(String code) {
        this.code = code;
    }

    /**
     * @return the feed value expected by Google Merchant Center
     */
    public String getCode() {
        return this.code;
    }

}
