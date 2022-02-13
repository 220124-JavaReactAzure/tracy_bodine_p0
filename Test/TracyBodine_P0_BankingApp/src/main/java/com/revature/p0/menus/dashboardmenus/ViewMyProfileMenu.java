package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.models.Customer;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class ViewMyProfileMenu extends Menu {
	
	private final CustomerService customerService;
	private Customer sessionCustomer;

	public ViewMyProfileMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService2) {
		super("MyProfile", "/my-profile", consoleReader, router);
		this.customerService = customerService;
	
	}


//	public ViewMyAccount(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
//		super("MyProfile", "/my-profile", consoleReader, router);
//		this.customerService = customerService;
//	
//	}

	
	@Override
	public void render() throws Exception {

		Customer sessionCustomer = customerService.getSessionCustomer();

		if (sessionCustomer == null) {
			System.out.println("You are not currently logged in! Returning to the login screen.....");
			router.transfer("/login");
			return;
		}

		while (customerService.isSessionActive()) {
			System.out.println("\nWelcome " + sessionCustomer.getUsername() + "\n\nProfie View"
					+ "\n\nPlease select from the following options");
			String menu = 
					"2) Edit Profile\n" + 
					"3) Return to main menu\n" + 
					"> ";

			System.out.println(customerService.findMyProfile(sessionCustomer.getUsername()));
			
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
