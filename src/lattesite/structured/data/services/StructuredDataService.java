package lattesite.structured.data.services;

import lattesite.services.LogService;
import lattesite.structured.data.enumeration.IsicV4Category;
import lattesite.structured.data.schemas.*;
import lattesite.utils.StringUtil;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StructuredDataService {

    private final LogService logService;
    private final String indentation;
    private final String spacing;
    private final String nl;

    public StructuredDataService(LogService logService) {
        this(logService, "    ", " ", "\n");
    }

    public StructuredDataService(LogService logService, String indentation, String spacing, String nl) {
        this.logService = logService;
        this.indentation = indentation;
        this.spacing = spacing;
        this.nl = nl;
    }

    private Map<String, Object> toMap(StructuredDataAboutPage sdAboutPage) {

        Map<String, Object> dataOrganization = this.toMap(sdAboutPage.getOrganization());

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "AboutPage");

        data.put("name", sdAboutPage.getName());
        data.put("url", sdAboutPage.getURL());
        data.put("organization", dataOrganization);

        return data;
    }

    private Map<String, Object> toMap(StructuredDataOrganization sdOrganization) {

        Map<String, Object> dataAreaServed = this.toMap(sdOrganization.getAreaServed());

        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", sdOrganization.getType());

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
        data.put("areaServed", dataAreaServed);
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
        data.put("@type", "WebSite");

        data.put("name", sdWebSite.getName());
        data.put("url", sdWebSite.getURL());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataBrand sdBrand) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "Brand");

        data.put("name", sdBrand.getName());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataGeoCoordinates structuredDataGeoCoordinates) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "GeoCoordinates");

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
        data.put("@type", "BreadcrumbList");
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
        data.put("@type", "ListItem");

        data.put("position", position);
        data.put("name", sd.getName());
        data.put("item", sd.getItem());
        return data;
    }

    private Map<String, Object> toMap(StructuredDataPostalAddress sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@type", "PostalAddress");

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
        data.put("@type", "Country");

        data.put("name", structuredDataCountry.getName());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataWebPage sdWebPage) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "WebPage");

        data.put("name", sdWebPage.getName());
        data.put("url", sdWebPage.getURL());
        data.put("description", sdWebPage.getDescription());

        Map<String, Object> dataIsPartOf = this.toMap(sdWebPage.getIsPartOf());
        data.put("isPartOf", dataIsPartOf);

        if (sdWebPage.getAudience() != null) {
            data.put("audience", toMap(sdWebPage.getAudience()));
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataImageObject sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "ImageObject");

        data.put("url", sd.getURL());
        return data;
    }

    private Map<String, Object> toMap(StructuredDataMerchantReturnPolicy sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "MerchantReturnPolicy");

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
        data.put("@type", "Person");

        if (!StringUtil.isEmpty(sd.getURL())) {
            data.put("url", sd.getURL());
        }

        if (!StringUtil.isEmpty(sd.getImage())) {
            data.put("image", sd.getImage());
        }

        if (!StringUtil.isEmpty(sd.getDescription())) {
            data.put("description", sd.getDescription());
        }

        if (!StringUtil.isEmpty(sd.getKnowsLanguage())) {
            data.put("knowsLanguage", sd.getKnowsLanguage());
        }

        if (sd.getSameAs() != null && sd.getSameAs().length != 0) {
            data.put("sameAs", sd.getSameAs());
        }

        if (!StringUtil.isEmpty(sd.getKnowsAbout())) {
            data.put("knowsAbout", sd.getKnowsAbout());
        }
        if (!StringUtil.isEmpty(sd.getJobTitle())) {
            data.put("jobTitle", sd.getJobTitle());
        }

        data.put("gender", sd.getGender().getValue());
        if (sd.getGivenName() != null) {
            data.put("givenName", sd.getGivenName());
        }
        if (sd.getFamilyName() != null) {
            data.put("familyName", sd.getFamilyName());
        }

        if (sd.getName() != null) {
            data.put("name", sd.getName());
        }

        return data;
    }

    private Map<String, Object> toMap(StructuredDataArticle sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "Article");

        if (sd.getAuthor() != null) {
            data.put("author", toMap(sd.getAuthor()));
        }
        if (sd.getReviewer() != null) {
            data.put("reviewedBy", toMap(sd.getReviewer()));
        }
        data.put("audience", toMap(sd.getAudience()));
        data.put("publisher", toMap(sd.getPublisher()));
        data.put("inLanguage", "sv");
        data.put("headline", sd.getHeadline());
        data.put("image", sd.getImage());
        data.put("description", sd.getDescription());
        data.put("dateCreated", sd.getDatePublished());
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
        data.put("@type", "PeopleAudience");

        data.put("suggestedGender", sd.getSuggestedGender().getValue());
        data.put("audienceType", sd.getAudienceType());
        data.put("geographicArea", toMap(sd.getGeographicArea()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataFAQPage sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "FAQPage");

        List<Map<String, Object>> sdMainEntity = new ArrayList<>();
        for (StructuredDataQuestion sdq : sd.getMainEntity()) {
            sdMainEntity.add(toMap(sdq));
        }

        data.put("mainEntity", sdMainEntity);

        return data;
    }

    private Map<String, Object> toMap(StructuredDataQuestion sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "Question");

        data.put("name", sd.getName());
        data.put("acceptedAnswer", toMap(sd.getAcceptedAnswer()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataAnswer sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "Answer");

        data.put("text", sd.getText());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataProduct sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "Product");

        data.put("name", sd.getName());
        data.put("description", sd.getDescription());
        data.put("category", sd.getCategories());
        data.put("image", sd.getImageURLs());
        data.put("brand", toMap(sd.getBrand()));
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
        data.put("audience", toMap(sd.getAudience()));

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
        data.put("@type", "Review");

        data.put("author", toMap(sd.getAuthor()));
        data.put("datePublished", sd.getDatePublished());
        data.put("reviewBody", sd.getReviewBody());

        Map<String, Object> reviewRating = new LinkedHashMap<>();
        reviewRating.put("@type", "Rating");
        reviewRating.put("ratingValue", sd.getRatingValue());
        reviewRating.put("worstRating", sd.getWorseRating());
        reviewRating.put("bestRating", sd.getBestRating());
        data.put("reviewRating", reviewRating);

        return data;
    }

    private Map<String, Object> toMap(StructuredDataOffer sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "Offer");

        data.put("url", sd.getURL());

        data.put("priceCurrency", sd.getPriceCurrency());
        data.put("price", sd.getPrice());
        data.put("priceValidUntil", sd.getPriceValidUntil());
        data.put("availability", sd.getAvailability().getValue());
        data.put("itemCondition", sd.getItemCondition().getValue());
        data.put("seller", toMap(sd.getSeller()));
        data.put("shippingDetails", toMap(sd.getShippingDetails()));
        data.put("hasMerchantReturnPolicy", toMap(sd.getHasMerchantReturnPolicy()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataOfferShippingDetails sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "OfferShippingDetails");

        data.put("shippingRate", toMap(sd.getShippingRate()));
        data.put("shippingDestination", toMap(sd.getShippingDestination()));
        data.put("deliveryTime", toMap(sd.getDeliveryTime()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataPropertyValue sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "PropertyValue");

        data.put("name", sd.getName());
        data.put("value", sd.getValue());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataMonetaryAmount sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "MonetaryAmount");

        data.put("value", sd.getValue());
        data.put("currency", sd.getCurrency());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataShippingDeliveryTime sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "ShippingDeliveryTime");

        data.put("handlingTime", toMap(sd.getHandlingTime()));
        data.put("transitTime", toMap(sd.getTransitTime()));

        return data;
    }

    private Map<String, Object> toMap(StructuredDataQuantitativeValue sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "QuantitativeValue");

        data.put("minValue", sd.getMinValue());
        data.put("maxValue", sd.getMaxValue());
        data.put("unitCode", sd.getUnitCode().getValue());

        return data;
    }

    private Map<String, Object> toMap(StructuredDataDefinedRegion sd) {
        Map<String, Object> data = new LinkedHashMap<>();
        data.put("@context", "https://schema.org/");
        data.put("@type", "DefinedRegion");

        data.put("addressCountry", sd.getAddressCountry());

        return data;
    }

    public String toJSON(StructuredDataArticle structuredDataArticle) throws Exception {
        return toJSON(0, toMap(structuredDataArticle));
    }

    public String toJSON(StructuredDataFAQPage structuredDataFAQPage) throws Exception {
        return toJSON(0, toMap(structuredDataFAQPage));
    }

    public String toJSON(StructuredDataProduct structuredDataProduct) throws Exception {
        return toJSON(0, toMap(structuredDataProduct));
    }

    public String toJSON(StructuredDataPerson structuredDataPerson) throws Exception {
        return toJSON(0, toMap(structuredDataPerson));
    }

    public String toJSON(StructuredDataBreadcrumbList structuredDataBreadcrumbList) throws Exception {
        return toJSON(0, toMap(structuredDataBreadcrumbList));
    }

    public String toJSON(StructuredDataWebPage structuredDataWebPage) throws Exception {
        return toJSON(0, toMap(structuredDataWebPage));
    }

    public String toJSON(StructuredDataOrganization sdOrganization) throws Exception {
        return toJSON(0, toMap(sdOrganization));
    }

    public String toJSON(StructuredDataWebSite sdWebSite) throws Exception {
        return toJSON(0, toMap(sdWebSite));
    }

    public String toJSON(StructuredDataAboutPage sdAboutPage) throws Exception {
        return toJSON(0, toMap(sdAboutPage));
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
                // Check if its an int (no decimals)
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
//                json += toJSON(level + 1, d);
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

    private <T> boolean isListOfType(List<?> list, Class<T> clazz) {
        return !list.isEmpty() && clazz.isInstance(list.get(0));
    }

    private String formatJSONValue(String s) {

        s = s.replaceAll("\"", "\\\\\"");
        s = s.replaceAll("\b", "\\b");
        s = s.replaceAll("\f", "\\f");
        s = s.replaceAll("\n", "\\n");
        s = s.replaceAll("\r", "\\r");
        s = s.replaceAll("\t", "\\t");

        return s;

    }

}
