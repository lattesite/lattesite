package lattesite.structured.data.schemas;

public class StructuredDataProfilePage {

    private final StructuredDataPerson person;

    public StructuredDataProfilePage(
            StructuredDataPerson person
    ) {
        this.person = person;
    }

    public StructuredDataPerson getPerson() {
        return this.person;
    }

}
