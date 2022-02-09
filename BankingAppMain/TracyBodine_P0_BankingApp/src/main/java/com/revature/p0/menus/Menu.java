package com.revature.p0.menus;

import java.io.BufferedReader;

import com.revature.p0.util.MenuRouter;



public abstract class Menu {
	
	//create the variables used to identify which menu is selected
	protected String name;
	protected String route;
	protected BufferedReader consoleReader;
	protected MenuRouter router;
	
	//menu constructor using auto-generated builder
	public Menu(String name, String route, BufferedReader consoleReader, MenuRouter router) {
		super();
		this.name = name;
		this.route = route;
		this.consoleReader = consoleReader;
		this.router = router;
	}

	//getters - no need for setters as this class is only taking in info.
	public String getName() {
		return name;  
	}

	public String getRoute() {
		return route;
	}
	
	//this was in example. need to follow up as to why the render method is here. 
	public abstract void render() throws Exception;

}
