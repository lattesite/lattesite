package lattesite.localization.text;

/** Represents a localized text string in Italian. */
public class Italian extends LocalizedText {

    /**
     * @param text the Italian text
     * @return a new {@link Italian} instance
     */
    public static Italian Italian(String text) {
        return new Italian(text);
    }

    public Italian(String text) {
        super(text);
    }

}
