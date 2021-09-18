/**
 * 
 */
package com.java.atsea.model;

import lombok.Data;

/**
 * @author av
 *
 */

@Data
public class Address {
	
	private String fullName;
	private String mobileNumber;
	private String pincode;
	private String addressLine_1;
	private String addressLine_2;
	private String landmark;
	private String city;
	private String state;

	/**
	 * 
	 */
	public Address() {
		
		
	}
	
	

	public Address(String fullName, String mobileNumber, String pincode, String addressLine_1, String addressLine_2,
			String landmark, String city, String state) {
		super();
		this.fullName = fullName;
		this.mobileNumber = mobileNumber;
		this.pincode = pincode;
		this.addressLine_1 = addressLine_1;
		this.addressLine_2 = addressLine_2;
		this.landmark = landmark;
		this.city = city;
		this.state = state;
	}

	

	@Override
	public String toString() {
		return "Adress [fullName=" + fullName + ", mobileNumber=" + mobileNumber + ", pincode=" + pincode
				+ ", addressLine_1=" + addressLine_1 + ", addressLine_2=" + addressLine_2 + ", landmark=" + landmark
				+ ", city=" + city + ", state=" + state + "]";
	}



	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getAddressLine_1() {
		return addressLine_1;
	}

	public void setAddressLine_1(String addressLine_1) {
		this.addressLine_1 = addressLine_1;
	}

	public String getAddressLine_2() {
		return addressLine_2;
	}

	public void setAddressLine_2(String addressLine_2) {
		this.addressLine_2 = addressLine_2;
	}

	public String getLandmark() {
		return landmark;
	}

	public void setLandmark(String landmark) {
		this.landmark = landmark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

}
