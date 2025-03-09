package lattesite.localization.text;

/** Represents a localized text string in German. */
public class German extends LocalizedText {

    /**
     * @param text the German text
     * @return a new {@link German} instance
     */
    public static German German(String text) {
        return new German(text);
    }

    public German(String text) {
        super(text);
    }

}
