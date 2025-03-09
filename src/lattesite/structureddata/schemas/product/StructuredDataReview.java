package lattesite.structureddata.schemas.product;

import lattesite.structureddata.schemas.StructuredDataSchema;
import lattesite.structureddata.schemas.person.StructuredDataPerson;

/**
 * Represents a Schema.org {@code Review} for a product.
 *
 * <p>The rating scale is fixed at 1 (worst) to 5 (best).</p>
 *
 * @see <a href="https://schema.org/Review">Schema.org/Review</a>
 */
public class StructuredDataReview extends StructuredDataSchema {

    private final StructuredDataPerson author;
    private final String reviewBody;
    private final int ratingValue;
    private final String datePublished;

    /**
     * Creates a review without a JSON-LD {@code @id}.
     *
     * @param author        the person who wrote the review
     * @param reviewBody    the text content of the review
     * @param ratingValue   the rating given (1–5)
     * @param datePublished the date the review was published (ISO 8601)
     */
    public StructuredDataReview(
            StructuredDataPerson author,
            String reviewBody,
            int ratingValue,
            String datePublished
    ) {
        this(
                null,
                author,
                reviewBody,
                ratingValue,
                datePublished
        );
    }

    /**
     * @param id            the JSON-LD {@code @id} for this review; may be {@code null}
     * @param author        the person who wrote the review
     * @param reviewBody    the text content of the review
     * @param ratingValue   the rating given (1–5)
     * @param datePublished the date the review was published (ISO 8601)
     */
    public StructuredDataReview(
            String id,
            StructuredDataPerson author,
            String reviewBody,
            int ratingValue,
            String datePublished
    ) {
        super(id);
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

    public int getWorstRating() {
        return 1;
    }

}
