package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.models.Customer;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class AccountMenu extends Menu {
	
	private final CustomerService customerService;
	private Customer sessionCustomer;
	
	public AccountMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Account", "/account", consoleReader, router);
		this.customerService = customerService;
	}
	
	@Override
	public void render() throws Exception {

		Customer sessionCustomer = customerService.getSessionCustomer();

		if (sessionCustomer == null) {
			System.out.println("You are not currently logged in! Returning to the login screen.....");
			router.transfer("/login");
			return;
		}
		
			while (CustomerService.isSessionActive()) {
				System.out.println("\nWelcome " + sessionCustomer.getUsername() + "\n\nMain Menu" + "\n\nPlease select from the following options");
				String menu = 
						"1) View my Accounts\n" + 
						"2) Make a depost\n" +
						"3) Make a withdrawl\n" + 
						"4) Return to main menu\n" + 
						 "> ";

				System.out.print(menu);

				String userSelection = consoleReader.readLine();

				switch (userSelection) {
				case "1":
					System.out.println("View my Accounts Selected");
					router.transfer("/my-accounts");
					break;
				case "2":
					System.out.println("Make a deposit selected");
					router.transfer("/deposit");
					break;
				case "3":
					System.out.println("Make a withdrawl selected:");
					router.transfer("/withdrawl");
					break;
				case "4":
					System.out.println("Return to main menu:");
					router.transfer("/dashboard");
					break;
				default:
					System.out.println("Invalid selection. Pleas try again.");
				}
			}
		}

	@Override
	public void render() throws Exception {
		// TODO Auto-generated method stub
		
	}

	}
