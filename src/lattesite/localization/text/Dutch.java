package lattesite.localization.text;

/** Represents a localized text string in Dutch. */
public class Dutch extends LocalizedText {

    /**
     * @param text the Dutch text
     * @return a new {@link Dutch} instance
     */
    public static Dutch Dutch(String text) {
        return new Dutch(text);
    }

    public Dutch(String text) {
        super(text);
    }

}
