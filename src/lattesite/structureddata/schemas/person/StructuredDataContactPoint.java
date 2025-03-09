package lattesite.structureddata.schemas.person;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code ContactPoint}.
 *
 * <p>An optional email address can be set via {@link #setEmail(String)}.</p>
 *
 * @see <a href="https://schema.org/ContactPoint">Schema.org/ContactPoint</a>
 */
public class StructuredDataContactPoint extends StructuredDataSchema {

    private final String contactType;
    private String email;

    /**
     * @param id          the JSON-LD {@code @id} for this contact point
     * @param contactType the type of contact (e.g. {@code "customer service"})
     */
    public StructuredDataContactPoint(
            String id,
            String contactType
    ) {
        super(id);
        this.contactType = contactType;
        this.email = null;
    }

    @Override
    public String getType() {
        return "ContactPoint";
    }

    public String getContactType() {
        return this.contactType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }
}
