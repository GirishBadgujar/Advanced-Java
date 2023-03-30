package org.fi.springbootmvc1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"org.fi.springbootmvc1.controllers"})
public class Springbootmvc1Application {

	public static void main(String[] args) {
		SpringApplication.run(Springbootmvc1Application.class, args);
	}

}
