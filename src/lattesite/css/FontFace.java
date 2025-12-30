package lattesite.css;

public class FontFace {

    private final String fontFamilyName;
    private final String src;
    private String fontDisplay;
    private String fontWeight;
    private String fontStyle;
    private String unicodeRange;

    public FontFace(String fontFamilyName, String src) {
        this.fontFamilyName = fontFamilyName;
        this.src = src;
        this.fontDisplay = null;
        this.fontWeight = null;
        this.fontStyle = null;
        this.unicodeRange = null;
    }

    public String getFontFamilyName() {
        return this.fontFamilyName;
    }

    public String getSrc() {
        return this.src;
    }

    public void setFontDisplay(String fontDisplay) {
        this.fontDisplay = fontDisplay;
    }

    public void setFontWeight(String fontWeight) {
        this.fontWeight = fontWeight;
    }

    public String getFontDisplay() {
        return this.fontDisplay;
    }

    public String getFontWeight() {
        return this.fontWeight;
    }

    public void setFontStyle(String fontStyle) {
        this.fontStyle = fontStyle;
    }

    public String getFontStyle() {
        return this.fontStyle;
    }

    public void setUnicodeRange(String unicodeRange) {
        this.unicodeRange = unicodeRange;
    }

    public String getUnicodeRange() {
        return this.unicodeRange;
    }
}
