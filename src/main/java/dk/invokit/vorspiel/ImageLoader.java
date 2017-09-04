package dk.invokit.vorspiel;

import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by sj on 7/5/17.
 */
public class ImageLoader {
    private static Map<String, String> defaultMimeTypes;

    {
        defaultMimeTypes = new TreeMap<>();
        defaultMimeTypes.put("jpg", "image/jpeg");
        defaultMimeTypes.put("png", "image/png");
        defaultMimeTypes.put("jpeg", "image/jpeg");
    }

    private ResourceLoader resourceLoader;
    private Map<String, String> extensionToMimeTypes = defaultMimeTypes;

    public ImageLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public Image loadImage(String path) throws IOException {
        final Resource resource = this.resourceLoader.getResource(path);
        final String ext = path.substring(path.lastIndexOf('.') + 1);

        final byte[] bytes = StreamUtils.copyToByteArray(resource.getInputStream());
        final String mimeType = this.extensionToMimeTypes.get(ext);

        return new Image(path, bytes, mimeType);
    }
}
