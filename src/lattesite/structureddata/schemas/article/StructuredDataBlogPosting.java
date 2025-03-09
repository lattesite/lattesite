package lattesite.structureddata.schemas.article;

import lattesite.structureddata.schemas.audience.StructuredDataPeopleAudience;

/**
 * Represents a Schema.org {@code BlogPosting} — a blog post article.
 *
 * @see <a href="https://schema.org/BlogPosting">Schema.org/BlogPosting</a>
 */
public class StructuredDataBlogPosting extends StructuredDataArticle {

    public StructuredDataBlogPosting(
            String id,
            String inLanguage,
            String headline,
            String articleSection,
            String articleBody,
            String image,
            String description,
            String dateModified,
            String datePublished,
            String url,
            StructuredDataPeopleAudience audience
    ) {
        super(
                id,
                inLanguage,
                headline,
                articleSection,
                articleBody,
                image,
                description,
                dateModified,
                datePublished,
                url,
                audience
        );
    }

    @Override
    final public String getType() {
        return "BlogPosting";
    }

}
