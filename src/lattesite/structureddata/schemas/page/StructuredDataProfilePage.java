package lattesite.structureddata.schemas.page;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.person.StructuredDataPerson;

/**
 * Represents a Schema.org {@code ProfilePage} — a page whose main content is a person.
 *
 * @see <a href="https://schema.org/ProfilePage">Schema.org/ProfilePage</a>
 */
public class StructuredDataProfilePage extends StructuredDataSchema {

    private final StructuredDataPerson person;

    /**
     * @param id     the JSON-LD {@code @id} for this page
     * @param person the person featured on this profile page
     */
    public StructuredDataProfilePage(
            String id,
            StructuredDataPerson person
    ) {
        super(id);
        this.person = person;
    }

    @Override
    public String getType() {
        return "ProfilePage";
    }

    public StructuredDataPerson getPerson() {
        return this.person;
    }

}
