package lattesite.css.keyframes;

import lattesite.css.StyleBlock;
import lattesite.css.StyleContext;

import java.util.LinkedHashMap;
import java.util.Map;

/** A CSS {@code @keyframes} animation block, composed of named timeline ranges and their associated style properties. */
public class KeyFrames {

    private final String id;
    private final Map<String, StyleBlock> ranges;

    public KeyFrames(String id) {
        this.id = id;
        this.ranges = new LinkedHashMap<>();
    }

    public String getID() {
        return this.id;
    }

    /**
     * Adds a keyframe range using a callback to populate its properties.
     *
     * @param timelineRangeName the keyframe selector (e.g. {@code "0%"}, {@code "from"}, {@code "to"})
     * @param onCreation        callback to set CSS properties on the range's {@link StyleBlock}
     */
    public void put(String timelineRangeName, StyleContext.OnCreation onCreation) {
        StyleBlock sb = new StyleBlock(timelineRangeName);
        onCreation.initialize(sb);
        this.put(timelineRangeName, sb);
    }

    /**
     * Adds a pre-built {@link StyleBlock} as a keyframe range.
     *
     * @param timelineRangeName the keyframe selector (e.g. {@code "0%"}, {@code "from"}, {@code "to"})
     * @param sb                the style block containing the range's CSS properties
     */
    public void put(String timelineRangeName, StyleBlock sb) {
        this.ranges.put(timelineRangeName, sb);
    }

    public Map<String, StyleBlock> getRanges() {
        return this.ranges;
    }

}
