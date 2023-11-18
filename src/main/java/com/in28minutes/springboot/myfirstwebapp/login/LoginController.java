package com.in28minutes.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(getClass());

	// login => com.in28minutes.springboot.myfirstwebapp.login.loginController =>
	// login.jsp

	// http://localhost:8080/login?name=Ranga
	// Model
	@RequestMapping("login")
	public String gotoLoginPage(@RequestParam String name, ModelMap model) {
		model.put("name", name);
		logger.debug("Request param is {}", name);
		logger.info("i want this printed at info level {}");
		logger.warn("i want this printed at warn level {}");
		System.out.println("request param is " + name); // not recommended for prod code
		return "login";
	}

}
