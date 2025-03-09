package lattesite.localization.text;

/** Represents a localized text string in Turkish. */
public class Turkish extends LocalizedText {

    /**
     * @param text the Turkish text
     * @return a new {@link Turkish} instance
     */
    public static Turkish Turkish(String text) {
        return new Turkish(text);
    }

    public Turkish(String text) {
        super(text);
    }

}
