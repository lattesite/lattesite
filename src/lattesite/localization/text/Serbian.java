package lattesite.localization.text;

/** Represents a localized text string in Serbian. */
public class Serbian extends LocalizedText {

    /**
     * @param text the Serbian text
     * @return a new {@link Serbian} instance
     */
    public static Serbian Serbian(String text) {
        return new Serbian(text);
    }

    public Serbian(String text) {
        super(text);
    }

}
