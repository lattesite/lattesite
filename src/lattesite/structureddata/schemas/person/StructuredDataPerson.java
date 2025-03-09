package lattesite.structureddata.schemas.person;

import lattesite.structureddata.enumeration.GenderType;
import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.brand.StructuredDataBrand;
import lattesite.structureddata.schemas.geo.StructuredDataCountry;

import java.util.Collections;
import java.util.List;

/**
 * Represents a Schema.org {@code Person}.
 *
 * <p>Only name and ID are required. All other properties — gender, job title, social profile
 * links, URL, description, image, name parts, language, education, nationality, contact point,
 * and brand — are optional and can be set after construction.</p>
 *
 * @see <a href="https://schema.org/Person">Schema.org/Person</a>
 */
public class StructuredDataPerson extends StructuredDataSchema {

    private final String name;
    private GenderType gender;
    private String jobTitle;
    private String knowsAbout;
    private List<String> sameAs;
    private String url;
    private String description;
    private String image;
    private String givenName;
    private String familyName;
    private String knowsLanguage;
    private String education;
    private StructuredDataCountry nationality;
    private StructuredDataContactPoint contactPoint;
    private StructuredDataBrand brand;

    /**
     * @param id   the JSON-LD {@code @id} for this person (typically a profile page URL)
     * @param name the full name of the person
     */
    public StructuredDataPerson(
            String id,
            String name
    ) {
        super(id);
        this.name = name;
        this.gender = null;
        this.jobTitle = "";
        this.knowsAbout = "";
        this.sameAs = Collections.emptyList();
        this.url = "";
        this.description = "";
        this.image = "";
        this.givenName = null;
        this.familyName = null;
        this.knowsLanguage = null;
        this.education = null;
        this.nationality = null;
        this.contactPoint = null;
        this.brand = null;
    }

    @Override
    public String getType() {
        return "Person";
    }

    public void setKnowsLanguage(String knowsLanguage) {
        this.knowsLanguage = knowsLanguage;
    }

    public void setNationality(StructuredDataCountry nationality) {
        this.nationality = nationality;
    }

    public void setContactPoint(StructuredDataContactPoint contactPoint) {
        this.contactPoint = contactPoint;
    }

    public StructuredDataContactPoint getContactPoint() {
        return this.contactPoint;
    }

    public String getURL() {
        return this.url;
    }

    public String getImage() {
        return this.image;
    }

    public String getDescription() {
        return this.description;
    }

    public String getKnowsLanguage() {
        return this.knowsLanguage;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public void setKnowsAbout(String knowsAbout) {
        this.knowsAbout = knowsAbout;
    }

    public void setSameAs(List<String> sameAs) {
        this.sameAs = sameAs;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public List<String> getSameAs() {
        return this.sameAs;
    }

    public String getKnowsAbout() {
        return this.knowsAbout;
    }

    public String getJobTitle() {
        return this.jobTitle;
    }

    public GenderType getGender() {
        return this.gender;
    }

    public String getGivenName() {
        return this.givenName;
    }

    public String getFamilyName() {
        return this.familyName;
    }

    public String getName() {
        return this.name;
    }

    public void setGivenName(String givenName) {
        this.givenName = givenName;
    }

    public void setFamilyName(String familyName) {
        this.familyName = familyName;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getEducation() {
        return this.education;
    }

    public StructuredDataCountry getNationality() {
        return this.nationality;
    }

    public StructuredDataBrand getBrand() {
        return this.brand;
    }

    public void setBrand(StructuredDataBrand brand) {
        this.brand = brand;
    }

}
