package com.revature.p0.models;

import java.util.Objects;

public class Customer {
	// Attributes/Variables
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String username;
	private String password;

	// default Constructor
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	// constructor without customerId
	public Customer(String firstName, String lastName, String email, String username, String password) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	// Full constructor
	public Customer(String customerId, String firstName, String lastName, String email, String username,
			String password) {
		super();
		this.customerId = customerId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	// Getters and setters
	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	//is this needed. it is in the example, but I'm not seeing how it fits with the program.  will comment out until I figure it out.
//	// Custom Methods
//	public String toFileString() {
//		StringBuilder buildFileString = new StringBuilder();
//		
//		buildFileString.append(customerId).append(":")
//						.append(firstName).append(":")
//						.append(lastName).append(":")
//						.append(email).append(":")
//						.append(username).append(":")
//						.append(password);
//		return buildFileString.toString();
//	}
//	
//	public void printFromFile(String[] arr) {
//		for(String arrV:arr) {
//			System.out.println(arrV);
//		}
//		
//	}
	
	// Overrides
	@Override
	public String toString() {
		return "Customers [customerId=" + customerId + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", username=" + username + ", password=" + password + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(customerId, firstName, lastName, email, password, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		return Objects.equals(customerId, other.customerId) && Objects.equals(firstName, other.firstName) 
				&& Objects.equals(lastName, other.lastName) && Objects.equals(email, other.email) 
				&& Objects.equals(password, other.password) && Objects.equals(username, other.username);
	}

}
