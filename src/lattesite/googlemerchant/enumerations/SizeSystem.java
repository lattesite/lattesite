package lattesite.googlemerchant.enumerations;

/**
 * Sizing system used for a product, as defined by Google Merchant Center.
 *
 * @see <a href="https://support.google.com/merchants/answer/6324502">Google documentation</a>
 */
public enum SizeSystem {

    AU, BR, CN, DE, EU, FR, IT, JP, MEX, UK, US;

    /**
     * @return the feed value expected by Google Merchant Center
     */
    public String getCode() {
        return this.name();
    }

}
