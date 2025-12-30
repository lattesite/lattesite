package lattesite.html.elements;

public class HTMLIFrameElement extends HTMLElement {

    public HTMLIFrameElement(
            HTMLElement parent,
            String title,
            String src
    ) {
        super(parent, "iframe", false);
        this.setAttribute("title", title);
        this.setAttribute("src", src);
    }

    public void setAllowFullscreen(boolean allowFullscreen) {
        this.setAttribute("allowfullscreen", allowFullscreen);
    }

    public void setAllowTransparency(boolean allowTransparency) {
        this.setAttribute("allowtransparency", allowTransparency);
    }

    public void setFrameBorder(int frameBorder) {
        this.setAttribute("frameborder", frameBorder);
    }

    public void setAllow(String allow) {
        this.setAttribute("allow", allow);
    }

    public void setLoading(HTMLImageElement.Loading loading) {
        this.setAttribute("loading", loading.toString());
    }

    public enum Loading {
        LAZY("lazy"),
        EAGER("eager");

        private final String value;

        Loading(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }
    }

}
