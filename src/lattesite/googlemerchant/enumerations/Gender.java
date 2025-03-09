package lattesite.googlemerchant.enumerations;

/**
 * Target gender for a product, as defined by Google Merchant Center.
 *
 * @see <a href="https://support.google.com/merchants/answer/6324479">Google documentation</a>
 */
public enum Gender {

    MALE("male"),
    FEMALE("female"),
    UNISEX("unisex");

    private final String code;

    Gender(String code) {
        this.code = code;
    }

    /**
     * @return the feed value expected by Google Merchant Center
     */
    public String getCode() {
        return this.code;
    }

}
