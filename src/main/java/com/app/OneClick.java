package com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Clase principal con el metodo main
 * @author Pablo
 *
 */

@SpringBootApplication
@ComponentScan("com.*")
@EntityScan("com.domain.entity")
@EnableJpaRepositories("com.domain.repository")
@EnableScheduling

public class OneClick extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(OneClick.class, args);
	}

}
