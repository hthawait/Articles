package io.springboot.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "io.springboot")
@EnableJpaRepositories(basePackages = "io.springboot.dal")
@EntityScan(basePackages = "io.springboot.models")
public class MainApiApp {

	public static void main(String[] args) {
		
		SpringApplication.run(MainApiApp.class, args);

	}

}
