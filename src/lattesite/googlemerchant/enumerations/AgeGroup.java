package lattesite.googlemerchant.enumerations;

/**
 * Target age group for a product, as defined by Google Merchant Center.
 *
 * @see <a href="https://support.google.com/merchants/answer/6324463">Google documentation</a>
 */
public enum AgeGroup {

    NEWBORN("newborn"),
    INFANT("infant"),
    TODDLER("toddler"),
    KIDS("kids"),
    ADULT("adult");

    private final String code;

    AgeGroup(String code) {
        this.code = code;
    }

    /**
     * @return the feed value expected by Google Merchant Center
     */
    public String getCode() {
        return this.code;
    }

}
