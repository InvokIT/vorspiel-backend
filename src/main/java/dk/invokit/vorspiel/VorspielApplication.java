package dk.invokit.vorspiel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ResourceLoader;

@SpringBootApplication
public class VorspielApplication {

	public static void main(String[] args) {
		SpringApplication.run(VorspielApplication.class, args);
	}

	@Bean
	public ImageLoader imageLoader(@Autowired ResourceLoader resourceLoader) {
		return new ImageLoader(resourceLoader);
	}
}
