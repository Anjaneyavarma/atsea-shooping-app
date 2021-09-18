/**
 * 
 */
package com.java.atsea.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author av
 *
 */

@Data
@Document(collection = "Customer")
@NoArgsConstructor
public class Customer {

	@Id
	private String Id;
	private String name;
	private Address address;
	@Field("email")
	@Indexed(unique = true)
	private String email;
	@Indexed(unique = true)
	private String username;
	private String password;

	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer( String name, Address address, String email, String username, String password) {
		this.name = name;
		this.address = address;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public String getId() {
		return Id;
	}

	public String getName() {
		return name;
	}

	public Address getAddress() {
		return address;
	}

	public String getEmail() {
		return email;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
