package com.tech.xeon.config;

import static org.springframework.security.config.Customizer.withDefaults;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		/*http.authorizeHttpRequests()
		.requestMatchers("/dashboard").authenticated()
		.requestMatchers("/contactUs").permitAll();
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());*/
		//above code can be written like this too
		http.authorizeHttpRequests()
		.requestMatchers("/dashboard").authenticated()
		.requestMatchers("/contactUs").permitAll()
		.and().formLogin()//and method is used to combined two configurations in spring security
		.and().httpBasic();
		
		//conf to deny all request 
		/*http.authorizeHttpRequests()
		.anyRequest().denyAll()
		.and().formLogin()//and method is used to combined two configurations in spring security
		.and().httpBasic();*/
		
		//conf to permit all request 
		/*http.authorizeHttpRequests()
		.anyRequest().permitAll()
		.and().formLogin()//and method is used to combined two configurations in spring security
		.and().httpBasic();*/
		
		return http.build();
	}
	
}
