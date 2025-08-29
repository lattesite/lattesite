package lattesite.structured.data.enumeration;

public enum GenderType {

    FEMALE("female"),
    MALE("male"),
    UNISEX("unisex");

    private final String value;

    GenderType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return this.value;
    }

    public String getValue() {
        return this.value;
    }

}
