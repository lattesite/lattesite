package lattesite.localization.text;

/** Represents a localized text string in Hungarian. */
public class Hungarian extends LocalizedText {

    /**
     * @param text the Hungarian text
     * @return a new {@link Hungarian} instance
     */
    public static Hungarian Hungarian(String text) {
        return new Hungarian(text);
    }

    public Hungarian(String text) {
        super(text);
    }

}
