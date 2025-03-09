package lattesite.localization.text;

/**
 * Base class for all strongly-typed localized text strings.
 * <p>
 * Each supported language has its own subclass (e.g. {@link English}, {@link Swedish}),
 * enabling compile-time type safety when passing translations to methods that accept
 * specific language types.
 */
public abstract class LocalizedText {

    private final String text;

    /**
     * @param text the localized text string
     */
    public LocalizedText(String text) {
        this.text = text;
    }

    /**
     * @return the localized text string
     */
    @Override
    public String toString() {
        return text;
    }

}
