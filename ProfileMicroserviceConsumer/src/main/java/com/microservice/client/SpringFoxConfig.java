package com.microservice.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author Administrator
 *
 */
@Configuration
@EnableSwagger2
public class SpringFoxConfig {
	@Bean
	public Docket apiDocket() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.any())
				.paths(PathSelectors.ant("/api/**")).build();
	}

	private ApiInfo apiInfo() {
		ApiInfo apiInfo = new ApiInfo("Rest API", "Rest API Example", "1", "",
				new Contact("Mayur", "https://github.com/mayurbavisiya/",
						"mayur.bavisiya@gmail.com"), "Apache License", "", null);
		return apiInfo;
	}
}