package lattesite.css;

import java.util.LinkedHashSet;
import java.util.Set;

public class StyleContext {

    private final Set<StyleBlock> blocks = new LinkedHashSet<>();

    public StyleBlock addClass(String className, OnCreation onCreation) {
        return this.addBlock("." + className, onCreation);
    }

    public StyleBlock addSubBlock(StyleBlock parent, String selector, OnCreation onCreation) {
        return this.addSubBlock(parent, selector, 0, onCreation);
    }

    public StyleBlock addSubBlock(StyleBlock parent, String selector, int breakpoint, OnCreation onCreation) {
        return this.addBlock(parent.getSelector() + selector, breakpoint, onCreation);
    }

    public StyleBlock addBlock(String selector, OnCreation onCreation) {
        return addBlock(selector, 0, onCreation);
    }

    public StyleBlock addBlock(StyleBlock block, int breakpoint, OnCreation onCreation) {
        return addBlock(block.getSelector(), breakpoint, onCreation);
    }

    public StyleBlock addBlock(String selector, int breakpoint, OnCreation onCreation) {
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
        StyleBlock block = new StyleBlock("@font-face");
        block.setProperty("font-family", fontFamily);
        block.setProperty("src", src);
        this.blocks.add(block);
        return block;
    }

    public interface OnCreation {

        void initialize(StyleBlock block);

    }
}
