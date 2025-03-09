package lattesite.localization.text;

/** Represents a localized text string in Romanian. */
public class Romanian extends LocalizedText {

    /**
     * @param text the Romanian text
     * @return a new {@link Romanian} instance
     */
    public static Romanian Romanian(String text) {
        return new Romanian(text);
    }

    public Romanian(String text) {
        super(text);
    }

}
