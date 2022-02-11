package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.models.Customer;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class DashboardMenu extends Menu {

	private final CustomerService customerService;

	public DashboardMenu(BufferedReader consoleReader, MenuRouter router, CustomerService customerService) {
		super("Dashboard", "/dashboard", consoleReader, router);
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

		while (customerService.isSessionActive()) {
			System.out.println("\nWelcome " + sessionCustomer.getUsername() + "\n\nMain Menu" + "\n\nPlease select from the following options");
			String menu = 
					"1) View/edit my profile information\n" + 
					"2) Create/edit account\n" +
					"3) View your accounts\n" + 
					"4) Logout\n" + 
					 "> ";

			System.out.print(menu);

			String userSelection = consoleReader.readLine();

			switch (userSelection) {
			case "1":
				System.out.println("View/edit profile selected");
				router.transfer("/user-profile-edit");
				break;
			case "2":
				System.out.println("Create/edit account selected");
				router.transfer("/create-account");
				break;
			case "3":
				System.out.println("View my accounts selected:");
				router.transfer("/my-accounts");
				break;
			case "4":
				customerService.logout();
				break;
			default:
				System.out.println("Invalid selection. Pleas try again.");
			}
		}
	}

}
