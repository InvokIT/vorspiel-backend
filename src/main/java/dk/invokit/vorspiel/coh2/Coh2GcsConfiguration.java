package dk.invokit.vorspiel.coh2;

import dk.invokit.vorspiel.Image;
import dk.invokit.vorspiel.ImageLoader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.io.IOException;

/**
 * Created by sj on 7/3/17.
 */
@Configuration
@Profile("coh2:gcs")
public class Coh2GcsConfiguration {
    @Autowired
    private ImageLoader imageLoader;

    @Bean()
    public Coh2Ruleset coh2GcsRuleset() throws IOException {
        final Image image = imageLoader.loadImage("coh2/gcs/logo.png");

        return new Coh2Ruleset() {
            @Override
            public String getId() {
                return "coh2-gcs-ruleset";
            }

            @Override
            public String getName() {
                return "Grand Championship Series";
            }

            @Override
            public Image getImage() {
                return image;
            }

            @Override
            public int getTeamSize() {
                return 1;
            }
        };
    }

}
