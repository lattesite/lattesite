package lattesite.localization.text;

/** Represents a localized text string in Greek. */
public class Greek extends LocalizedText {

    /**
     * @param text the Greek text
     * @return a new {@link Greek} instance
     */
    public static Greek Greek(String text) {
        return new Greek(text);
    }

    public Greek(String text) {
        super(text);
    }

}
