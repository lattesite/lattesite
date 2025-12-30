package lattesite.structured.data.schemas;

public class StructuredDataArticleBlogPosting extends StructuredDataArticle {

    public StructuredDataArticleBlogPosting(
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
                "BlogPosting",
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
