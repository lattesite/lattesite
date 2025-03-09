package lattesite.html.elements;

/** An immutable key/value pair representing a single HTML attribute. */
public class HTMLElementProperty {
    private final String key;
    private final String value;

    public HTMLElementProperty(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
