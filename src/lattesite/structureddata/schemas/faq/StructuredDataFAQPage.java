package lattesite.structureddata.schemas.faq;

import lattesite.structureddata.schemas.StructuredDataSchema;

import java.util.List;

/**
 * Represents a Schema.org {@code FAQPage} — a page containing a list of frequently asked questions.
 *
 * @see <a href="https://schema.org/FAQPage">Schema.org/FAQPage</a>
 */
public class StructuredDataFAQPage extends StructuredDataSchema {

    private final List<StructuredDataQuestion> mainEntity;

    /**
     * @param id         the JSON-LD {@code @id} for this FAQ page
     * @param mainEntity the list of questions on this page
     */
    public StructuredDataFAQPage(
            String id,
            List<StructuredDataQuestion> mainEntity
    ) {
        super(id);
        this.mainEntity = mainEntity;
    }

    @Override
    public String getType() {
        return "FAQPage";
    }

    public List<StructuredDataQuestion> getMainEntity() {
        return this.mainEntity;
    }

}
