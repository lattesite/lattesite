package lattesite.localization.text;

/** Represents a localized text string in Chinese. */
public class Chinese extends LocalizedText {

    /**
     * @param text the Chinese text
     * @return a new {@link Chinese} instance
     */
    public static Chinese Chinese(String text) {
        return new Chinese(text);
    }

    public Chinese(String text) {
        super(text);
    }

}
