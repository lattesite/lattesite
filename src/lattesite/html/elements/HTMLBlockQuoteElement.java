package lattesite.html.elements;

public class HTMLBlockQuoteElement extends HTMLElement {

    public HTMLBlockQuoteElement(HTMLElement parent) {
        this(parent, null);
    }

    public HTMLBlockQuoteElement(
            HTMLElement parent,
            String quote
    ) {
        super(parent, "blockquote", false);
        if (quote != null) {
            this.setText(quote);
        }
    }

}
