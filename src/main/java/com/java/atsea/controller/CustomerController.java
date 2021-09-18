/**
 * 
 */
package com.java.atsea.controller;

import com.java.atsea.model.Customer;
import com.java.atsea.service.CustomerService;
import com.java.atsea.util.CustomerErrortype;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author av
 *
 */

@RestController
@RequestMapping("/atsea/api")
@CrossOrigin(origins = "http://localhost:5000")
public class CustomerController {
	
	public static final Logger logger = LoggerFactory.getLogger(CustomerController.class);
	
	@Autowired
	CustomerService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	//retrieve all customer
	@GetMapping("/customers")
	public Iterable<Customer> getAllCustomers(){
		
		return customerService.findAllCustomers();
	
	} 
	
	//create customer
	@PostMapping("/CustomerRegistration")
	public ResponseEntity<?> createCustomer(@RequestBody Customer customer) {
		logger.info("Creating Customer : {}", customer);
		
		
		boolean checkIfEmailIsExist = customerService.customerEmailExist(customer);
		boolean checkIfUserNameExist = customerService.customerUserNameExist(customer);
		
		if(checkIfEmailIsExist && checkIfUserNameExist) {
			logger.error("Unable to create a customer with email {}", customer.getEmail());
			return new ResponseEntity<>(new CustomerErrortype("A customer with email" + 
					customer.getEmail() +" and username "+customer.getUsername() + " already exists."),HttpStatus.CONFLICT);
		}
		if(checkIfUserNameExist) {
			logger.error("Unable to create a customer with email {}", customer.getEmail());
			return new ResponseEntity<>(new CustomerErrortype("A customer with uername " + 
					customer.getUsername() + " already exists."),HttpStatus.CONFLICT);
		}
		if(checkIfEmailIsExist) {
			logger.error("Unable to create a customer with email {}", customer.getEmail());
			return new ResponseEntity(new CustomerErrortype("A customer with email " + 
					customer.getEmail() + " already exists."),HttpStatus.CONFLICT);
		}
				
		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		Customer createCustomerInfo = customerService.createCustomer(customer);
		String customerId = createCustomerInfo.getId();
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("Id", customerId);
		
		return new ResponseEntity<Customer>(customer, HttpStatus.CREATED);
	}
	

}
