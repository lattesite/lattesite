package lattesite.structured.data.schemas;

public class StructuredDataContactPoint implements StructuredDataSchema {

    private final String contactType;
    private String email;

    public StructuredDataContactPoint(
            String contactType
    ) {
        this.contactType = contactType;
        this.email = null;
    }

    @Override
    public String getType() {
        return "ContactPoint";
    }

    public String getContactType() {
        return contactType;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
