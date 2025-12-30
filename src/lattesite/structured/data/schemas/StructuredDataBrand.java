package lattesite.structured.data.schemas;

public class StructuredDataBrand {

    private final String name;
    private String logo;

    public StructuredDataBrand(
            String name
    ) {
        this.name = name;
        this.logo = null;
    }

    public String getName() {
        return this.name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

}
