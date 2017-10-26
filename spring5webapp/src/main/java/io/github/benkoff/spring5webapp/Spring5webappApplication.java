package io.github.benkoff.spring5webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	Test database access @ http://localhost:8080/h2-console/
	JDBC URL: jdbc:h2:mem:testdb
 */

@SpringBootApplication
public class Spring5webappApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring5webappApplication.class, args);
	}
}
