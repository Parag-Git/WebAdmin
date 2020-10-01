package com.lti.authorization1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.lti.authorization1.Repository.UserRepository;


@EnableEurekaClient
@SpringBootApplication
@EnableJpaRepositories(basePackageClasses = UserRepository.class)
public class Authorization1Application {

	public static void main(String[] args) {
		SpringApplication.run(Authorization1Application.class, args);
	}

}
