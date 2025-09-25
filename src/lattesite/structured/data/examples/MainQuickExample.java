package lattesite.structured.data.examples;

import lattesite.services.LogService;
import lattesite.structured.data.enumeration.GenderType;
import lattesite.structured.data.schemas.StructuredDataPerson;
import lattesite.structured.data.services.StructuredDataService;

public class MainQuickExample {

    public static void main(String[] args) throws Exception {

        // Initiate the service
        LogService logService = new LogService();
        StructuredDataService structuredDataService = new StructuredDataService(logService);

        // Create a new Person Structured Data
        String name = "Homer Jay Simpson";
        String description = "Homer Jay Simpson is the main protagonist of the American animated television series The Simpsons and patriarch of the titular Simpson family.";
        String image = "https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png";
        GenderType gender = GenderType.MALE;
        String url = "https://en.wikipedia.org/wiki/Homer_Simpson";
        String jobTitle = "Safety inspector at Springfield Nuclear Power Plant";
        String knowsAbout = "Donuts";
        String[] sameAs = new String[]{"https://x.com/homerjsimpson"};
//        String givenName = "Homer Jay";
//        String familyName = "Simpson";

        StructuredDataPerson person = new StructuredDataPerson(
                name
        );
        person.setDescription(description);
        person.setImage(image);
        person.setURL(url);
        person.setJobTitle(jobTitle);
        person.setKnowsAbout(knowsAbout);
        person.setGender(gender);
        person.setSameAs(sameAs);

        // Generate
        String json = structuredDataService.toJSON(person);

        System.out.println(json);

        /*

            {
                "@context": "https://schema.org/",
                "@type": "Person",
                "url": "https://en.wikipedia.org/wiki/Homer_Simpson",
                "image": "https://upload.wikimedia.org/wikipedia/en/0/02/Homer_Simpson_2006.png",
                "description": "Homer Jay Simpson is the main protagonist of the American animated television series The Simpsons and patriarch of the titular Simpson family.",
                "sameAs": [
                    "https://x.com/homerjsimpson"
                ],
                "knowsAbout": "Donuts",
                "jobTitle": "Safety inspector at Springfield Nuclear Power Plant",
                "gender": "https://schema.org/Male",
                "givenName": "Homer Jay",
                "familyName": "Simpson",
                "name": "Steve"
            }

         */

    }

}