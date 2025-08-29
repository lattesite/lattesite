package lattesite.html.elements;

public class HTMLAnchorElement extends HTMLElement {

    public HTMLAnchorElement(
            HTMLElement parent,
            String href,
            String title
    ) {
        this(parent, href, title, null);
    }

    public HTMLAnchorElement(
            HTMLElement parent,
            String href,
            String title,
            String text
    ) {
        super(parent, "a", false);
        this.setHref(href);
        this.setTitle(title);
        if (text != null) {
            this.setText(text);
        }
    }

    public void setHref(String href) {
        this.setAttribute("href", href);
    }

    public void setRelationship(Relationship... rels) {
        String value = "";
        for (Relationship rel : rels) {
            value += rel.getValue() + " ";
        }
        value = value.trim();
        super.setAttribute("rel", value);
    }

    public void setTarget(Target target) {
        super.setAttribute("target", target.getValue());
    }

    public enum Relationship {
        NO_FOLLOW("nofollow");

        private final String value;

        Relationship(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }

    }

    public enum Target {
        BLANK("_blank");

        private final String value;

        Target(String value) {
            this.value = value;
        }

        public String getValue() {
            return this.value;
        }
    }

}
