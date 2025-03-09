package lattesite.structureddata.schemas.media;

import lattesite.structureddata.schemas.StructuredDataSchema;

/**
 * Represents a Schema.org {@code ImageObject} — an image resource identified by a URL.
 *
 * @see <a href="https://schema.org/ImageObject">Schema.org/ImageObject</a>
 */
public class StructuredDataImageObject extends StructuredDataSchema {

    private final String url;

    /**
     * @param id  the JSON-LD {@code @id} for this image object
     * @param url the absolute URL of the image
     */
    public StructuredDataImageObject(
            String id,
            String url
    ) {
        super(id);
        this.url = url;
    }

    @Override
    public String getType() {
        return "ImageObject";
    }

    public String getURL() {
        return this.url;
    }

}
