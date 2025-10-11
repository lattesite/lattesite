package lattesite.css;

public class HEXColor {

    private final String color;

    public HEXColor(String color) {
        this.color = color.trim().toUpperCase();
    }

    @Override
    public String toString() {
        return this.color;
    }

    public String getHexCode() {
        return this.color.substring(1);
    }

}
