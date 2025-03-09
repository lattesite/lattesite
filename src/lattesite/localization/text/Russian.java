package lattesite.localization.text;

/** Represents a localized text string in Russian. */
public class Russian extends LocalizedText {

    /**
     * @param text the Russian text
     * @return a new {@link Russian} instance
     */
    public static Russian Russian(String text) {
        return new Russian(text);
    }

    public Russian(String text) {
        super(text);
    }

}
