package lattesite.localization.text;

/** Represents a localized text string in Indonesian. */
public class Indonesian extends LocalizedText {

    /**
     * @param text the Indonesian text
     * @return a new {@link Indonesian} instance
     */
    public static Indonesian Indonesian(String text) {
        return new Indonesian(text);
    }

    public Indonesian(String text) {
        super(text);
    }

}
