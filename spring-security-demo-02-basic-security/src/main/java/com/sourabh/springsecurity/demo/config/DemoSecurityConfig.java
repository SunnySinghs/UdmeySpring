package com.sourabh.springsecurity.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		UserBuilder user = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(user.username("sam").password("sam123").roles("EMPLOYEE"))
			.withUser(user.username("tam").password("tam123").roles("MANAGER"))
			.withUser(user.username("cam").password("cam123").roles("ADMIN"));
	}

	
}
