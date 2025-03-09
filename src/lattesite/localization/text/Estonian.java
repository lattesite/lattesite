package lattesite.localization.text;

/** Represents a localized text string in Estonian. */
public class Estonian extends LocalizedText {

    /**
     * @param text the Estonian text
     * @return a new {@link Estonian} instance
     */
    public static Estonian Estonian(String text) {
        return new Estonian(text);
    }

    public Estonian(String text) {
        super(text);
    }

}
