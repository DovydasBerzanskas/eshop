package lt.codeacademy.eshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EshopApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(EshopApplication.class);
		app.setAdditionalProfiles("something");
		app.run(args);
	}

}
