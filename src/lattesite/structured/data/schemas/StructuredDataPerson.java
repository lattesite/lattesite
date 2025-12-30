package lattesite.structured.data.schemas;

import lattesite.structured.data.enumeration.GenderType;

import java.util.Collections;
import java.util.List;

public class StructuredDataPerson {

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

    public StructuredDataPerson(
            String name
    ) {
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
        return brand;
    }

    public void setBrand(StructuredDataBrand brand) {
        this.brand = brand;
    }
}
