package lattesite.structured.data.schemas;

public class StructuredDataAnswer {

    private final String text;

    public StructuredDataAnswer(
            String text
    ) {
        this.text = text;
    }

    public String getText() {
        return this.text;
    }

}
