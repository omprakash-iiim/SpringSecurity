package com.tech.xeon.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		
		http.authorizeHttpRequests()
		.requestMatchers("/dashboard").authenticated()
		.requestMatchers("/contactUs").permitAll()
		.and().formLogin()//and method is used to combined two configurations in spring security
		.and().httpBasic();
		return http.build();
	}
	
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		//Approach 1
		
		UserDetails admin = User.withDefaultPasswordEncoder()
				.username("admin")
				.password("adminPassword")
				.authorities("admin")
				.build();
		
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("user")
				.password("userPassword")
				.authorities("read")
				.build();
		
		//Approach 2
		/*UserDetails admin = User.withUsername("admin")
				.password("adminPassword")
				.authorities("admin")
				.build();
		
		UserDetails user = User.withUsername("user")
				.password("userPassword")
				.authorities("read")
				.build();
		*/
		return new InMemoryUserDetailsManager(admin, user);
	}
	
	
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
	
}
