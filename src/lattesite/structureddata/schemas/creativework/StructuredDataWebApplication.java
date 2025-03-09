package lattesite.structureddata.schemas.creativework;

/**
 * Represents a Schema.org {@code WebApplication} — a software application delivered via the web.
 *
 * <p>The operating system is automatically set to {@code "Web"}.</p>
 *
 * @see <a href="https://schema.org/WebApplication">Schema.org/WebApplication</a>
 */
public class StructuredDataWebApplication extends StructuredDataSoftwareApplication {

    /**
     * @param id                  the JSON-LD {@code @id} for this web application
     * @param name                the application name
     * @param description         a short description of the application
     * @param url                 the canonical URL of the application
     * @param applicationCategory the Schema.org application category (e.g. {@code "GameApplication"})
     */
    public StructuredDataWebApplication(
            String id,
            String name,
            String description,
            String url,
            String applicationCategory
    ) {
        super(
                id,
                name,
                description,
                url,
                "Web",
                applicationCategory
        );
    }

    @Override
    final public String getType() {
        return "WebApplication";
    }

}
