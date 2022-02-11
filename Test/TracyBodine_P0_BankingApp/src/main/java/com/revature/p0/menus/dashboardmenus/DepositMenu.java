package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.exceptions.InvalidRequestException;
import com.revature.p0.menus.Menu;
import com.revature.p0.models.Account;
import com.revature.p0.models.Customer;
import com.revature.p0.services.AccountService;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class DepositMenu extends Menu {

	private AccountService accountService;

	public DepositMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("Deposit", "/deposit", consoleReader, router);
		this.accountService = accountService;
	}

	@Override
	public void render() throws Exception {

		System.out.println("\nNew Deposit\n");

		// Information needed from the user: first name, last name, email, username,
		// password
		System.out.println("Please provid deposit details");
		System.out.print("1 - Account Name: ");
		String accountName = consoleReader.readLine();

		System.out.print("2 - Deposit Amount: ");
		String depositAmount = consoleReader.readLine();

	}
}

//				Customer customer = new Customer(accountName, depositAmount);
//
//				try {
//					customerService.registerNewCustomer(customer);
//				} catch (InvalidRequestException e) {
//
//					System.out.println("THE INFORMATION YOU ENTERED IS INVALID, PLEASE TRY AGAIN\n\n\n");
//
//					router.transfer("/welcome");
//				}

//	//need to figure out how to display accounts from database
//	@Override
//	public void render() throws Exception {
//		
//		System.out.println("Account view selected");
//
//		//Need to pull data from database
//		System.out.println("Here is a list of your accounts.");
//
//	}
