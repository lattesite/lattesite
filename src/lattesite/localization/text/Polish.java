package lattesite.localization.text;

/** Represents a localized text string in Polish. */
public class Polish extends LocalizedText {

    /**
     * @param text the Polish text
     * @return a new {@link Polish} instance
     */
    public static Polish Polish(String text) {
        return new Polish(text);
    }

    public Polish(String text) {
        super(text);
    }

}
