package lattesite.css;

import lattesite.common.utils.StringUtil;
import lattesite.css.fontface.FontFace;
import lattesite.css.keyframes.KeyFrames;

import java.util.LinkedHashSet;
import java.util.Set;

/** Collects CSS {@link StyleBlock} rules and {@link KeyFrames} animations during page rendering. */
public class StyleContext {

    private final Set<StyleBlock> blocks = new LinkedHashSet<>();
    private final Set<KeyFrames> keyframes = new LinkedHashSet<>();

    /**
     * Adds a CSS class rule.
     *
     * @param className  the class name without the leading {@code .}
     * @param onCreation callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addClass(String className, OnCreation onCreation) {
        return this.addSelector("." + className, onCreation);
    }

    /**
     * Adds a CSS class rule wrapped in a {@code max-width} media query.
     *
     * @param className   the class name without the leading {@code .}
     * @param breakpoint  the {@code max-width} breakpoint in pixels
     * @param onCreation  callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addClass(String className, int breakpoint, OnCreation onCreation) {
        return this.addSelector("." + className, breakpoint, onCreation);
    }

    /**
     * Adds an arbitrary CSS selector rule.
     *
     * @param selector   the full CSS selector (e.g. {@code ".foo > span"})
     * @param onCreation callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addSelector(String selector, OnCreation onCreation) {
        return addSelector(selector, 0, onCreation);
    }

    /**
     * Adds the selector of {@code parent} wrapped in a {@code max-width} media query.
     *
     * @param parent     the block whose selector is reused
     * @param breakpoint the {@code max-width} breakpoint in pixels
     * @param onCreation callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addBlock(StyleBlock parent, int breakpoint, OnCreation onCreation) {
        return addSelector(parent.getSelector(), breakpoint, onCreation);
    }

    /**
     * Adds a descendant selector rule derived from {@code parent}'s selector.
     *
     * @param parent     the ancestor block
     * @param selector   the descendant selector appended to the parent's selector
     * @param onCreation callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addBlock(StyleBlock parent, String selector, OnCreation onCreation) {
        return this.addSelector(parent.getSelector() + " " + selector, onCreation);
    }

    /**
     * Adds a responsive descendant selector rule.
     *
     * @param parent     the ancestor block
     * @param selector   the descendant selector appended to the parent's selector
     * @param breakpoint the {@code max-width} breakpoint in pixels
     * @param onCreation callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addBlock(StyleBlock parent, String selector, int breakpoint, OnCreation onCreation) {
        return this.addSelector(parent.getSelector() + " " + selector, breakpoint, onCreation);
    }

    /**
     * Adds an arbitrary CSS selector rule with an optional media query breakpoint.
     *
     * @param selector   the full CSS selector
     * @param breakpoint the {@code max-width} breakpoint in pixels; {@code 0} means no media query
     * @param onCreation callback to populate the rule's properties
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addSelector(String selector, int breakpoint, OnCreation onCreation) {
        StyleBlock sc = new StyleBlock(selector, breakpoint);

        onCreation.initialize(sc);

        this.blocks.add(sc);
        return sc;
    }

    /** Adds a pre-built {@link StyleBlock} directly to the context. */
    public StyleBlock addBlock(StyleBlock block) {
        this.blocks.add(block);
        return block;
    }

    public Set<StyleBlock> getBlocks() {
        return this.blocks;
    }

    /**
     * Adds a {@code @font-face} rule using the given family name and source URL.
     *
     * @param fontFamily the font-family name
     * @param src        the {@code src} descriptor value (e.g. a URL string)
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addFontFace(String fontFamily, String src) {
        FontFace fontFace = new FontFace(fontFamily, src);
        return addFontFace(fontFace);
    }

    /**
     * Adds a {@code @font-face} rule from a {@link FontFace} descriptor object.
     *
     * @param fontFace the font face descriptor
     * @return the created {@link StyleBlock}
     */
    public StyleBlock addFontFace(FontFace fontFace) {
        StyleBlock block = new StyleBlock("@font-face");
        block.setProperty("font-family", fontFace.getFontFamilyName());
        block.setProperty("src", fontFace.getSrc());

        if (fontFace.getFontDisplay() != null) {
            block.setProperty("font-display", fontFace.getFontDisplay().getValue());
        }
        if (!StringUtil.isEmpty(fontFace.getFontWeight())) {
            block.setProperty("font-weight", fontFace.getFontWeight());
        }
        if (!StringUtil.isEmpty(fontFace.getFontStyle())) {
            block.setProperty("font-style", fontFace.getFontStyle());
        }
        if (!StringUtil.isEmpty(fontFace.getUnicodeRange())) {
            block.setProperty("unicode-range", fontFace.getUnicodeRange());
        }

        this.blocks.add(block);
        return block;
    }

    /** Adds a {@code @keyframes} animation to this context. */
    public void addKeyFrames(KeyFrames kf) {
        this.keyframes.add(kf);
    }

    public Set<KeyFrames> getKeyFrames() {
        return this.keyframes;
    }

    public interface OnCreation {

        void initialize(StyleBlock block);

    }
}
