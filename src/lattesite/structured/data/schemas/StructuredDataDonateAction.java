package lattesite.structured.data.schemas;

public class StructuredDataDonateAction implements StructuredDataSchema {

    private final String name;
    private final String description;
    private final String target;
    private final StructuredDataThing object;
    private StructuredDataPerson recipientPerson;
    private StructuredDataPerson agentPerson;

    public StructuredDataDonateAction(
            String name,
            String description,
            String target,
            StructuredDataThing object
    ) {
        this.name = name;
        this.description = description;
        this.target = target;
        this.object = object;
        this.recipientPerson = null;
        this.agentPerson = null;
    }

    @Override
    public String getType() {
        return "DonateAction";
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public StructuredDataPerson getRecipientPerson() {
        return this.recipientPerson;
    }

    public void setRecipientPerson(StructuredDataPerson recipientPerson) {
        this.recipientPerson = recipientPerson;
    }

    public StructuredDataPerson getAgentPerson() {
        return this.agentPerson;
    }

    public void setAgentPerson(StructuredDataPerson agentPerson) {
        this.agentPerson = agentPerson;
    }

    public String getTarget() {
        return target;
    }

    public StructuredDataThing getObject() {
        return object;
    }
}
