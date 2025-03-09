package lattesite.structureddata.schemas.breadcrumbs;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a single step in a Schema.org {@code BreadcrumbList} — serialized as a {@code ListItem}.
 *
 * <p>Position is assigned automatically by {@link StructuredDataBreadcrumbList} based on insertion order.</p>
 *
 * @see <a href="https://schema.org/BreadcrumbList">Schema.org/BreadcrumbList</a>
 */
public class StructuredDataBreadcrumb extends StructuredDataSchema {

    private final String name;
    private final String item;

    /**
     * Creates a breadcrumb without a JSON-LD {@code @id}.
     *
     * @param name the display name of this breadcrumb step
     * @param item the URL this breadcrumb step links to
     */
    public StructuredDataBreadcrumb(
            String name,
            String item
    ) {
        this(null, name, item);
    }

    /**
     * @param id   the JSON-LD {@code @id} for this breadcrumb; may be {@code null}
     * @param name the display name of this breadcrumb step
     * @param item the URL this breadcrumb step links to
     */
    public StructuredDataBreadcrumb(
            String id,
            String name,
            String item
    ) {
        super(id);
        this.name = name;
        this.item = item;
    }

    @Override
    public String getType() {
        return "ListItem";
    }

    public String getName() {
        return this.name;
    }

    public String getItem() {
        return this.item;
    }

}
