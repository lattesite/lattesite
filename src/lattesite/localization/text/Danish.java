package lattesite.localization.text;

/** Represents a localized text string in Danish. */
public class Danish extends LocalizedText {

    /**
     * @param text the Danish text
     * @return a new {@link Danish} instance
     */
    public static Danish Danish(String text) {
        return new Danish(text);
    }

    public Danish(String text) {
        super(text);
    }

}
