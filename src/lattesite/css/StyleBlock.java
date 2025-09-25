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

    public StyleBlock setProperty(String key, HEXColor value) {
        this.properties.put(key.trim(), value.toString());
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

}
