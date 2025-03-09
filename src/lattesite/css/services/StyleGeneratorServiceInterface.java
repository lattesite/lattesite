package lattesite.css.services;

import lattesite.css.StyleBlock;
import lattesite.css.keyframes.KeyFrames;

/** Converts CSS model objects to CSS strings. */
public interface StyleGeneratorServiceInterface {

    /** @return the CSS string for the given rule block, or an empty string if the block has no properties */
    String toCSS(StyleBlock sb);

    /** @return the CSS string for the given keyframes animation, or an empty string if it has no ranges */
    String toCSS(KeyFrames kf);

}
