package lattesite.localization.text;

/** Represents a localized text string in Croatian. */
public class Croatian extends LocalizedText {

    /**
     * @param text the Croatian text
     * @return a new {@link Croatian} instance
     */
    public static Croatian Croatian(String text) {
        return new Croatian(text);
    }

    public Croatian(String text) {
        super(text);
    }

}
