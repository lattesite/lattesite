package lattesite.structured.data.schemas;

import lattesite.structured.data.enumeration.GenderType;

public class StructuredDataPerson {

    private final String name;
    private GenderType gender;
    private String jobTitle;
    private String knowsAbout;
    private String[] sameAs;
    private String url;
    private String description;
    private String image;
    private String givenName;
    private String familyName;
    private final String knowsLanguage;

    public StructuredDataPerson(
            String name
    ) {
        this.name = name;
        this.gender = null;
        this.jobTitle = "";
        this.knowsAbout = "";
        this.sameAs = new String[]{};
        this.url = "";
        this.description = "";
        this.image = "";
        this.givenName = null;
        this.familyName = null;
        this.knowsLanguage = null;
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

    public void setSameAs(String[] sameAs) {
        this.sameAs = sameAs;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setURL(String url) {
        this.url = url;
    }

    public String[] getSameAs() {
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

}
