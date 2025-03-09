package lattesite.structureddata.schemas.brand;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code Brand}.
 *
 * <p>An optional logo URL can be set after construction via {@link #setLogo(String)}.</p>
 *
 * @see <a href="https://schema.org/Brand">Schema.org/Brand</a>
 */
public class StructuredDataBrand extends StructuredDataSchema {

    private final String name;
    private String logo;

    /**
     * @param id   the JSON-LD {@code @id} for this brand
     * @param name the brand name
     */
    public StructuredDataBrand(
            String id,
            String name
    ) {
        super(id);
        this.name = name;
        this.logo = null;
    }

    @Override
    public String getType() {
        return "Brand";
    }

    public String getName() {
        return this.name;
    }

    public String getLogo() {
        return this.logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
