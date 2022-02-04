package com.revature.p0.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.revature.p0.daos.CustomerDAO;
import com.revature.p0.menus.DashboardMenu;
import com.revature.p0.menus.LoginMenu;
import com.revature.p0.menus.RegisterMenu;
import com.revature.p0.menus.WelcomeMenu;
import com.revature.p0.services.CustomerService;



public class AppState {

	private static boolean isRunning;
	private final MenuRouter router;
	
	public AppState() {
		isRunning = true;
		router = new MenuRouter();
		BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
		
		CustomerDAO customerDAO = new CustomerDAO();
		
		//create the routing options for navigating the app's sub menus 
		CustomerService customerService = new CustomerService(customerService);
		
		//shown in example, just doing on option to see how it works.
		router.addMenu(new WelcomeMenu(consoleReader, router)); //try first
		router.addMenu(new RegisterMenu(consoleReader, router, customerService));
		router.addMenu(new LoginMenu(consoleReader, router, customerService));
		router.addMenu(new DashboardMenu(consoleReader, router, customerService));
	}
	
	//exception handling during App Startup
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
	
	// shutdown method allows the exiting of the App
	public static void shutdown() {
		isRunning = false;
	}
	
}