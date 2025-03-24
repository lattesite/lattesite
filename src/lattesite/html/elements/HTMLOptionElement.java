package lattesite.html.elements;

public class HTMLOptionElement extends HTMLElement {

    public HTMLOptionElement(HTMLSelectElement parent, String text, String value) {
        super(parent, "option", false);
        this.setText(text);
        this.setValue(value);
    }

    public void setValue(String value) {
        setAttribute("value", value);
    }

}
