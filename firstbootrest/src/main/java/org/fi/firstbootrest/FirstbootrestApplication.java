package org.fi.firstbootrest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.fi.firstbootrest.controllers"})
public class FirstbootrestApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstbootrestApplication.class, args);
	}

}
