package lattesite.structureddata.schemas.organization;

import lattesite.structureddata.enumeration.IsicV4Category;
import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.brand.StructuredDataBrand;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;
import lattesite.structureddata.schemas.geo.StructuredDataGeoCoordinates;
import lattesite.structureddata.schemas.geo.StructuredDataPostalAddress;
import lattesite.structureddata.schemas.media.StructuredDataImageObject;
import lattesite.structureddata.schemas.offer.StructuredDataMerchantReturnPolicy;

/**
 * Represents a Schema.org {@code Organization}.
 *
 * <p>Optional properties — logo, email, VAT ID, sameAs links, brand, geo coordinates,
 * postal address, language, merchant return policy, and founding date — can all be
 * set after construction via the corresponding setter methods.</p>
 *
 * @see <a href="https://schema.org/Organization">Schema.org/Organization</a>
 */
public class StructuredDataOrganization extends StructuredDataSchema {

    private final String name;
    private final String url;
    private final String description;
    private final StructuredDataCountry areaServed;
    private final IsicV4Category[] isicV4Categories;
    private final String keywords;
    private final String knowsAbout;
    private String foundingDate;
    private String email;
    private StructuredDataImageObject logo;
    private String vatID;
    private String[] sameAs;
    private StructuredDataMerchantReturnPolicy hasMerchantReturnPolicy;
    private StructuredDataBrand brand;
    private StructuredDataBrand owns;
    private String knowsLanguage;
    private StructuredDataGeoCoordinates geo;
    private StructuredDataPostalAddress address;

    /**
     * @param id               the JSON-LD {@code @id} for this organization (typically the organization's homepage URL)
     * @param name             the organization name
     * @param url              the canonical URL of the organization
     * @param description      a short description of the organization
     * @param areaServed       the country or region the organization serves
     * @param isicV4Categories the ISIC v4 industry classification codes for this organization
     * @param keywords         comma-separated keywords describing the organization
     * @param knowsAbout       topics or areas of expertise the organization knows about
     */
    public StructuredDataOrganization(
            String id,
            String name,
            String url,
            String description,
            StructuredDataCountry areaServed,
            IsicV4Category[] isicV4Categories,
            String keywords,
            String knowsAbout
    ) {
        super(id);
        this.name = name;
        this.url = url;
        this.description = description;
        this.areaServed = areaServed;
        this.isicV4Categories = isicV4Categories;
        this.keywords = keywords;
        this.knowsAbout = knowsAbout;
        this.foundingDate = null;
        this.email = null;
        this.logo = null;
        this.vatID = null;
        this.sameAs = null;
        this.hasMerchantReturnPolicy = null;
        this.brand = null;
        this.owns = null;
        this.knowsLanguage = null;
        this.geo = null;
        this.address = null;
    }

    @Override
    public String getType() {
        return "Organization";
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFoundingDate(String foundingDate) {
        this.foundingDate = foundingDate;
    }

    public void setKnowsLanguage(String knowsLanguage) {
        this.knowsLanguage = knowsLanguage;
    }

    public void setBrand(StructuredDataBrand brand) {
        this.brand = brand;
    }

    public void setLogo(StructuredDataImageObject logo) {
        this.logo = logo;
    }

    public void setVatID(String vatID) {
        this.vatID = vatID;
    }

    public void setOwns(StructuredDataBrand owns) {
        this.owns = owns;
    }

    public StructuredDataImageObject getLogo() {
        return this.logo;
    }

    public String getName() {
        return this.name;
    }

    public void setSameAs(String[] sameAs) {
        this.sameAs = sameAs;
    }

    public String getURL() {
        return this.url;
    }

    public String getEmail() {
        return this.email;
    }

    public String getDescription() {
        return this.description;
    }

    public StructuredDataCountry getAreaServed() {
        return this.areaServed;
    }

    public String getKnowsLanguage() {
        return this.knowsLanguage;
    }

    public String getFoundingDate() {
        return this.foundingDate;
    }

    public IsicV4Category[] getIsicV4Categories() {
        return this.isicV4Categories;
    }

    public StructuredDataBrand getBrand() {
        return this.brand;
    }

    public StructuredDataBrand getOwns() {
        return this.owns;
    }

    public String getKeywords() {
        return this.keywords;
    }

    public String getKnowsAbout() {
        return this.knowsAbout;
    }

    public String getVATID() {
        return this.vatID;
    }

    public String[] getSameAs() {
        return this.sameAs;
    }

    public StructuredDataMerchantReturnPolicy getHasMerchantReturnPolicy() {
        return this.hasMerchantReturnPolicy;
    }

    public void setHasMerchantReturnPolicy(StructuredDataMerchantReturnPolicy hasMerchantReturnPolicy) {
        this.hasMerchantReturnPolicy = hasMerchantReturnPolicy;
    }

    public void setGeo(StructuredDataGeoCoordinates geo) {
        this.geo = geo;
    }

    public StructuredDataGeoCoordinates getGeo() {
        return this.geo;
    }

    public StructuredDataPostalAddress getAddress() {
        return this.address;
    }

    public void setAddress(StructuredDataPostalAddress address) {
        this.address = address;
    }

}
