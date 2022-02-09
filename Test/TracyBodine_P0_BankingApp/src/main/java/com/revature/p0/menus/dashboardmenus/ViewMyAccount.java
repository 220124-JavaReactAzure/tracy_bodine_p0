package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.util.MenuRouter;

public class ViewMyAccount extends Menu {

	public ViewMyAccount(BufferedReader consoleReader, MenuRouter router) {
		super("MyAccount", "/my-account", consoleReader, router);

	}

	
	//need to figure out how to display accounts from database
	@Override
	public void render() throws Exception {
		
		System.out.println("Account view selected");

		//Need to pull data from database
		System.out.println("Here is a list of your accounts.");

	}

}
