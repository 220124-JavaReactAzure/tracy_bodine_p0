package com.revature.p0.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.p0.daos.AccountDAO;
import com.revature.p0.daos.CustomerDAO;
import com.revature.p0.services.AccountService;
import com.revature.p0.services.CustomerService;
import com.revature.p0.util.logging.Logger;
import com.revature.p0.menus.dashboardmenus.AccountCreationMenu;
import com.revature.p0.menus.dashboardmenus.AccountMenu;
import com.revature.p0.menus.dashboardmenus.DashboardMenu;
import com.revature.p0.menus.startmenus.LoginMenu;
import com.revature.p0.menus.startmenus.RegisterMenu;
import com.revature.p0.menus.startmenus.WelcomeMenu;




public class AppState {

	private final Logger logger;
	private static boolean isRunning;
	private final MenuRouter router;	
	
	public AppState() {
		
		logger = Logger.getLogger(true);
		logger.log("The Revature Banking App is starting.....");
		
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		CustomerDAO customerDAO = new CustomerDAO();
		AccountDAO accountDAO = new AccountDAO();	
		CustomerService customerService = new CustomerService(customerDAO);
		AccountService accountService = new AccountService(accountDAO, customerService);
		
		router.addMenu(new WelcomeMenu(consoleReader, router));
		router.addMenu(new RegisterMenu(consoleReader, router, customerService));
		router.addMenu(new LoginMenu(consoleReader, router, customerService));
		router.addMenu(new DashboardMenu(consoleReader, router, customerService));
		router.addMenu(new AccountMenu(consoleReader, router));
		router.addMenu(new AccountCreationMenu(consoleReader, router, accountService));
		
		logger.log("Banking App started.");
	}
	
	public void startup() {
		try {
			while(isRunning) {
				router.transfer("/welcome");
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public static void shutdown() {
		isRunning = false;
	}
	
}