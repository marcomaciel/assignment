package com.myco.assignment;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 *
 * @author Marco Maciel
 */
@SpringBootApplication
public class AssignmentApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AssignmentApplication.class);
    }

	public static void main(String[] args) {
		SpringApplication.run(AssignmentApplication.class, args);
	}
}
