package com.microservice.discovery;

import org.springframework.boot.SpringApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class DiscoveryMicroserviceServerApplication {

	private static final Logger logger = LoggerFactory
			.getLogger(DiscoveryMicroserviceServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(DiscoveryMicroserviceServerApplication.class,
				args);
		logger.info("Eureka server started on port : 1111");
	}
}
