package com.java.atsea.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.java.atsea.model.Customer;
import com.java.atsea.repositories.CustomerRepository;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository customerRepository;	

	@Override
	public Customer findByUserName(String username) {
		
		return customerRepository.findByUserName(username);
	}

	@Override
	public Customer findByName(String customerName) {
		
		return customerRepository.findByName(customerName);
	}

	@Override
	public Customer createCustomer(Customer customer) {
//		customer.setPassword(passwordEncoder.encode(customer.getPassword()));
		customer =  customerRepository.save(customer);
		return customer;
	}

	@Override
	public void saveCustomer(Customer customer) {
			customerRepository.save(customer);
		
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerRepository.save(customer);
		
	}

	@Override
	public void deleteCustomerById(String customerId) {
		customerRepository.deleteById(customerId);
		
	}

	@Override
	public void deleteAllCustomers() {
		customerRepository.deleteAll();		
	}

	@Override
	public List<Customer> findAllCustomers() {
		return (List<Customer>) customerRepository.findAll();
	}


	@Override
	public boolean customerUserNameExist(Customer customer) {
		return customerRepository.findByUserName(customer.getUsername()) != null;
	}

	@Override
	public Optional<Customer> findById(String Id) {
		return customerRepository.findById(Id);
	}

	@Override
	public Customer findByEmail(String email) {
		return customerRepository.findByEmail(email);
	}

	@Override
	public boolean customerEmailExist(Customer customer) {
		return customerRepository.findByEmail(customer.getEmail()) != null;
	}

}
