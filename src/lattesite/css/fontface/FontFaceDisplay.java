package lattesite.css.fontface;

/** Controls how a font face is displayed while loading, corresponding to the CSS {@code font-display} descriptor. */
public enum FontFaceDisplay {

    AUTO("auto"),
    BLOCK("block"),
    FALLBACK("fallback"),
    OPTIONAL("optional"),
    SWAP("swap");

    private final String value;

    FontFaceDisplay(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
