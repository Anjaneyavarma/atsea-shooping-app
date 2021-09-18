package com.java.atsea.controller;

import java.util.Objects;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.atsea.model.Customer;
import com.java.atsea.model.UserLogin;
import com.java.atsea.repositories.CustomerRepository;
import com.java.atsea.service.CustomerService;
import com.java.atsea.util.CustomerErrortype;

@RestController
@RequestMapping("/atsea/api/")
public class LoginController {
	
	public static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	JSONObject jsonObject = new JSONObject();
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody UserLogin userLogin){
		
		logger.info("Authentication Customer : {}", userLogin);
		
		Customer customer = customerService.findByEmail(userLogin.getEmail());
		
		if(customer == null) {
			logger.error("email {} doesn't exists please register", userLogin.getEmail());
			return new ResponseEntity(new CustomerErrortype("Your Email "+ userLogin.getEmail() +" doesn't exists in our records, please register"), HttpStatus.NOT_FOUND);
		}
		
		if(Objects.equals(userLogin.getEmail(), customer.getEmail()) &&  passwordEncoder.matches(userLogin.getPassword(), customer.getPassword())) {
			
			jsonObject.put("message", "Successfully Logged in");
			
			return new ResponseEntity<JSONObject>(jsonObject, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Object>(new CustomerErrortype("Password is incorect, please try again."), HttpStatus.UNAUTHORIZED);
		
	}


}
