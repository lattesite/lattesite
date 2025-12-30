package lattesite.structured.data.enumeration;

// https://unstats.un.org/unsd/publication/seriesm/seriesm_4rev4e.pdf
public enum IsicV4Category {

    // Division 10 Manufacture of food products
    CLASS_1079("Manufacture of other food products n.e.c", 1079),
    // Division 26 Manufacture of computer, electronic and optical products
    CLASS_2620("Manufacture of computers and peripheral equipment", 2620),
    // Division 46 Wholesale trade, except of motor vehicles and motorcycles
    CLASS_4630("Wholesale of food, beverages and tobacco", 4630),
    // Division 47 Retail trade, except of motor vehicles and motorcycles
    CLASS_4771("Retail sale of clothing, footwear and leather articles in specialized stores", 4771),
    CLASS_4791("Retail sale via mail order houses or via Internet", 4791),

    // Division 58 Publishing activities
    CLASS_5812("Publishing of directories and mailing lists", 5812),

    // Division 62 Computer programming, consultancy and related activities,
    CLASS_6202("Computer consultancy and computer facilities management activities", 6202),
    CLASS_6209("Other information technology and computer service activities", 6209),
    // Division 63 Information service activities
    CLASS_6311("Data processing, hosting and related activities", 6311),
    CLASS_6312("Web portals", 6312),
    CLASS_6399("Other information service activities n.e.c.", 6399),
    // Division 73 Advertising and market research
    CLASS_7310("Advertising", 7310),
    // Division 74 Other professional, scientific and technical activities
    CLASS_7420("Photographic activities", 7420),
    // Division 93 Sports activities and amusement and recreation activities
    CLASS_9329("Other amusement and recreation activities n.e.c.", 9329),

    /*
     * Section Q - Human health and social work activities
     */
    // Division 86 Human health activities
    CLASS_8610("Hospital activities", 8610),
    CLASS_8620("Medical and dental practice activities", 8620),

    /*
     * Section R - Arts, entertainment and recreation
     */
    // Division 90 Creative, arts and entertainment activities
    CLASS_9000("Creative, arts and entertainment activities", 9000);

    private final String description;
    private final int id;

    IsicV4Category(String description, int id) {
        this.description = description;
        this.id = id;
    }

    @Override
    public String toString() {
        return this.description + " (" + this.id + ")";
    }

    public String getDescription() {
        return this.description;
    }

    public String getID() {
        return Integer.toString(this.id);
    }

}
