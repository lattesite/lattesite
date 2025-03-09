package lattesite.css.services;

import lattesite.css.StyleBlock;
import lattesite.css.keyframes.KeyFrames;

import java.util.Map;

/** Renders {@link StyleBlock} rules and {@link KeyFrames} animations to CSS strings. */
public class StyleGeneratorService implements StyleGeneratorServiceInterface {

    private final String indentation;
    private final String spacing;
    private final String nl;

    public StyleGeneratorService() {
        this("    ", " ", "\n");
    }

    public StyleGeneratorService(String indentation, String spacing, String nl) {
        this.indentation = indentation;
        this.spacing = spacing;
        this.nl = nl;
    }

    /**
     * @param block the style block to render
     * @return the CSS string, wrapped in a {@code @media} query if the block has a breakpoint; empty string if no properties
     */
    public String toCSS(StyleBlock block) {

        if (block.getProperties().isEmpty()) {
            return "";
        }

        boolean hasBreakpoint = block.getBreakpoint() != 0;

        String css = "";

        if (hasBreakpoint) {
            css += "@media" + this.spacing + "(max-width:" + block.getBreakpoint() + "px)" + this.spacing + "{" + this.nl;
        }

        css += indentation.repeat(hasBreakpoint ? 1 : 0) + block.getSelector() + spacing + "{" + this.nl;
        for (Map.Entry<String, String> entry : block.getProperties().entrySet()) {
            css += indentation.repeat(hasBreakpoint ? 2 : 1) + entry.getKey() + ":" + spacing + entry.getValue() + ";" + this.nl;
        }
        css += indentation.repeat(hasBreakpoint ? 1 : 0) + "}" + this.nl;

        if (hasBreakpoint) {
            css += "}" + this.nl;
        }

        return css;

    }

    /**
     * @param keyFrames the keyframes animation to render
     * @return the {@code @keyframes} CSS string; empty string if no ranges are defined
     */
    public String toCSS(KeyFrames keyFrames) {

        if (keyFrames.getRanges().isEmpty()) {
            return "";
        }

        String css = "";

        css += "@keyframes " + keyFrames.getID() + this.spacing + "{" + this.nl;
        for (Map.Entry<String, StyleBlock> entry : keyFrames.getRanges().entrySet()) {
            css += indentation.repeat(1) + entry.getKey() + this.spacing + "{" + this.nl;
            for (Map.Entry<String, String> blockItem : entry.getValue().getProperties().entrySet()) {
                css += indentation.repeat(2) + blockItem.getKey() + ":" + spacing + blockItem.getValue() + ";" + this.nl;
            }
            css += indentation.repeat(1) + "}" + this.nl;
        }
        css += "}" + this.nl;

        return css;

    }

}
