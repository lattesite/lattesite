package lattesite.html.elements;

public class HTMLCodeElement extends HTMLElement {

    public HTMLCodeElement(HTMLElement parent) {
        this(parent, null);
    }

    public HTMLCodeElement(
            HTMLElement parent,
            String code
    ) {
        super(parent, "code", false);
        if (code != null) {
            this.setText(code);
        }
    }

}
