package co.edu.umb.guide2be;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Guide2BeApplication {

	public static void main(String[] args) {
		SpringApplication.run(Guide2BeApplication.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
					.allowedOrigins("*")
					.allowedHeaders("*")
					.allowedMethods("*")
					.exposedHeaders("*")
					.allowedOriginPatterns("*");
			}
		};
	}

}
