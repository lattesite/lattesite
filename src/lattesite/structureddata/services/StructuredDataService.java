package lattesite.structureddata.services;

import lattesite.common.utils.StringUtil;
import lattesite.structureddata.enumeration.IsicV4Category;
import lattesite.structureddata.schemas.action.StructuredDataDonateAction;
import lattesite.structureddata.schemas.article.StructuredDataArticle;
import lattesite.structureddata.schemas.audience.StructuredDataPeopleAudience;
import lattesite.structureddata.schemas.brand.StructuredDataBrand;
import lattesite.structureddata.schemas.breadcrumbs.StructuredDataBreadcrumb;
import lattesite.structureddata.schemas.breadcrumbs.StructuredDataBreadcrumbList;
import lattesite.structureddata.schemas.creativework.StructuredDataCreativeWork;
import lattesite.structureddata.schemas.creativework.StructuredDataSoftwareApplication;
import lattesite.structureddata.schemas.faq.StructuredDataAnswer;
import lattesite.structureddata.schemas.faq.StructuredDataFAQPage;
import lattesite.structureddata.schemas.faq.StructuredDataQuestion;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;
import lattesite.structureddata.schemas.geo.StructuredDataDefinedRegion;
import lattesite.structureddata.schemas.geo.StructuredDataGeoCoordinates;
import lattesite.structureddata.schemas.geo.StructuredDataPostalAddress;
import lattesite.structureddata.schemas.language.StructuredDataLanguage;
import lattesite.structureddata.schemas.media.StructuredDataImageObject;
import lattesite.structureddata.schemas.offer.*;
import lattesite.structureddata.schemas.organization.StructuredDataOrganization;
import lattesite.structureddata.schemas.page.StructuredDataAboutPage;
import lattesite.structureddata.schemas.page.StructuredDataProfilePage;
import lattesite.structureddata.schemas.page.StructuredDataWebPage;
import lattesite.structureddata.schemas.person.StructuredDataContactPoint;
import lattesite.structureddata.schemas.person.StructuredDataPerson;
import lattesite.structureddata.schemas.product.StructuredDataProduct;
import lattesite.structureddata.schemas.product.StructuredDataPropertyValue;
import lattesite.structureddata.schemas.product.StructuredDataReview;
import lattesite.structureddata.schemas.thing.StructuredDataThing;
import lattesite.structureddata.schemas.website.StructuredDataWebSite;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Serializes structured data schema objects to JSON-LD strings.
 *
 * <p>Each {@code toJSON} overload accepts a specific schema type and returns a formatted
 * JSON-LD string ready for embedding in a {@code <script type="application/ld+json">} tag.</p>
 *
 * <p>Use the default constructor for standard 4-space indented output, or the parameterized
 * constructor to customize indentation, spacing, and newline characters.</p>
 */
public class StructuredDataService {

    private final String indentation;
    private final String spacing;
    private final String nl;

    /**
     * Creates a service with default formatting: 4-space indentation, single-space key/value
     * separator, and Unix newlines.
     */
    public StructuredDataService() {
        this("    ", " ", "\n");
    }

    /**
     * Creates a service with custom JSON formatting.
     *
     * @param indentation the string used per indentation level (e.g. {@code "    "} or {@code "\t"})
     * @param spacing     the string placed between a key and its value (e.g. {@code " "})
     * @param nl          the newline sequence (e.g. {@code "\n"} or {@code "\r\n"})
     */
    public StructuredDataService(String indentation, String spacing, String nl) {
        this.indentation = indentation;
        this.spacing = spacing;
        this.nl = nl;
    }

    private Map<String, Object> toMap(StructuredDataAboutPage sdAboutPage) {
        Map<String, Object> data = new LinkedHashMap<>();

        data.put("@context", "https://schema.org/");
        data.put("@type", sdAboutPage.getType());
        data.put("@id", sdAboutPage.getID());

        data.put("name", sdAboutPage.getName());
        data.put("url", sdAboutPage.getURL());
        data.put("about", this.toMap(sdAboutPage.getOrganization()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataThing sdThing) {

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdThing.getType());
        data.put("@id", sdThing.getID());

        data.put("name", sdThing.getName());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataDonateAction sdDonateAction) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdDonateAction.getType());
        data.put("@id", sdDonateAction.getID());

