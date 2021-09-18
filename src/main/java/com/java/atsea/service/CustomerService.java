/**
 * 
 */
package com.java.atsea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.java.atsea.model.Customer;

/**
 * @author av
 *
 */


public interface CustomerService {
	
	Optional<Customer> findById(String Id);
	
	Customer findByEmail(String email);
	
	Customer findByUserName(String username);

	Customer findByName(String customerName);
	
	Customer createCustomer(Customer customer);

	void saveCustomer(Customer customer);

	void updateCustomer(Customer customer);

	void deleteCustomerById(String customerId);

	void deleteAllCustomers();

	List<Customer> findAllCustomers();

	boolean customerUserNameExist(Customer customer);
	
	boolean customerEmailExist(Customer customer);
	

}
