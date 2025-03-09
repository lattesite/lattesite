package lattesite.localization.text;

/** Represents a localized text string in Ukrainian. */
public class Ukrainian extends LocalizedText {

    /**
     * @param text the Ukrainian text
     * @return a new {@link Ukrainian} instance
     */
    public static Ukrainian Ukrainian(String text) {
        return new Ukrainian(text);
    }

    public Ukrainian(String text) {
        super(text);
    }

}
