package dk.invokit.vorspiel.coh2;

import dk.invokit.vorspiel.Faction;
import dk.invokit.vorspiel.Image;

/**
 * Created by sj on 7/5/17.
 */
public class Coh2Faction implements Faction {
    private final String id;
    private final String name;
    private final Image image;
    private final Alliance alliance;

    public Coh2Faction(String id, String name, Image image, Alliance alliance) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.alliance = alliance;
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

    public Alliance getAlliance() {
        return alliance;
    }
}
