package lattesite.structured.data.schemas;

public class StructuredDataArticleTech extends StructuredDataArticle {

    public StructuredDataArticleTech(
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
                "TechArticle",
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

}
