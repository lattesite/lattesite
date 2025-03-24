package lattesite.css;

import java.util.LinkedHashMap;
import java.util.Map;

public class StyleBlock {

    private final String selector;
    private final int breakpoint;
    private final Map<String, String> properties;

    public StyleBlock(String selector) {
        this(selector, 0);
    }

    public StyleBlock(String selector, int breakpoint) {
        this.selector = selector;
        this.breakpoint = breakpoint;
        this.properties = new LinkedHashMap<>();
    }

    public StyleBlock setProperty(String key, int value) {
        return this.setProperty(key, Integer.toString(value));
    }

    public StyleBlock setProperty(String key, String value) {
        this.properties.put(key.trim(), value.trim());
        return this;
    }

    public StyleBlock setProperties(Map<String, String> properties) {
        this.properties.putAll(properties);
        return this;
    }

    public String getSelector() {
        return this.selector;
    }

    public Map<String, String> getProperties() {
        return this.properties;
    }

    public int getBreakpoint() {
        return this.breakpoint;
    }

    /*
     * Common properties
     */

    public StyleBlock setColor(String value) {
        return this.setProperty("color", value);
    }

    public StyleBlock setTextAlign(String value) {
        return this.setProperty("text-align", value);
    }

    public StyleBlock setTextDecoration(String value) {
        return this.setProperty("text-decoration", value);
    }

    public StyleBlock setFontSize(String value) {
        return this.setProperty("font-size", value);
    }

    public StyleBlock setBackgroundColor(String value) {
        return this.setProperty("background-color", value);
    }

    public StyleBlock setFontFamily(String value) {
        return this.setProperty("font-family", value);
    }

    public StyleBlock setMarginTop(int px) {
        return this.setProperty("margin-top", px + "px");
    }

    public StyleBlock setMarginBottom(int px) {
        return this.setProperty("margin-bottom", px + "px");
    }

    public StyleBlock setLineHeight(String value) {
        return this.setProperty("line-height", value);
    }

    public StyleBlock setDisplay(String value) {
        return this.setProperty("display", value);
    }

    public StyleBlock setGap(int px) {
        return this.setProperty("gap", px + "px");
    }

    public StyleBlock setCursor(String cursor) {
        return this.setProperty("cursor", cursor);
    }

    public StyleBlock setFlexWrap(String value) {
        return this.setProperty("flex-wrap", value);
    }

}
