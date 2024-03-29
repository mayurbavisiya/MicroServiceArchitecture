package com.microservice.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * @author Administrator
 *
 */
@SpringBootApplication
@EnableDiscoveryClient
public class ProfileMicroserviceClientApplication {
	
	private static final Logger logger = LoggerFactory.getLogger(ProfileMicroserviceClientApplication.class);

	public static final String PROFILES_SERVICE_URL = "http://PROFILES-MICROSERVICE-PRODUCER";

	
	public static void main(String[] args) {
		SpringApplication.run(ProfileMicroserviceClientApplication.class, args);
		logger.info("Profile Miroservice Consumer started");
	}

	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	public ProfileRepository profileRepository() {
		return new RemoteProfileRepository(PROFILES_SERVICE_URL);
	}
}