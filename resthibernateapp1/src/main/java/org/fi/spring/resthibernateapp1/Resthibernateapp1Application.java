package org.fi.spring.resthibernateapp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages= {"org.fi.spring.resthibernateapp1.controllers"})
@EntityScan(basePackages= {"org.fi.spring.resthibernateapp1.entity"})
@EnableJpaRepositories(basePackages= {"org.fi.spring.resthibernateapp1.repositories"})
public class Resthibernateapp1Application {

	public static void main(String[] args) {
		SpringApplication.run(Resthibernateapp1Application.class, args);
	}

}
