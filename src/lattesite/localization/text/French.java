package lattesite.localization.text;

/** Represents a localized text string in French. */
public class French extends LocalizedText {

    /**
     * @param text the French text
     * @return a new {@link French} instance
     */
    public static French French(String text) {
        return new French(text);
    }

    public French(String text) {
        super(text);
    }

}
