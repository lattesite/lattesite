package lattesite.localization.text;

/** Represents a localized text string in Spanish. */
public class Spanish extends LocalizedText {

    /**
     * @param text the Spanish text
     * @return a new {@link Spanish} instance
     */
    public static Spanish Spanish(String text) {
        return new Spanish(text);
    }

    public Spanish(String text) {
        super(text);
    }

}
