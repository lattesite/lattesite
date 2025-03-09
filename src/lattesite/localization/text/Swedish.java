package lattesite.localization.text;

/** Represents a localized text string in Swedish. */
public class Swedish extends LocalizedText {

    /**
     * @param text the Swedish text
     * @return a new {@link Swedish} instance
     */
    public static Swedish Swedish(String text) {
        return new Swedish(text);
    }

    public Swedish(String text) {
        super(text);
    }

}
