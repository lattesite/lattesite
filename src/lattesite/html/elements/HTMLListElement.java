package lattesite.html.elements;

/** Abstract base for HTML list elements ({@code <ul>} and {@code <ol>}). */
public abstract class HTMLListElement extends HTMLElement {

    public HTMLListElement(HTMLElement parent, String tagName) {
        super(parent, tagName, false);
    }
}
