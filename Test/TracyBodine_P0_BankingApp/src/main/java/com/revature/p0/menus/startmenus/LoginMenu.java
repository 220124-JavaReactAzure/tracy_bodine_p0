package com.revature.p0.menus.startmenus;

import java.io.BufferedReader;

import com.revature.p0.exceptions.AuthenticationException;
import com.revature.p0.menus.Menu;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;


public class LoginMenu extends Menu {

	private final CustomerService customerService;

	public LoginMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Login", "/login", consoleReader, router);
		this.customerService = customerService;
	
	}

	@Override
	public void render() throws Exception {
		
		System.out.println("User login selected");

		// Information needed from the user: username and password
		 System.out.println("Please enter your account credentials.");
	     System.out.print("Username:\n" + "> ");
	     String username = consoleReader.readLine();
	     System.out.print("Password:\n" + "> ");
	     String password = consoleReader.readLine();
	        

	     try {
	    	 customerService.authenticateCustomer(username, password);
	    	 router.transfer("/dashboard");
	        } catch (AuthenticationException e) {
	            System.out.println("You have entered a wrong Username or Password. Please try again.");
	        }
	     
	        
	}

}
