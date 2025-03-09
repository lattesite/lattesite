package lattesite.structureddata.schemas.faq;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code Question} in a FAQ page.
 *
 * @see <a href="https://schema.org/Question">Schema.org/Question</a>
 */
public class StructuredDataQuestion extends StructuredDataSchema {

    private final String name;
    private final StructuredDataAnswer acceptedAnswer;

    /**
     * @param id             the JSON-LD {@code @id} for this question
     * @param name           the question text
     * @param acceptedAnswer the accepted answer to this question
     */
    public StructuredDataQuestion(
            String id,
            String name,
            StructuredDataAnswer acceptedAnswer
    ) {
        super(id);
        this.name = name;
        this.acceptedAnswer = acceptedAnswer;
    }

    @Override
    public String getType() {
        return "Question";
    }

    public String getName() {
        return this.name;
    }

    public StructuredDataAnswer getAcceptedAnswer() {
        return this.acceptedAnswer;
    }

}
