package lattesite.localization.text;

public abstract class LocalizedText {

    private final String text;

    public LocalizedText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }

}
