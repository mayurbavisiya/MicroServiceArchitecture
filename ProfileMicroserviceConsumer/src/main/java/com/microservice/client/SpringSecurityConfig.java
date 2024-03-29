package com.microservice.client;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author Administrator
 *
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	// Created 2 users for demo
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {

		auth.inMemoryAuthentication().withUser("user").password("user")
				.roles("USER").and().withUser("admin").password("admin")
				.roles("USER", "ADMIN");

	}

	// Secure the endpoins with HTTP Basic authentication
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http
		// HTTP Basic authentication
		.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/api/**").hasRole("USER")
				.antMatchers(HttpMethod.POST, "/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PUT, "/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.PATCH, "/**").hasRole("ADMIN")
				.antMatchers(HttpMethod.DELETE, "/**").hasRole("ADMIN").and()
				.csrf().disable().formLogin().disable();
	}

}