package lattesite.structureddata.schemas.article;

import lattesite.structureddata.schemas.audience.StructuredDataPeopleAudience;

/**
 * Represents a Schema.org {@code TechArticle} — a technical or how-to article.
 *
 * @see <a href="https://schema.org/TechArticle">Schema.org/TechArticle</a>
 */
public class StructuredDataTechArticle extends StructuredDataArticle {

    public StructuredDataTechArticle(
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
        return "TechArticle";
    }

}
