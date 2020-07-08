package bencyle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class BencyleApplication extends SpringBootServletInitializer {

	@Override
	public SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(BencyleApplication.class);
	}
	public	 static void main(String[] args) {
		SpringApplication.run(BencyleApplication.class, args);
	}

}
