package lattesite.localization.text;

/** Represents a localized text string in Bulgarian. */
public class Bulgarian extends LocalizedText {

    /**
     * @param text the Bulgarian text
     * @return a new {@link Bulgarian} instance
     */
    public static Bulgarian Bulgarian(String text) {
        return new Bulgarian(text);
    }

    public Bulgarian(String text) {
        super(text);
    }

}
