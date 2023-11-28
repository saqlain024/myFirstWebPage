package com.in28minutes.springboot.myfirstwebapp.security;

import static org.springframework.security.config.Customizer.withDefaults;

import java.util.function.Function;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfiguration {
	// LDAP or database
	// in memory

//	InMemoryUserDetailsManager 
//	InMemoryUserDetailsManager(UserDetails... users)

	@Bean
	public InMemoryUserDetailsManager createUserDetailsManager() {
		UserDetails userDetails1 = CreateNewUser("in28Minutes", "dummy");
		UserDetails userDetails2 = CreateNewUser("saqlain", "12345");

		return new InMemoryUserDetailsManager(userDetails1, userDetails2);
	}

	private UserDetails CreateNewUser(String username, String password) {
		Function<String, String> passwordEncoder = input -> passwordEncoder().encode(input);

		UserDetails userDetails = User.builder().passwordEncoder(passwordEncoder).username(username).password(password)
				.roles("USER", "ADMIN").build();
		return userDetails;
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// all urls are protected
	// a login from is shown for unauthorized requests
	// csrf disable
	// frame

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception { // when we override securityFilterChain
																					// , we need to
		// define entire chain again!
		http.authorizeHttpRequests(auth -> auth.anyRequest().authenticated());

		http.formLogin(withDefaults());

		http.csrf().disable();
		http.headers().frameOptions().disable();
		return http.build();
	}

}
