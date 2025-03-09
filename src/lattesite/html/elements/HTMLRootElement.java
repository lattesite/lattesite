package lattesite.html.elements;

/** A parentless root element; defaults to the tag name {@code "root"}, typically overridden to {@code "html"}. */
public class HTMLRootElement extends HTMLElement {

    public HTMLRootElement() {
        this("root");
    }

    public HTMLRootElement(String tagName) {
        super(null, tagName, false);
    }

}

