package lattesite.googlemerchant.enumerations;

/**
 * Physical condition of a product, as defined by Google Merchant Center.
 *
 * @see <a href="https://support.google.com/merchants/answer/6324469">Google documentation</a>
 */
public enum Condition {

    NEW("new"),
    REFURBISHED("refurbished"),
    USED("used");

    private final String code;

    Condition(String code) {
        this.code = code;
    }

    /**
     * @return the feed value expected by Google Merchant Center
     */
    public String getCode() {
        return this.code;
    }

}
