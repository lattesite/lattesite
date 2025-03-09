package lattesite.localization.text;

/** Represents a localized text string in Hindi. */
public class Hindi extends LocalizedText {

    /**
     * @param text the Hindi text
     * @return a new {@link Hindi} instance
     */
    public static Hindi Hindi(String text) {
        return new Hindi(text);
    }

    public Hindi(String text) {
        super(text);
    }

}
