package lattesite.html.elements;

public class HTMLTableRowCellElement extends HTMLElement {

    public HTMLTableRowCellElement(HTMLTableRowElement parent) {
        super(parent, "td", false);
    }

    public void setColSpan(int span) {
        this.setAttribute("colspan", span);
    }

}
