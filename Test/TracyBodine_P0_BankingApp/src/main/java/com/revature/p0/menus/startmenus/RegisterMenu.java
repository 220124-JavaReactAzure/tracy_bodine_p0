package com.revature.p0.menus.startmenus;

import java.io.BufferedReader;

import com.revature.p0.exceptions.InvalidRequestException;
import com.revature.p0.menus.Menu;
import com.revature.p0.models.Customer;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class RegisterMenu extends Menu {

	CustomerService customerService;

	public RegisterMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Register", "/register", consoleReader, router);
		this.customerService = customerService;
	}

	@Override
	public void render() throws Exception {
		
				System.out.println("User registration selected");

				// Information needed from the user: first name, last name, email, username, password

//				System.out.println("Please provided some basic information");
//				System.out.print("First Name:\n" + "> ");
//				String firstName = consoleReader.readLine();
				
				System.out.println("Please provided some basic information");
				System.out.print("First Name: ");
				String firstName = consoleReader.readLine();

				System.out.print("Last Name: ");
				String lastName = consoleReader.readLine();

				System.out.print("Email Address: ");
				String email = consoleReader.readLine();

				System.out.print("Username: ");
				String username = consoleReader.readLine();

				System.out.print("Password: ");
				String password = consoleReader.readLine();

				Customer customer = new Customer(firstName, lastName, email, username, password);

				try {
					customerService.registerNewCustomer(customer);
				} catch (InvalidRequestException e) {

					System.out.println("THE INFORMATION YOU ENTERED IS INVALID, PLEASE TRY AGAIN\n\n\n");

					router.transfer("/welcome");
				}
			}
		
	}
