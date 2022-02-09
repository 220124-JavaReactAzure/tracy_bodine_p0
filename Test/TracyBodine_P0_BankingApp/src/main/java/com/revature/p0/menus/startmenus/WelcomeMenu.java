package com.revature.p0.menus.startmenus;

import static com.revature.p0.util.AppState.shutdown;

import java.io.BufferedReader;

import com.revature.p0.menus.Menu;
import com.revature.p0.util.MenuRouter;

//first of all need to extend the original Menu class.
public class WelcomeMenu extends Menu{

	/*
	 * // //next, need to create a default constructor - should get the arguments from supper class 
	 * because of inheritance.
	 * 
	 * public WelcomeMenu(String name, String route, BufferedReader consoleReader, MenuRouter router) { 
	 * 	super(name, route, consoleReader, router); 
	 * 	// TODO Auto-generated constructor stub
	 * }
	 *
	 * from examining the example, not all four arguments are used from the super
	 * constructor, because we are in the sub-menu, we wont need the menu name and
	 * router name for this constructor. But still need to get user input from the
	 * console and route to the correct menu option. So why change the strings
	 * arguments in the supper class call? To manually set the values?
	 */
	
	//looks like the name string argument will be the console header for this menu. 
	//And the route string argument is the name of the destination?
	public WelcomeMenu(BufferedReader consoleReader, MenuRouter router) {
						 //why a slash in the route name?
		super("Welcome", "/welcome", consoleReader, router);
		
	}

	
	//Then create menu options
	@Override
	public void render() throws Exception {
		
		//create the menu options that appear in the console.
		System.out.print(
				"Welcome to the Revature Banking App!\n" + "Please please choose from the following options\n" + 
				"1) Customer Login\n" + "2) New Customer Registration\n" + "3) Exit\n" + "> ");
		
		//using the consoleReader to get the customer input from the console
		String userSelection = consoleReader.readLine();

		//switch case to run the selections
		switch (userSelection) {
		case "1":
			router.transfer("/login");
			break;
		case "2":
			router.transfer("/register");
			break;
		case "3":
			shutdown();
			break;
			
		//This happens if a selection other than those shown in the switch case is used.
		default:
			System.out.println("Invalid selection, please make your selection from the availible options.");
			break;
		}
		
	}
	
	
}

