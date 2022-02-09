package com.revature.p0.services;

import com.revature.p0.daos.CustomerDAO;
import com.revature.p0.exceptions.AuthenticationException;
import com.revature.p0.exceptions.InvalidRequestException;
import com.revature.p0.exceptions.ResourcePersistenceException;
import com.revature.p0.models.Customer;
import com.revature.p0.util.collections.List;

public class CustomerService {

	private final CustomerDAO customerDAO;
	private Customer sessionCustomer;
	
	public CustomerService(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
		this.sessionCustomer = null;
	}
	
	public Customer getSessionCustomer() {
		return sessionCustomer;
	}
	
	public Customer registerNewCustomer(Customer newCustomer) {
		if(!isCustomerValid(newCustomer)) {
			throw new InvalidRequestException("Invalid user data provided");
		}

		boolean usernameAvailable = customerDAO.findByUsername(newCustomer.getUsername()) == null;
		boolean emailAvailable = customerDAO.findByEmail(newCustomer.getEmail()) == null;
		
		if(!usernameAvailable || !emailAvailable) {
			if(!usernameAvailable && emailAvailable) {
				throw new ResourcePersistenceException("The provided username has already taken");
			} else if(usernameAvailable) {
				throw new ResourcePersistenceException("The provided email has already taken");
			} else {
				throw new ResourcePersistenceException("The provided username and email has already taken");
			}
		}
		
		Customer persistedCustomer = customerDAO.create(newCustomer);
		
		if(persistedCustomer == null) {
			throw new ResourcePersistenceException("The Customer information could not be persisted");
		}
		
		return persistedCustomer;
	}
	
	public List<Customer> getAllCustomer(){
		return customerDAO.findAll();	
	}
	
	//TODO: Implement authentication
	public void authenticateCustomer(String username, String password) {
		
		if(username == null || username.trim().equals("") || password == null || password.trim().equals("")) {
			throw new InvalidRequestException("Either username or password is an invalid entry. Please try logging in again");
		}
		
		Customer authenticatedCustomer = customerDAO.findByUsernameAndPassword(username, password);
		
		if(authenticatedCustomer == null) {
			throw new AuthenticationException("Unauthenticated user, information provided was not found in our database.");
		}
		sessionCustomer = authenticatedCustomer;
	}

	public boolean isCustomerValid(Customer newCustomer) {
		if(newCustomer == null) return false;
		if(newCustomer.getFirstName() == null || newCustomer.getFirstName().trim().equals("")) return false;
		if(newCustomer.getLastName() == null || newCustomer.getLastName().trim().equals("")) return false;
		if(newCustomer.getEmail() == null || newCustomer.getEmail().trim().equals("")) return false;
		if(newCustomer.getUsername() == null || newCustomer.getUsername().trim().equals("")) return false;
		return newCustomer.getPassword() != null || !newCustomer.getPassword().trim().equals("");


	}
	
	public void logout() {
		sessionCustomer = null;
	}
	
	public boolean isSessionActive() {
		return sessionCustomer != null;
	}
}
