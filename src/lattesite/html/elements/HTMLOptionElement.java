package lattesite.html.elements;

public class HTMLOptionElement extends HTMLElement {

    //    public HTMLOptionElement(HTMLSelectElement parent, String text, String value) {
    public HTMLOptionElement(HTMLElement parent, String text, String value) {
        super(parent, "option", false);
        this.setText(text);
        this.setValue(value);
    }

    public void setValue(String value) {
        setAttribute("value", value);
    }

    public void setSelected(boolean selected) {
        if (selected) {
            setAttribute("selected", selected);
        } else {
            removeAttribute("selected");
        }
    }

}
