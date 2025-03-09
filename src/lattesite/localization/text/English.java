package lattesite.localization.text;

/** Represents a localized text string in English. */
public class English extends LocalizedText {

    /**
     * @param text the English text
     * @return a new {@link English} instance
     */
    public static English English(String text) {
        return new English(text);
    }

    public English(String text) {
        super(text);
    }

}
