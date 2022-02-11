package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.exceptions.InvalidRequestException;
import com.revature.p0.menus.Menu;
import com.revature.p0.models.Account;
import com.revature.p0.models.Customer;
import com.revature.p0.services.AccountService;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.MenuRouter;

public class WithdrawlMenu extends Menu {

	private AccountService accountService;

	public WithdrawlMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("Withdrawl", "/withdrawl", consoleReader, router);
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

		System.out.print("2 - Withdrawl Amount: ");
		String depositAmount = consoleReader.readLine();

	}
}