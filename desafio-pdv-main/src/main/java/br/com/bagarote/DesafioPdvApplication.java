package br.com.bagarote;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class DesafioPdvApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioPdvApplication.class, args);
	}
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*", "http://localhost:8280", "http://localhost:8080", "http://localhost:80",
								"https://etotem.com.br")
						.allowedMethods("GET", "POST", "OPTIONS", "PUT", "DELETE", "PATCH", "TRACE", "CONNECT")
						.allowedHeaders("Authorization", "Cache-Control", "Content-Type", "Content-Disposition","Access-Control-Expose-Headers", "X-Requested-With","X-Forwarded-For", "Proxy-Client-IP", "WL-Proxy-Client-IP", "idSessao")
						.exposedHeaders("Content-Disposition");
			}
		};
	}

}
