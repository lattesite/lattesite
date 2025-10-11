package lattesite.css;

import java.util.LinkedHashSet;
import java.util.Set;

public class StyleContext {

    private final Set<StyleBlock> blocks = new LinkedHashSet<>();

    public StyleBlock addClass(String className, OnCreation onCreation) {
        return this.addSelector("." + className, onCreation);
    }

    public StyleBlock addClass(String className, int breakpoint, OnCreation onCreation) {
        return this.addSelector("." + className, breakpoint, onCreation);
    }

    public StyleBlock addSelector(String selector, OnCreation onCreation) {
        return addSelector(selector, 0, onCreation);
    }

    public StyleBlock addBlock(StyleBlock parent, int breakpoint, OnCreation onCreation) {
        return addSelector(parent.getSelector(), breakpoint, onCreation);
    }

    public StyleBlock addBlock(StyleBlock parent, String selector, OnCreation onCreation) {
        return this.addSelector(parent.getSelector() + " " + selector, onCreation);
    }

    public StyleBlock addBlock(StyleBlock parent, String selector, int breakpoint, OnCreation onCreation) {
        return this.addSelector(parent.getSelector() + " " + selector, breakpoint, onCreation);
    }

    public StyleBlock addSelector(String selector, int breakpoint, OnCreation onCreation) {
        StyleBlock sc = new StyleBlock(selector, breakpoint);

        onCreation.initialize(sc);

        this.blocks.add(sc);
        return sc;
    }

    public StyleBlock addBlock(StyleBlock block) {
        this.blocks.add(block);
        return block;
    }

    public Set<StyleBlock> getBlocks() {
        return this.blocks;
    }

    public StyleBlock addFontFace(String fontFamily, String src) {
        return addFontFace(fontFamily, src, "auto");
    }

    public StyleBlock addFontFace(String fontFamily, String src, String fontDisplay) {
        StyleBlock block = new StyleBlock("@font-face");
        block.setProperty("font-family", fontFamily);
        block.setProperty("src", src);
        block.setProperty("font-display", fontDisplay);
        this.blocks.add(block);
        return block;
    }

    public interface OnCreation {

        void initialize(StyleBlock block);

    }
}
