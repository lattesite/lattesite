package lattesite.html.elements;

public class HTMLSelectElement extends HTMLElement {

    public HTMLSelectElement(HTMLElement parent) {
        super(parent, "select", false);
    }

    public void setSize(int size) {
        this.setAttribute("size", size);
    }

    public void setOnClick(String onClick) {
        this.setAttribute("onclick", onClick);
    }

    public void setOnChange(String onChange) {
        this.setAttribute("onchange", onChange);
    }

}
