package lattesite.structureddata.schemas.breadcrumbs;

import lattesite.structureddata.schemas.StructuredDataSchema;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a Schema.org {@code BreadcrumbList} — an ordered list of breadcrumb navigation steps.
 *
 * <p>Add steps via {@link #addBreadcrumbs(List)}. Positions in the JSON-LD output are assigned
 * automatically (1-based) based on the order in which items were added.</p>
 *
 * @see <a href="https://schema.org/BreadcrumbList">Schema.org/BreadcrumbList</a>
 */
public class StructuredDataBreadcrumbList extends StructuredDataSchema {

    private final ArrayList<StructuredDataBreadcrumb> crumbs;

    /**
     * @param id the JSON-LD {@code @id} for this breadcrumb list
     */
    public StructuredDataBreadcrumbList(
            String id
    ) {
        super(id);
        this.crumbs = new ArrayList<>();
    }

    @Override
    public String getType() {
        return "BreadcrumbList";
    }

    public ArrayList<StructuredDataBreadcrumb> getBreadcrumbs() {
        return this.crumbs;
    }

    public void addBreadcrumbs(List<StructuredDataBreadcrumb> breadcrumbs) {
        this.crumbs.addAll(breadcrumbs);
    }

}
