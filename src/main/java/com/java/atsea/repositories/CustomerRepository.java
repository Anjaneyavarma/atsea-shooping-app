/**
 * 
 */
package com.java.atsea.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.java.atsea.model.Customer;

/**
 * @author av
 *
 */

public interface CustomerRepository extends MongoRepository<Customer, String> {
	
//	Customer findOne(String id);

	Customer findByName(String name);

	// adding find by username
//	@Query("SELECT c FROM Customer c WHERE c.username = :userName")
	@Query("{'username' : ?0}")
	Customer findByUserName(String username);
	
	@Query("{'email' : ?0}")
	Customer findByEmail(String email);

}
