package lattesite.structureddata.enumeration;

/**
 * Suggested gender values for use with {@code PeopleAudience} structured data.
 *
 * @see <a href="https://schema.org/suggestedGender">Schema.org/suggestedGender</a>
 */
public enum SuggestedGender {

    /**
     * Female audience.
     */
    FEMALE("female"),
    /**
     * Male audience.
     */
    MALE("male"),
    /**
     * Unisex / all genders.
     */
    UNISEX("unisex");

    private final String value;

    SuggestedGender(String value) {
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
