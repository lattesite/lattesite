package lattesite.localization.text;

/** Represents a localized text string in Japanese. */
public class Japanese extends LocalizedText {

    /**
     * @param text the Japanese text
     * @return a new {@link Japanese} instance
     */
    public static Japanese Japanese(String text) {
        return new Japanese(text);
    }

    public Japanese(String text) {
        super(text);
    }

}
