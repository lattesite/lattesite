package lattesite.structured.data.schemas;

public class StructuredDataReview implements StructuredDataSchema {

    private final StructuredDataPerson author;
    private final String reviewBody;
    private final int ratingValue;
    private final String datePublished;

    public StructuredDataReview(
            StructuredDataPerson author,
            String reviewBody,
            int ratingValue,
            String datePublished
    ) {
        this.author = author;
        this.reviewBody = reviewBody;
        this.ratingValue = ratingValue;
        this.datePublished = datePublished;
    }

    @Override
    public String getType() {
        return "Review";
    }

    public int getRatingValue() {
        return this.ratingValue;
    }

    public StructuredDataPerson getAuthor() {
        return this.author;
    }

    public String getDatePublished() {
        return this.datePublished;
    }

    public String getReviewBody() {
        return this.reviewBody;
    }

    public int getBestRating() {
        return 5;
    }

    public int getWorseRating() {
        return 1;
    }

}
