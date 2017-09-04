package dk.invokit.vorspiel;

/**
 * Created by sj on 7/3/17.
 */
public abstract class ScenarioImpl implements Scenario {
    private final String id;
    private final String name;
    private final Image image;

    public ScenarioImpl(String id, String name, Image image) {
        this.id = id;
        this.name = name;
        this.image = image;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Image getImage() {
        return image;
    }

}
