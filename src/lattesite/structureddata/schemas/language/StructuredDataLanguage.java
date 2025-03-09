package lattesite.structureddata.schemas.language;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code Language}.
 *
 * @see <a href="https://schema.org/Language">Schema.org/Language</a>
 */
public class StructuredDataLanguage extends StructuredDataSchema {

    private final String name;

    /**
     * @param id   the JSON-LD {@code @id} for this language
     * @param name the language name (e.g. {@code "English"} or a BCP 47 tag such as {@code "en"})
     */
    public StructuredDataLanguage(
            String id,
            String name
    ) {
        super(id);
        this.name = name;
    }

    @Override
    public String getType() {
        return "Language";
    }

    public String getName() {
        return this.name;
    }

}
