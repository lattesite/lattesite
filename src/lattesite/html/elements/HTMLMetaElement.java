package lattesite.html.elements;

public class HTMLMetaElement extends HTMLElement {

    public HTMLMetaElement(
            HTMLElement parent,
            String content
    ) {
        super(parent, "meta", true);
        this.setAttribute("content", content);
    }

    public void setName(String name) {
        this.setAttribute("name", name);
    }

    public void setProperty(String value) {
        this.setAttribute("property", value);
    }

    /**
     * Sets the {@code http-equiv} attribute, which maps the meta element to an HTTP response header
     * (e.g. {@code "content-type"}, {@code "refresh"}).
     *
     * @param value the header name to emulate
     */
    public void setHttpEquiv(String value) {
        this.setAttribute("http-equiv", value);
    }

}
