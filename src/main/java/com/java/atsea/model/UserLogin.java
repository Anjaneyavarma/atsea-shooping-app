/**
 * 
 */
package com.java.atsea.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author av
 *
 */

@AllArgsConstructor
@ToString
public class UserLogin {
	
	
	@Getter @Setter
	private String email;
	@Getter @Setter
	private String password;
	
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
