package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.models.Customer;
import com.revature.p0.services.AccountService;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class ViewMyAccountMenu extends Menu {

	private final CustomerService customerService;
	private final AccountService accountService;
	private Customer sessionCustomer;

	public ViewMyAccountMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService,AccountService accountService) {
		// mispelled accounts, forgot s
		super("MyAccount", "/my-accounts", consoleReader, router); 
		this.customerService = customerService;
		this.accountService = accountService;
	}

	
	@Override
	public void render() throws Exception {

		Customer sessionCustomer = customerService.getSessionCustomer();

		if (sessionCustomer == null) {
			System.out.println("You are not currently logged in! Returning to the login screen.....");
			router.transfer("/login");
			return;
		}

		while (customerService.isSessionActive()) {
			System.out.println("\nWelcome " + sessionCustomer.getUsername() + "\n\nAccount View"
					+ "\n\nPlease select from the following options");
			String menu = 
					"1) Make a depost\n" + 
					"2) Make a withdrawl\n" + 
					"3) Return to main menu\n" + 
					"> ";
			System.out.println("Current account balance: \n"+ accountService.findMyAccount(sessionCustomer.getUsername()).getAccountBalance() + "\n");
			
			System.out.print(menu);
			

			String userSelection = consoleReader.readLine();

			switch (userSelection) {
			case "1":
				System.out.println("Make a deposit selected");
				router.transfer("/deposit");
				break;
			case "2":
				System.out.println("Make a withdrawl selected:");
				router.transfer("/withdrawl");
				break;
			case "3":
				System.out.println("Return to main menu:");
				router.transfer("/dashboard");
				break;
			default:
				System.out.println("Invalid selection. Pleas try again.");
			}
		}
	}

}

//	//need to figure out how to display accounts from database
//	@Override
//	public void render() throws Exception {
//		
//		System.out.println("Account view selected");
//
//		//Need to pull data from database
//		System.out.println("Here is a list of your accounts.");
//		System.out.println(sessionCustomer());
//
//	}
//
//}
