package lattesite.html.elements.attributes;

// https://dequeuniversity.com/rules/axe/4.11/landmark-one-main
public enum Role {

    // https://developer.mozilla.org/en-US/docs/Web/Accessibility/ARIA/Reference/Roles#3._landmark_roles
    BANNER("banner"),
    COMPLEMENTARY("complementary"),
    CONTENTINFO("contentinfo"),
    FORM("form"),
    MAIN("main"),
    NAVIGATION("navigation"),
    REGION("region"),
    SEARCH("search");

    private final String value;

    Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}
