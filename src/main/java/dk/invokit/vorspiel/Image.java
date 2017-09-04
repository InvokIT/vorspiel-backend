package dk.invokit.vorspiel;

/**
 * Created by sj on 7/5/17.
 */
public class Image {
    private String name;
    private byte[] bytes;
    private String mimeType;

    public Image(String name, byte[] bytes, String mimeType) {
        this.name = name;
        this.bytes = bytes;
        this.mimeType = mimeType;
    }

    public String getName() {
        return name;
    }

    public byte[] getBytes() {
        return bytes;
    }

    public String getMimeType() {
        return mimeType;
    }
}
