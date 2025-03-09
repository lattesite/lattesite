package lattesite.structureddata.schemas.action;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.person.StructuredDataPerson;
import lattesite.structureddata.schemas.thing.StructuredDataThing;

/**
 * Represents a Schema.org {@code DonateAction} — an action of donating to a cause or recipient.
 *
 * <p>Optional agent and recipient persons can be set after construction.</p>
 *
 * @see <a href="https://schema.org/DonateAction">Schema.org/DonateAction</a>
 */
public class StructuredDataDonateAction extends StructuredDataSchema {

    private final String name;
    private final String description;
    private final String target;
    private final StructuredDataThing object;
    private StructuredDataPerson recipientPerson;
    private StructuredDataPerson agentPerson;

    /**
     * @param id          the JSON-LD {@code @id} for this action
     * @param name        the name of the donation action
     * @param description a description of the donation action
     * @param target      the URL target of the action (e.g. a donation page)
     * @param object      the thing being donated
     */
    public StructuredDataDonateAction(
            String id,
            String name,
            String description,
            String target,
            StructuredDataThing object
    ) {
        super(id);
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
        return this.target;
    }

    public StructuredDataThing getObject() {
        return this.object;
    }
}
