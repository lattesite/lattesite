package lattesite.googlemerchant.enumerations;

/**
 * A subset of Google's product category taxonomy.
 * Extend this enum or consult the full taxonomy for additional categories.
 *
 * @see <a href="https://www.google.com/basepages/producttype/taxonomy-with-ids.en-US.txt">Full taxonomy</a>
 */
public enum ProductCategory {

    FOOD_COFFEE("Food, Beverages & Tobacco > Beverages > Coffee", 1868),
    MOUSE_PADS("Electronics > Electronics Accessories > Computer Accessories > Mouse Pads", 1993),
    KEYBOARD_MOUSE_WRIST_RESTS("Electronics > Electronics Accessories > Computer Accessories > Keyboard & Mouse Wrist Rests", 6291),
    DRESSES("Apparel & Accessories > Clothing > Dresses", 2271),
    SHOES("Apparel & Accessories > Shoes", 187);

    private final String tree;
    private final int id;

    ProductCategory(String tree, int id) {
        this.tree = tree;
        this.id = id;
    }

    /**
     * @return the human-readable category path
     */
    public String getTree() {
        return this.tree;
    }

    /**
     * @return the numeric category ID used in the feed
     */
    public int getID() {
        return this.id;
    }

}
