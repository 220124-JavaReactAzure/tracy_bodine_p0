package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.models.Account;
import com.revature.p0.services.AccountService;
import com.revature.p0.util.MenuRouter;

public class AccountCreationMenu extends Menu {

	private final AccountService accountService;
	
	public AccountCreationMenu(BufferedReader consoleReader, MenuRouter router, AccountService accountService) {
		super("AccountCreation", "/create-account", consoleReader, router);
		this.accountService = accountService;
		
	}

	@Override
	public void render() throws Exception {
		
		System.out.println("Account creation selected");

		// Information needed from the user: account name, account type, and account balance
		System.out.println("New Account Creation\n" + "Please enter the needed information\n");
		
		System.out.println("1 - Account name\n");
		String accountName = consoleReader.readLine();
		System.out.println("2 - Account type\n");
		String accountType = consoleReader.readLine();
		System.out.println("3 - Initial account balance\n");
		String accountBalance = consoleReader.readLine();

		
		Account newAccount = new Account(accountName, accountType, accountBalance);
		
		accountService.createAccount(newAccount);
	}

}

