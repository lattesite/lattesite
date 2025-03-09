package lattesite.structureddata.schemas.faq;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code Answer} — the accepted answer to a FAQ question.
 *
 * @see <a href="https://schema.org/Answer">Schema.org/Answer</a>
 */
public class StructuredDataAnswer extends StructuredDataSchema {

    private final String text;

    /**
     * @param id   the JSON-LD {@code @id} for this answer
     * @param text the answer text
     */
    public StructuredDataAnswer(
            String id,
            String text
    ) {
        super(id);
        this.text = text;
    }

    @Override
    public String getType() {
        return "Answer";
    }

    public String getText() {
        return this.text;
    }

}
