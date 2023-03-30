package gana.basic.springbootapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication(scanBasePackages = {"org.fi.spring.resthibernateapp.controllers"})
@EntityScan(basePackages = {"org.fi.spring.resthibernateapp.entity"})
public class ResthibernateappApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResthibernateappApplication.class, args);
	}

}
