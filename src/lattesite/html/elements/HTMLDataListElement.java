package lattesite.html.elements;

public class HTMLDataListElement extends HTMLElement {

    public HTMLDataListElement(HTMLElement parent, String id) {
        super(parent, "datalist", false);
        this.setID(id);
    }

}