        data.put("name", sdDonateAction.getName());
        data.put("description", sdDonateAction.getDescription());
        data.put("object", toMap(sdDonateAction.getObject()));
        data.put("target", sdDonateAction.getTarget());

        if (sdDonateAction.getAgentPerson() != null) {
            data.put("agent", toMap(sdDonateAction.getAgentPerson()));
        }

        if (sdDonateAction.getRecipientPerson() != null) {
            data.put("recipient", toMap(sdDonateAction.getRecipientPerson()));
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataLanguage sdLanguage) {

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdLanguage.getType());
        data.put("@id", sdLanguage.getID());

        data.put("name", sdLanguage.getName());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataContactPoint sdContactPoint) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdContactPoint.getType());
        data.put("@id", sdContactPoint.getID());

        data.put("contactType", sdContactPoint.getContactType());
        if (!StringUtil.isEmpty(sdContactPoint.getEmail())) {
            data.put("email", sdContactPoint.getEmail());
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataOrganization sdOrganization) {

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdOrganization.getType());
        data.put("@id", sdOrganization.getID());

        if (sdOrganization.getLogo() != null) {
            Map<String, Object> dataLogo = this.toMap(sdOrganization.getLogo());
            data.put("image", dataLogo);
            data.put("logo", dataLogo);
        }

        data.put("url", sdOrganization.getURL());
        data.put("name", sdOrganization.getName());
        data.put("description", sdOrganization.getDescription());
        if (!StringUtil.isEmpty(sdOrganization.getEmail())) {
            data.put("email", sdOrganization.getEmail());
        }
        data.put("areaServed", this.toMap(sdOrganization.getAreaServed()));
        if (!StringUtil.isEmpty(sdOrganization.getKnowsLanguage())) {
            data.put("knowsLanguage", sdOrganization.getKnowsLanguage());
        }
        if (!StringUtil.isEmpty(sdOrganization.getFoundingDate())) {
            data.put("foundingDate", sdOrganization.getFoundingDate());
        }
        if (sdOrganization.getIsicV4Categories() != null && sdOrganization.getIsicV4Categories().length > 0) {
            List<String> categories = new ArrayList<>();
            for (IsicV4Category c : sdOrganization.getIsicV4Categories()) {
                categories.add(c.getID());
            }
            data.put("isicV4", categories);
        }

        if (sdOrganization.getBrand() != null) {
            Map<String, Object> dataBrand = this.toMap(sdOrganization.getBrand());
            data.put("brand", dataBrand);
        }
        if (sdOrganization.getOwns() != null) {
            Map<String, Object> dataOwns = this.toMap(sdOrganization.getOwns());
            data.put("owns", dataOwns);
        }
        data.put("keywords", sdOrganization.getKeywords());
        data.put("knowsAbout", sdOrganization.getKnowsAbout());
        if (!StringUtil.isEmpty(sdOrganization.getVATID())) {
            data.put("vatID", sdOrganization.getVATID());
        }

        if (sdOrganization.getHasMerchantReturnPolicy() != null) {
            Map<String, Object> dataHasMerchantReturnPolicy = this.toMap(sdOrganization.getHasMerchantReturnPolicy());
            data.put("hasMerchantReturnPolicy", dataHasMerchantReturnPolicy);
        }

        if (sdOrganization.getSameAs() != null) {
            data.put("sameAs", sdOrganization.getSameAs());
        }
        if (sdOrganization.getGeo() != null) {
            Map<String, Object> geo = this.toMap(sdOrganization.getGeo());
            data.put("geo", geo);
        }
        if (sdOrganization.getAddress() != null) {
            Map<String, Object> address = this.toMap(sdOrganization.getAddress());
            data.put("address", address);
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataWebSite sdWebSite) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdWebSite.getType());
        data.put("@id", sdWebSite.getID());

        data.put("name", sdWebSite.getName());
        data.put("url", sdWebSite.getURL());
        data.put("description", sdWebSite.getDescription());
        if (sdWebSite.getInLanguage() != null) {
            data.put("inLanguage", this.toMap(sdWebSite.getInLanguage()));
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataBrand sdBrand) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdBrand.getType());
        data.put("@id", sdBrand.getID());

        data.put("name", sdBrand.getName());
        if (!StringUtil.isEmpty(sdBrand.getLogo())) {
            data.put("logo", sdBrand.getLogo());
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataGeoCoordinates structuredDataGeoCoordinates) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", structuredDataGeoCoordinates.getType());
        data.put("@id", structuredDataGeoCoordinates.getID());

        data.put("latitude", structuredDataGeoCoordinates.getLatitude());
        data.put("longitude", structuredDataGeoCoordinates.getLongitude());

        if (structuredDataGeoCoordinates.getAddressCountry() != null) {
            Map<String, Object> geo = this.toMap(structuredDataGeoCoordinates.getAddressCountry());
            data.put("addressCountry", geo);
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataBreadcrumbList sd) {
        Map<String, Object> data = new LinkedHashMap<>();

        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        List<Map<String, Object>> sdsBreadcrumbs = new ArrayList<>();
        for (int i = 0; i < sd.getBreadcrumbs().size(); i++) {
            StructuredDataBreadcrumb sdbc = sd.getBreadcrumbs().get(i);
            sdsBreadcrumbs.add(toMap(i + 1, sdbc));
        }

        data.put("itemListElement", sdsBreadcrumbs);
        return data;
    }

    private Map<String, Object> toMap(int position, StructuredDataBreadcrumb sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@type", sd.getType());
        if (!StringUtil.isEmpty(sd.getID())) {
            data.put("@id", sd.getID());
        }

        data.put("position", position);
        data.put("name", sd.getName());
        data.put("item", sd.getItem());
        return data;
    }

    private Map<String, Object> toMap(StructuredDataPostalAddress sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("streetAddress", sd.getStreetAddress());
        data.put("postalCode", sd.getPostalCode());
        data.put("addressLocality", sd.getAddressLocality());

        Map<String, Object> addressCountry = this.toMap(sd.getAddressCountry());
        data.put("addressCountry", addressCountry);

        if (!StringUtil.isEmpty(sd.getAddressRegion())) {
            data.put("addressRegion", sd.getAddressRegion());
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataCountry structuredDataCountry) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", structuredDataCountry.getType());
        data.put("@id", structuredDataCountry.getID());

        data.put("name", structuredDataCountry.getName());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataWebPage sdWebPage) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdWebPage.getType());
        data.put("@id", sdWebPage.getID());

        data.put("name", sdWebPage.getName());
        data.put("url", sdWebPage.getURL());
        data.put("description", sdWebPage.getDescription());
        data.put("inLanguage", toMap(sdWebPage.getInLanguage()));

        data.put("isPartOf", this.toMap(sdWebPage.getIsPartOf()));

        if (sdWebPage.getAudience() != null) {
            data.put("audience", toMap(sdWebPage.getAudience()));
        }

        if (sdWebPage.getReviewedBy() != null) {
            data.put("reviewedBy", toMap(sdWebPage.getReviewedBy()));
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataImageObject sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("url", sd.getURL());
        return data;
    }

    private Map<String, Object> toMap(StructuredDataMerchantReturnPolicy sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        Map<String, Object> dataApplicableCountry = this.toMap(sd.getApplicableCountry());
        data.put("applicableCountry", dataApplicableCountry);

        Map<String, Object> dataReturnPolicyCountry = this.toMap(sd.getReturnPolicyCountry());
        data.put("returnPolicyCountry", dataReturnPolicyCountry);

        data.put("itemDefectReturnFees", sd.getItemDefectReturnFees());
        data.put("customerRemorseReturnFees", sd.getCustomerRemorseReturnFees());
        data.put("returnFees", sd.getReturnFees());
        data.put("refundType", sd.getRefundType());
        data.put("returnPolicyCategory", sd.getReturnPolicyCategory());
        data.put("merchantReturnDays", sd.getMerchantReturnDays());
        data.put("returnMethod", sd.getReturnMethod());
        data.put("merchantReturnLink", sd.getMerchantReturnLink());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataPerson sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        if (!StringUtil.isEmpty(sd.getURL())) {
            data.put("url", sd.getURL());
        }

        if (!StringUtil.isEmpty(sd.getImage())) {
            data.put("image", sd.getImage());
        }

        if (!StringUtil.isEmpty(sd.getDescription())) {
            data.put("description", sd.getDescription());
        }

        if (sd.getNationality() != null) {
            data.put("nationality", toMap(sd.getNationality()));
        }

        if (sd.getContactPoint() != null) {
            data.put("contactPoint", toMap(sd.getContactPoint()));
        }

        if (!StringUtil.isEmpty(sd.getKnowsLanguage())) {
            data.put("knowsLanguage", sd.getKnowsLanguage());
        }

        if (sd.getSameAs() != null && !sd.getSameAs().isEmpty()) {
            data.put("sameAs", sd.getSameAs());
        }

        if (!StringUtil.isEmpty(sd.getKnowsAbout())) {
            data.put("knowsAbout", sd.getKnowsAbout());
        }
        if (!StringUtil.isEmpty(sd.getJobTitle())) {
            data.put("jobTitle", sd.getJobTitle());
        }

        if (sd.getGender() != null) {
            data.put("gender", sd.getGender().getValue());
        }

        if (sd.getGivenName() != null) {
            data.put("givenName", sd.getGivenName());
        }
        if (sd.getFamilyName() != null) {
            data.put("familyName", sd.getFamilyName());
        }

        if (sd.getName() != null) {
            data.put("name", sd.getName());
        }

        if (sd.getEducation() != null) {
            data.put("alumniOf", sd.getEducation());
        }

        if (sd.getBrand() != null) {
            data.put("brand", this.toMap(sd.getBrand()));
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataArticle sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        if (sd.getAuthor() != null) {
            data.put("author", toMap(sd.getAuthor()));
        }

        if (sd.getAudience() != null) {
            data.put("audience", toMap(sd.getAudience()));
        }

        if (sd.getPublisherOrganization() != null) {
            data.put("publisher", toMap(sd.getPublisherOrganization()));
        }

        data.put("inLanguage", sd.getInLanguage());
        data.put("headline", sd.getHeadline());
        data.put("image", sd.getImage());
        data.put("description", sd.getDescription());
        data.put("dateCreated", sd.getDateCreated());
        data.put("datePublished", sd.getDatePublished());
        data.put("dateModified", sd.getDateModified());
        data.put("url", sd.getURL());
        data.put("articleSection", sd.getArticleSection());
        data.put("articleBody", sd.getArticleBody());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataPeopleAudience sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("suggestedGender", sd.getSuggestedGender().getValue());
        data.put("audienceType", sd.getAudienceType());
        data.put("geographicArea", this.toMap(sd.getGeographicArea()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataFAQPage sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        List<Map<String, Object>> sdMainEntity = new ArrayList<>();
        for (StructuredDataQuestion sdq : sd.getMainEntity()) {
            sdMainEntity.add(toMap(sdq));
        }

        data.put("mainEntity", sdMainEntity);

        return data;
    }

    private Map<String, Object> toMap(StructuredDataProfilePage sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());

        data.put("mainEntity", toMap(sd.getPerson()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataQuestion sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("name", sd.getName());
        data.put("acceptedAnswer", toMap(sd.getAcceptedAnswer()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataAnswer sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("text", sd.getText());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataProduct sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("name", sd.getName());
        data.put("description", sd.getDescription());
        data.put("category", sd.getCategories());
        data.put("image", sd.getImageURLs());
        if (sd.getBrand() != null) {
            data.put("brand", this.toMap(sd.getBrand()));
        }
        if (!StringUtil.isEmpty(sd.getEAN())) {
            data.put("ean", sd.getEAN());
        }
        data.put("sku", sd.getSKU());
        data.put("productID", sd.getSKU());
        if (!StringUtil.isEmpty(sd.getGtin())) {
            data.put("gtin", sd.getGtin());
            data.put("gtin13", sd.getGtin());
        }
        data.put("offers", toMap(sd.getOffers()));

        if (sd.getAudience() != null) {
            data.put("audience", toMap(sd.getAudience()));
        }

        if (!sd.getAwards().isEmpty()) {
            data.put("awards", sd.getAwards());
        }

        if (!sd.getReviews().isEmpty()) {
            List<Map<String, Object>> reviews = new ArrayList<>();
            int totalRating = 0;
            for (StructuredDataReview review : sd.getReviews()) {
                reviews.add(toMap(review));
                totalRating += review.getRatingValue();
            }
            data.put("review", reviews);
            double averageRating = ((double) totalRating / (double) sd.getReviews().size());
            Map<String, Object> aggregateRating = new LinkedHashMap<>();
            aggregateRating.put("@type", "AggregateRating");
            aggregateRating.put("ratingValue", averageRating);
            aggregateRating.put("reviewCount", sd.getReviews().size());
            data.put("aggregateRating", aggregateRating);
        }

        List<Map<String, Object>> additionalProperties = new ArrayList<>();
        for (StructuredDataPropertyValue additionalProperty : sd.getAdditionalProperties()) {
            additionalProperties.add(toMap(additionalProperty));
        }
        data.put("additionalProperty", additionalProperties);

        return data;
    }

    private Map<String, Object> toMap(StructuredDataReview sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        if (!StringUtil.isEmpty(sd.getID())) {
            data.put("@id", sd.getID());
        }
        data.put("@type", sd.getType());

        data.put("author", toMap(sd.getAuthor()));
        data.put("datePublished", sd.getDatePublished());
        data.put("reviewBody", sd.getReviewBody());

        Map<String, Object> reviewRating = new LinkedHashMap<>();
        reviewRating.put("@type", "Rating");
        reviewRating.put("ratingValue", sd.getRatingValue());
        reviewRating.put("worstRating", sd.getWorstRating());
        reviewRating.put("bestRating", sd.getBestRating());
        data.put("reviewRating", reviewRating);

        return data;
    }

    private Map<String, Object> toMap(StructuredDataOffer sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("url", sd.getURL());
        data.put("priceCurrency", sd.getPriceCurrency());
        data.put("price", sd.getPrice());
        data.put("priceValidUntil", sd.getPriceValidUntil());

        if (sd.getSeller() != null) {
            data.put("seller", toMap(sd.getSeller()));
        }

        if (sd.getAvailability() != null) {
            data.put("availability", sd.getAvailability().getValue());
        }

        if (sd.getItemCondition() != null) {
            data.put("itemCondition", sd.getItemCondition().getValue());
        }

        if (sd.getShippingDetails() != null) {
            data.put("shippingDetails", toMap(sd.getShippingDetails()));
        }

        if (sd.getHasMerchantReturnPolicy() != null) {
            data.put("hasMerchantReturnPolicy", toMap(sd.getHasMerchantReturnPolicy()));
        }

        if (!StringUtil.isEmpty(sd.getCategory())) {
            data.put("category", sd.getCategory());
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataOfferShippingDetails sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("shippingRate", toMap(sd.getShippingRate()));
        data.put("shippingDestination", toMap(sd.getShippingDestination()));
        data.put("deliveryTime", toMap(sd.getDeliveryTime()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataPropertyValue sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        if (!StringUtil.isEmpty(sd.getID())) {
            data.put("@id", sd.getID());
        }
        data.put("@type", sd.getType());

        data.put("name", sd.getName());
        data.put("value", sd.getValue());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataMonetaryAmount sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        if (!StringUtil.isEmpty(sd.getID())) {
            data.put("@id", sd.getID());
        }
        data.put("@type", sd.getType());

        data.put("value", sd.getValue());
        data.put("currency", sd.getCurrency());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataShippingDeliveryTime sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("handlingTime", toMap(sd.getHandlingTime()));
        data.put("transitTime", toMap(sd.getTransitTime()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataQuantitativeValue sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        if (!StringUtil.isEmpty(sd.getID())) {
            data.put("@id", sd.getID());
        }
        data.put("@type", sd.getType());

        data.put("minValue", sd.getMinValue());
        data.put("maxValue", sd.getMaxValue());
        data.put("unitCode", sd.getUnitCode().getValue());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataDefinedRegion sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("addressCountry", sd.getAddressCountry());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataSoftwareApplication sd) {
        Map<String, Object> data = new LinkedHashMap<>(toMap((StructuredDataCreativeWork) sd));

        data.put("operatingSystem", sd.getOperatingSystem());
        data.put("applicationCategory", sd.getApplicationCategory());
        if (!StringUtil.isEmpty(sd.getApplicationSubCategory())) {
            data.put("applicationSubCategory", sd.getApplicationSubCategory());
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataCreativeWork sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sd.getType());
        data.put("@id", sd.getID());

        data.put("name", sd.getName());
        data.put("description", sd.getDescription());
        data.put("url", sd.getURL());

        if (!StringUtil.isEmpty(sd.getImage())) {
            data.put("image", sd.getImage());
        }

        if (!StringUtil.isEmpty(sd.getHeadline())) {
            data.put("headline", sd.getHeadline());
        }

        if (sd.getCreatorPerson() != null) {
            data.put("creator", toMap(sd.getCreatorPerson()));
        }

        if (sd.getAuthorPerson() != null) {
            data.put("author", toMap(sd.getAuthorPerson()));
        }

        if (sd.getPublisherOrganization() != null) {
            data.put("publisher", toMap(sd.getPublisherOrganization()));
        }
        if (sd.getPublisherPerson() != null) {
            data.put("publisher", toMap(sd.getPublisherPerson()));
        }

        if (sd.getOffers() != null) {
            data.put("offers", toMap(sd.getOffers()));
        }

        return data;
    }

    /**
     * Serializes a {@link StructuredDataCreativeWork} to a JSON-LD string.
     *
     * @param structuredDataCreativeWork the creative work to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataCreativeWork structuredDataCreativeWork) throws Exception {
        return toJSON(0, toMap(structuredDataCreativeWork));
    }

    /**
     * Serializes a {@link StructuredDataSoftwareApplication} to a JSON-LD string.
     *
     * @param structuredDataSoftwareApplication the software application to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataSoftwareApplication structuredDataSoftwareApplication) throws Exception {
        return toJSON(0, toMap(structuredDataSoftwareApplication));
    }

    /**
     * Serializes a {@link StructuredDataProfilePage} to a JSON-LD string.
     *
     * @param structuredDataProfilePage the profile page to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataProfilePage structuredDataProfilePage) throws Exception {
        return toJSON(0, toMap(structuredDataProfilePage));
    }

    /**
     * Serializes a {@link StructuredDataArticle} (or any subclass) to a JSON-LD string.
     *
     * @param structuredDataArticle the article to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataArticle structuredDataArticle) throws Exception {
        return toJSON(0, toMap(structuredDataArticle));
    }

    /**
     * Serializes a {@link StructuredDataFAQPage} to a JSON-LD string.
     *
     * @param structuredDataFAQPage the FAQ page to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataFAQPage structuredDataFAQPage) throws Exception {
        return toJSON(0, toMap(structuredDataFAQPage));
    }

    /**
     * Serializes a {@link StructuredDataProduct} to a JSON-LD string.
     * Automatically computes {@code aggregateRating} from attached reviews.
     *
     * @param structuredDataProduct the product to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataProduct structuredDataProduct) throws Exception {
        return toJSON(0, this.toMap(structuredDataProduct));
    }

    /**
     * Serializes a {@link StructuredDataPerson} to a JSON-LD string.
     *
     * @param structuredDataPerson the person to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataPerson structuredDataPerson) throws Exception {
        return toJSON(0, toMap(structuredDataPerson));
    }

    /**
     * Serializes a {@link StructuredDataBreadcrumbList} to a JSON-LD string.
     * Breadcrumb positions are assigned automatically based on list order.
     *
     * @param structuredDataBreadcrumbList the breadcrumb list to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataBreadcrumbList structuredDataBreadcrumbList) throws Exception {
        return toJSON(0, toMap(structuredDataBreadcrumbList));
    }

    /**
     * Serializes a {@link StructuredDataWebPage} to a JSON-LD string.
     *
     * @param sdWebPage the web page to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataWebPage sdWebPage) throws Exception {
        return toJSON(0, toMap(sdWebPage));
    }

    /**
     * Serializes a {@link StructuredDataOrganization} (or any subclass) to a JSON-LD string.
     *
     * @param sdOrganization the organization to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataOrganization sdOrganization) throws Exception {
        return toJSON(0, toMap(sdOrganization));
    }

    /**
     * Serializes a {@link StructuredDataWebSite} to a JSON-LD string.
     *
     * @param sdWebSite the website to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataWebSite sdWebSite) throws Exception {
        return toJSON(0, this.toMap(sdWebSite));
    }

    /**
     * Serializes a {@link StructuredDataAboutPage} to a JSON-LD string.
     *
     * @param sdAboutPage the about page to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataAboutPage sdAboutPage) throws Exception {
        return toJSON(0, toMap(sdAboutPage));
    }

    /**
     * Serializes a {@link StructuredDataDonateAction} to a JSON-LD string.
     *
     * @param sdDonateAction the donate action to serialize
     * @return a formatted JSON-LD string
     * @throws Exception if a required field value is null
     */
    public String toJSON(StructuredDataDonateAction sdDonateAction) throws Exception {
        return toJSON(0, toMap(sdDonateAction));
    }

    private String toJSON(int level, Map<String, Object> data) throws Exception {

        String json = "";

        json += this.indentation.repeat(level) + "{" + this.nl;

        int i = 0;
        for (Map.Entry<String, Object> entry : data.entrySet()) {

            String key = entry.getKey();
            json += this.indentation.repeat(level + 1) + "\"" + key + "\":" + this.spacing;
            Object value = entry.getValue();

            if (value == null) {
                throw new Exception("The value for \"" + key + "\" is literally null.");
            }

            if (value instanceof Integer) {

                int vi = (int) value;
                json += Integer.toString(vi);

            } else if (value instanceof Double) {

                double d = (double) value;
                if (d % 1 == 0) {
                    json += Integer.toString((int) d);
                } else {
                    json += Double.toString(d);
                }

            } else if (value instanceof String) {

                String s = (String) value;
                json += "\"" + formatJSONValue(s) + "\"";

            } else if (value instanceof String[]) {

                String[] array = (String[]) value;

                json += "[" + this.nl;
                for (int k = 0; k < array.length; k++) {
                    String arrayValue = array[k];
                    json += this.indentation.repeat(level + 2) + "\"" + formatJSONValue(arrayValue) + "\"";
                    if (k < array.length - 1) {
                        json += "," + this.nl;
                    } else {
                        json += this.nl;
                    }
                }
                json += this.indentation.repeat(level + 1) + "]";

            } else if (value instanceof List) {

                List<?> array = (List<?>) value;

                json += "[" + this.nl;
                for (int k = 0; k < array.size(); k++) {
                    Object listItem = array.get(k);

                    json += this.indentation.repeat(level + 2);

                    if (listItem instanceof Map) {
                        json += toJSON(level + 2, (Map<String, Object>) listItem).trim();
                    } else if (listItem instanceof String) {
                        json += "\"" + formatJSONValue((String) listItem) + "\"";
                    } else {
                        throw new Exception("Unknown type \"" + value.getClass().getSimpleName() + "\" for key \"" + key + "\" while converting to JSON: " + value);
                    }

                    if (k < array.size() - 1) {
                        json += "," + this.nl;
                    } else {
                        json += this.nl;
                    }
                }
                json += this.indentation.repeat(level + 1) + "]";

            } else if (value instanceof Map<?, ?>) {

                Map<String, Object> d = (Map<String, Object>) value;
                json += toJSON(level + 1, d).trim();

            } else {

                throw new Exception("Unknown type \"" + value.getClass().getSimpleName() + "\" for key \"" + key + "\" while converting to JSON: " + value);

            }

            if (i < data.entrySet().size() - 1) {
                json += ",";
            }

            json += this.nl;
            i++;

        }

        json += this.indentation.repeat(level) + "}" + this.nl;

        return json;

    }

    private String formatJSONValue(String s) {

        s = s.replace("\"", "\\\"");
        s = s.replace("\b", "\\b");
        s = s.replace("\f", "\\f");
        s = s.replace("\n", "\\n");
        s = s.replace("\r", "\\r");
        s = s.replace("\t", "\\t");

        return s;

    }

}
