package lattesite.googlemerchant.services;

import lattesite.common.utils.StringUtil;
import lattesite.googlemerchant.interfaces.GoogleMerchantProduct;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Generates a Google Merchant Center RSS/XML product feed from a list of {@link Product} objects.
 */
public class GoogleMerchantService {

    private final String storeTitle;
    private final String storeDescription;
    private final String storeLink;
    private final Map<String, String> additionalNameSpaces;
    private final String indentation;
    private final String nl;

    /**
     * Creates a service with default formatting (2-space indentation, Unix line endings).
     *
     * @param storeTitle       the title of the store, used in the channel {@code <title>} element
     * @param storeDescription a short description of the store, used in the channel {@code <description>} element
     * @param storeLink        the canonical URL of the store, used in the channel {@code <link>} element
     */
    public GoogleMerchantService(
            String storeTitle,
            String storeDescription,
            String storeLink
    ) {
        this(
                storeTitle,
                storeDescription,
                storeLink,
                new HashMap<>(),
                "  ",
                "\n"
        );
    }

    /**
     * Creates a service with custom formatting and additional XML namespaces.
     *
     * @param storeTitle           the title of the store
     * @param storeDescription     a short description of the store
     * @param storeLink            the canonical URL of the store
     * @param additionalNameSpaces extra XML namespace declarations to include on the root {@code <rss>} element,
     *                             keyed by prefix (e.g. {@code "custom" -> "http://example.com/ns"})
     * @param indentation          the string used for one level of indentation (e.g. {@code "  "} or {@code "\t"})
     * @param nl                   the newline string (e.g. {@code "\n"} or {@code "\r\n"})
     */
    public GoogleMerchantService(
            String storeTitle,
            String storeDescription,
            String storeLink,
            Map<String, String> additionalNameSpaces,
            String indentation,
            String nl
    ) {
        this.storeTitle = storeTitle;
        this.storeDescription = storeDescription;
        this.storeLink = storeLink;
        this.additionalNameSpaces = Map.copyOf(additionalNameSpaces);
        this.indentation = indentation;
        this.nl = nl;
    }

