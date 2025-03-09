package lattesite.localization.text;

/** Represents a localized text string in Korean. */
public class Korean extends LocalizedText {

    /**
     * @param text the Korean text
     * @return a new {@link Korean} instance
     */
    public static Korean Korean(String text) {
        return new Korean(text);
    }

    public Korean(String text) {
        super(text);
    }

}
