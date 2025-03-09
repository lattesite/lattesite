package lattesite.localization.text;

/** Represents a localized text string in Vietnamese. */
public class Vietnamese extends LocalizedText {

    /**
     * @param text the Vietnamese text
     * @return a new {@link Vietnamese} instance
     */
    public static Vietnamese Vietnamese(String text) {
        return new Vietnamese(text);
    }

    public Vietnamese(String text) {
        super(text);
    }

}
