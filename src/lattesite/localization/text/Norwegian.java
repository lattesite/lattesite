package lattesite.localization.text;

/** Represents a localized text string in Norwegian. */
public class Norwegian extends LocalizedText {

    /**
     * @param text the Norwegian text
     * @return a new {@link Norwegian} instance
     */
    public static Norwegian Norwegian(String text) {
        return new Norwegian(text);
    }

    public Norwegian(String text) {
        super(text);
    }

}
