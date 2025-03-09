package lattesite.css;

/** An immutable CSS hexadecimal color value (e.g. {@code #FF5733}), stored in upper case. */
public class HEXColor {

    private final String color;

    public HEXColor(String color) {
        this.color = color.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return this.color;
    }

    /** @return the hex digits without the leading {@code #} (e.g. {@code "FF5733"}) */
    public String getHexCode() {
        return this.color.substring(1);
    }

}
