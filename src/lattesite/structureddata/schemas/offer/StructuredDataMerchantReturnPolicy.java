package lattesite.structureddata.schemas.offer;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;

/**
 * Represents a Schema.org {@code MerchantReturnPolicy} — the return policy of a merchant.
 *
 * <p>All fields are required and must be provided at construction time.</p>
 *
 * @see <a href="https://schema.org/MerchantReturnPolicy">Schema.org/MerchantReturnPolicy</a>
 */
public class StructuredDataMerchantReturnPolicy extends StructuredDataSchema {

    private final StructuredDataCountry applicableCountry;
    private final StructuredDataCountry returnPolicyCountry;
    private final String itemDefectReturnFees;
    private final String customerRemorseReturnFees;
    private final String returnFees;
    private final String refundType;
    private final String returnPolicyCategory;
    private final int merchantReturnDays;
    private final String returnMethod;
    private final String merchantReturnLink;

    /**
     * @param id                        the JSON-LD {@code @id} for this policy
     * @param applicableCountry         the country where this policy applies
     * @param returnPolicyCountry       the country to which items are returned
     * @param itemDefectReturnFees      Schema.org value for item-defect return fees
     * @param customerRemorseReturnFees Schema.org value for customer-remorse return fees
     * @param returnFees                Schema.org value for return fees
     * @param refundType                Schema.org value for the refund type
     * @param returnPolicyCategory      Schema.org value for the return policy category
     * @param merchantReturnDays        number of days within which a return must be initiated
     * @param returnMethod              Schema.org value for the return method
     * @param merchantReturnLink        URL of the merchant's return instructions page
     */
    public StructuredDataMerchantReturnPolicy(
            String id,
            StructuredDataCountry applicableCountry,
            StructuredDataCountry returnPolicyCountry,
            String itemDefectReturnFees,
            String customerRemorseReturnFees,
            String returnFees,
            String refundType,
            String returnPolicyCategory,
            int merchantReturnDays,
            String returnMethod,
            String merchantReturnLink
    ) {
        super(id);
        this.applicableCountry = applicableCountry;
        this.returnPolicyCountry = returnPolicyCountry;
        this.itemDefectReturnFees = itemDefectReturnFees;
        this.customerRemorseReturnFees = customerRemorseReturnFees;
        this.returnFees = returnFees;
        this.refundType = refundType;
        this.returnPolicyCategory = returnPolicyCategory;
        this.merchantReturnDays = merchantReturnDays;
        this.returnMethod = returnMethod;
        this.merchantReturnLink = merchantReturnLink;
    }

    @Override
    public String getType() {
        return "MerchantReturnPolicy";
    }

    public StructuredDataCountry getApplicableCountry() {
        return this.applicableCountry;
    }

    public StructuredDataCountry getReturnPolicyCountry() {
        return this.returnPolicyCountry;
    }

    public String getItemDefectReturnFees() {
        return this.itemDefectReturnFees;
    }

    public String getCustomerRemorseReturnFees() {
        return this.customerRemorseReturnFees;
    }

    public String getReturnFees() {
        return this.returnFees;
    }

    public String getRefundType() {
        return this.refundType;
    }

    public String getReturnPolicyCategory() {
        return this.returnPolicyCategory;
    }

    public int getMerchantReturnDays() {
        return this.merchantReturnDays;
    }

    public String getReturnMethod() {
        return this.returnMethod;
    }

    public String getMerchantReturnLink() {
        return this.merchantReturnLink;
    }

}
