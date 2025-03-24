package lattesite.services;

import lattesite.css.StyleBlock;

import java.util.Map;

public class StyleGeneratorService implements StyleGeneratorServiceInterface {

    private final String indentation;
    private final String spacing;
    private final String nl;

    public StyleGeneratorService(int mobileBreakPoint) {
        this("    ", " ", "\n");
    }

    public StyleGeneratorService(String indentation, String spacing, String nl) {
        this.indentation = indentation;
        this.spacing = spacing;
        this.nl = nl;
    }

    public String toCSS(StyleBlock block) {

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
//
//    public String toCSS(StyleBlock sc) {
//
//        String css = sc.getSelector() + spacing + "{" + this.nl;
//        for (Map.Entry<String, String> entry : sc.getProperties().entrySet()) {
//            css += indentation + entry.getKey() + ":" + spacing + entry.getValue() + ";" + this.nl;
//        }
//        css += "}" + this.nl;
//
//        if (!sc.getMobileStyles().isEmpty()) {
//            css += "@media" + this.spacing + "(max-width:" + this.mobileBreakPoint + "px)" + this.spacing + "{" + this.nl;
//            css += indentation.repeat(1) + sc.getSelector() + spacing + "{" + this.nl;
//            for (Map.Entry<String, String> entry : sc.getMobileStyles().entrySet()) {
//                css += indentation.repeat(2) + entry.getKey() + ":" + spacing + entry.getValue() + ";" + this.nl;
//            }
//            css += indentation.repeat(1) + "}" + this.nl;
//            css += "}" + this.nl;
//        }
//
//        return css;
//
//    }

}
