package lattesite.localization.text;

/** Represents a localized text string in Latvian. */
public class Latvian extends LocalizedText {

    /**
     * @param text the Latvian text
     * @return a new {@link Latvian} instance
     */
    public static Latvian Latvian(String text) {
        return new Latvian(text);
    }

    public Latvian(String text) {
        super(text);
    }

}
