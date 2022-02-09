package com.revature.p0.menus.dashboardmenus;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.util.MenuRouter;

public class AccountMenu extends Menu{
	
	public AccountMenu(BufferedReader consoleReader, MenuRouter router) {
		super("Account", "/account", consoleReader, router);
	}

	@Override
	public void render() throws Exception {
			
	}

}
