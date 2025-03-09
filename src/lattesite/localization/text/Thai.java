package lattesite.localization.text;

/** Represents a localized text string in Thai. */
public class Thai extends LocalizedText {

    /**
     * @param text the Thai text
     * @return a new {@link Thai} instance
     */
    public static Thai Thai(String text) {
        return new Thai(text);
    }

    public Thai(String text) {
        super(text);
    }

}
