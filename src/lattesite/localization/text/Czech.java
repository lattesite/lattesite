package lattesite.localization.text;

/** Represents a localized text string in Czech. */
public class Czech extends LocalizedText {

    /**
     * @param text the Czech text
     * @return a new {@link Czech} instance
     */
    public static Czech Czech(String text) {
        return new Czech(text);
    }

    public Czech(String text) {
        super(text);
    }

}
