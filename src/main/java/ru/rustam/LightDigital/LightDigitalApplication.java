package ru.rustam.LightDigital;

import com.google.gson.Gson;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LightDigitalApplication {

	public static void main(String[] args) {
		SpringApplication.run(LightDigitalApplication.class, args);
	}

	@Bean
	public Gson gsonMapper() {
		return new Gson();
	}

}
