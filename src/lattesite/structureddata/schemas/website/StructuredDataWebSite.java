package lattesite.structureddata.schemas.website;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.language.StructuredDataLanguage;

/**
 * Represents a Schema.org {@code WebSite}.
 *
 * @see <a href="https://schema.org/WebSite">Schema.org/WebSite</a>
 */
public class StructuredDataWebSite extends StructuredDataSchema {

    private final String name;
    private final String description;
    private final String url;
    private StructuredDataLanguage inLanguage;

    /**
     * @param id          the JSON-LD {@code @id} for this website (typically the root URL)
     * @param name        the website name
     * @param description a short description of the website
     * @param url         the canonical URL of the website
     * @param inLanguage  the primary language of the website; may be {@code null}
     */
    public StructuredDataWebSite(
            String id,
            String name,
            String description,
            String url,
            StructuredDataLanguage inLanguage
    ) {
        super(id);
        this.name = name;
        this.description = description;
        this.url = url;
        this.inLanguage = inLanguage;
    }

    @Override
    public String getType() {
        return "WebSite";
    }

    public String getURL() {
        return this.url;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public StructuredDataLanguage getInLanguage() {
        return this.inLanguage;
    }

    public void setInLanguage(StructuredDataLanguage inLanguage) {
        this.inLanguage = inLanguage;
    }

}