    /**
     * Generates a Google Merchant Center XML feed for the given products.
     *
     * @param products the list of products to include in the feed
     * @return the complete XML feed as a string
     * @throws Exception if any {@link Product} method throws
     */
    public String generate(List<? extends GoogleMerchantProduct> products) throws Exception {

        StringBuilder xml = new StringBuilder();
        xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>").append(this.nl);
        xml.append("<rss xmlns:g=\"http://base.google.com/ns/1.0\" version=\"3.0\"");
        for (Map.Entry<String, String> additionalNameSpace : this.additionalNameSpaces.entrySet()) {
            xml.append(" xmlns:").append(additionalNameSpace.getKey()).append("=\"").append(additionalNameSpace.getValue()).append("\"");
        }
        xml.append(">").append(this.nl);
        xml.append(indent(1)).append("<channel>").append(this.nl);
        xml.append(indent(2)).append("<title>").append(escape(this.storeTitle)).append("</title>").append(this.nl);
        xml.append(indent(2)).append("<description>").append(escape(this.storeDescription)).append("</description>").append(this.nl);
        xml.append(indent(2)).append("<link>").append(escape(this.storeLink)).append("</link>").append(this.nl);

        for (GoogleMerchantProduct product : products) {

            xml.append(indent(2)).append("<item>").append(this.nl);
            xml.append(indent(3)).append("<g:id>").append(product.getID()).append("</g:id>").append(this.nl);
            if (!StringUtil.isEmpty(product.getGroupID())) {
                xml.append(indent(3)).append("<g:item_group_id>").append(product.getGroupID()).append("</g:item_group_id>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getSKU())) {
                xml.append(indent(3)).append("<g:sku>").append(product.getSKU()).append("</g:sku>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getEAN())) {
                xml.append(indent(3)).append("<g:ean>").append(product.getEAN()).append("</g:ean>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getGTIN())) {
                xml.append(indent(3)).append("<g:gtin>").append(product.getGTIN()).append("</g:gtin>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getMPN())) {
                xml.append(indent(3)).append("<g:mpn>").append(product.getMPN()).append("</g:mpn>").append(this.nl);
            }

            xml.append(indent(3)).append("<g:title>").append(escape(product.getTitle())).append("</g:title>").append(this.nl);
            xml.append(indent(3)).append("<g:link>").append(escape(product.getLink())).append("</g:link>").append(this.nl);
            xml.append(indent(3)).append("<g:brand>").append(escape(product.getBrand())).append("</g:brand>").append(this.nl);
            xml.append(indent(3)).append("<g:description>").append(escape(product.getDescription())).append("</g:description>").append(this.nl);
            xml.append(indent(3)).append("<g:condition>").append(product.getCondition().getCode()).append("</g:condition>").append(this.nl);
            xml.append(indent(3)).append("<g:adult>").append(product.isAdult()).append("</g:adult>").append(this.nl);
            if (product.getAgeGroup() != null) {
                xml.append(indent(3)).append("<g:age_group>").append(product.getAgeGroup().getCode()).append("</g:age_group>").append(this.nl);
            }

            xml.append(indent(3)).append("<g:availability>").append(product.getAvailability().getCode()).append("</g:availability>").append(this.nl);
            if (!StringUtil.isEmpty(product.getAvailabilityDate())) {
                xml.append(indent(3)).append("<g:availability_date>").append(product.getAvailabilityDate()).append("</g:availability_date>").append(this.nl);
            }

            xml.append(indent(3)).append("<g:price>").append(product.getPrice()).append(" ").append(product.getCurrency()).append("</g:price>").append(this.nl);

            xml.append(indent(3)).append("<g:image_link>").append(escape(product.getImageURLs().get(0))).append("</g:image_link>").append(this.nl);
            for (int i = 1; i < product.getImageURLs().size(); i++) {
                xml.append(indent(3)).append("<g:additional_image_link>").append(escape(product.getImageURLs().get(i))).append("</g:additional_image_link>").append(this.nl);
            }

            xml.append(indent(3)).append("<g:google_product_category>").append(product.getProductCategory().getID()).append("</g:google_product_category>").append(this.nl);

            for (String type : product.getTypes()) {
                xml.append(indent(3)).append("<g:product_type>").append(escape(type)).append("</g:product_type>").append(this.nl);
            }

            xml.append(indent(3)).append("<g:color>").append(escape(product.getColor())).append("</g:color>").append(this.nl);
            xml.append(indent(3)).append("<g:gender>").append(product.getGender().getCode()).append("</g:gender>").append(this.nl);
            xml.append(indent(3)).append("<g:material>").append(escape(product.getMaterial())).append("</g:material>").append(this.nl);
            xml.append(indent(3)).append("<g:size>").append(product.getSize()).append("</g:size>").append(this.nl);
            xml.append(indent(3)).append("<g:size_system>").append(product.getSizeSystem().getCode()).append("</g:size_system>").append(this.nl);

            if (!StringUtil.isEmpty(product.getProductLength())) {
                xml.append(indent(3)).append("<g:product_length>").append(product.getProductLength()).append("</g:product_length>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getProductWidth())) {
                xml.append(indent(3)).append("<g:product_width>").append(product.getProductWidth()).append("</g:product_width>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getProductHeight())) {
                xml.append(indent(3)).append("<g:product_height>").append(product.getProductHeight()).append("</g:product_height>").append(this.nl);
            }
            if (!StringUtil.isEmpty(product.getProductWeight())) {
                xml.append(indent(3)).append("<g:product_weight>").append(product.getProductWeight()).append("</g:product_weight>").append(this.nl);
            }

            if (product.getProperties() != null) {
                for (Map.Entry<String, String> entry : product.getProperties().entrySet()) {
                    xml.append(indent(3)).append("<g:product_detail>").append(this.nl);
                    xml.append(indent(4)).append("<g:attribute_name>").append(escape(entry.getKey())).append("</g:attribute_name>").append(this.nl);
                    xml.append(indent(4)).append("<g:attribute_value>").append(escape(entry.getValue())).append("</g:attribute_value>").append(this.nl);
                    xml.append(indent(3)).append("</g:product_detail>").append(this.nl);
                }
            }
            xml.append(indent(2)).append("</item>").append(this.nl);
        }

        xml.append(indent(1)).append("</channel>").append(this.nl);
        xml.append("</rss>").append(this.nl);

        return xml.toString();
    }

    /**
     * Returns a string of {@code level} repetitions of the configured indentation string.
     *
     * @param level the nesting depth
     * @return the indentation prefix for that depth
     */
    private String indent(int level) {
        return this.indentation.repeat(level);
    }

    /**
     * Escapes XML special characters in {@code s} so it is safe to embed in element content or attribute values.
     * Returns an empty string if {@code s} is {@code null}.
     *
     * @param s the raw string to escape
     * @return an XML-safe version of {@code s}, or {@code ""} if {@code s} is {@code null}
     */
    private String escape(String s) {
        if (s == null) {
            return "";
        }
        return s
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }

}
