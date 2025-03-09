package lattesite.localization.text;

/** Represents a localized text string in Finnish. */
public class Finnish extends LocalizedText {

    /**
     * @param text the Finnish text
     * @return a new {@link Finnish} instance
     */
    public static Finnish Finnish(String text) {
        return new Finnish(text);
    }

    public Finnish(String text) {
        super(text);
    }

}
