In the SpringBootWebSecurityConfiguration there is a methid called defaultSecurityFilterChain, which defines the default beahviour of spring security authentication. The default implementation says that all the requests coming to particular project should get authenticated. 
Below is the default implementation of spring security which authenticate the user credentials for all the resources.

	@Bean
	@Order(SecurityProperties.BASIC_AUTH_ORDER)
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests((requests) -> requests.anyRequest().authenticated());
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}
		
So to change this default beahivour we have override this implementation in our own custom configuration class. In the below implementation we have explicitly telling the spring application about which of the resources we need to authneticate and also mentioned which we dont want to get authenticated.

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests()
		.requestMatchers("/dashboard").authenticated()
		.requestMatchers("/contactUs").permitAll();
		http.formLogin(withDefaults());
		http.httpBasic(withDefaults());
		return http.build();
	}

		