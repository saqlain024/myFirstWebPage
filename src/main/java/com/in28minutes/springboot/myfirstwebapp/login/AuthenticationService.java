package com.in28minutes.springboot.myfirstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

	public boolean Authenticate(String username, String password) {
		boolean isValidUserName = username.equalsIgnoreCase("in28Minutes");
		boolean isValidPassword = password.equalsIgnoreCase("dummy");

		return isValidUserName && isValidPassword;
	}
}
