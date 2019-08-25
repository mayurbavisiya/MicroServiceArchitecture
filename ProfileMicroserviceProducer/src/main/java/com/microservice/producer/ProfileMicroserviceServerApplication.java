package com.microservice.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProfileMicroserviceServerApplication implements CommandLineRunner {

	private static final Logger logger = LoggerFactory
			.getLogger(ProfileMicroserviceServerApplication.class);

	@Autowired
	private ProfileRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(ProfileMicroserviceServerApplication.class, args);
		logger.info("Profile Miroservice Producer started");
	}

	@Override
	public void run(String... args) {

		repository.findAll().forEach(x -> System.out.println(x.getName()));

	}
}