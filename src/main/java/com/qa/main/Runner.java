package com.qa.main;

import java.sql.SQLException;
import java.util.Scanner;

public class Runner {
	
	private static Scanner scn = new Scanner(System.in);
	
	public static void main(String[] args) throws SQLException {
		
		DBconnection dbCon = new DBconnection();
		
		String action;
		action = getAction();
		
		
		
		try {
			do {
				switch (action) {
				case "create":
					System.out.println("Please enter your first and last name.");
					String name = scn.nextLine();
					dbCon.create(name);
					break;
					
				case "purchase":
					System.out.println("Please enter your Customer ID.");
					int customerId = scn.nextInt();
					dbCon.purchase(customerId);
					break;
					
				case "add":
					System.out.println("Enter the product name");
					String itemName = scn.nextLine();
					dbCon.add(itemName);
					break;
					
				case "read":
					System.out.println("Please enter your Customer ID");
					int id = scn.nextInt();
					scn.nextLine();
					dbCon.read(id);
					break;
				
				case "update":
					System.out.println("Please enter your Customer ID to continue");
					int uId = scn.nextInt();
					dbCon.update(uId);
					break;
					
				case "delete":
					System.out.println("Please enter your Customer ID");
					int id2 = scn.nextInt();
					scn.nextLine();
					dbCon.delete(id2);
					break;
					
							
				default:
					System.out.println("no match found");
					break;
								
				}
				action = getAction();
			
			} while(!action.equals("exit"));
				System.out.println("bye bye");
				
		} finally {
			scn.close();
			dbCon.exit();
		}
		
		
		
	
		
	}
	
	private static String getAction() {
		String menuMsg = "==================================================\n" 
+ "IMS System Command List:\n"
				+ "==================================================\n" 
				+ "\t- Create\t Create a new customer account" + "\n"
				+ "\t- Add\t         Add a new item into Inventory" + "\n"
				+ "\t- Purchase\t Create a purchase order" + "\n"
				+ "\t=================\n"
				+ "\t- View \t\t Read all customers" + "\n" 
				+ "\t- View one\t Read one customers" + "\n"
				+ "\t- Review\t Review items in inventory" + "\n"
				+ "\t- Review All\t Review all items in inventory" + "\n"
				+ "\t- Read \t         View an order" + "\n"
				+ "\t- Read All\t         Read all orders" + "\n"
				+ "\t=================\n"
				+ "\t- Update Account\t Update a customer" + "\n" 
				+ "\t- Update Order\t Update an order" + "\n" 
				+ "\t- Restock\t Update item" + "\n"
				+ "\t=================\n"
				+ "\t- Delete\t Delete a customer" + "\n" 
				+ "\t- Remove\t Remove item from inventory" + "\n"
				+ "\t- Cancel\t Delete an order" + "\n"
				+ "\t=====\n"
				+ "\t- Exit\t\t Exit Application\n" 
				+ "==================================================\n";
		System.out.println(menuMsg + "What do you want to do next?");
		return scn.nextLine().toLowerCase();
	}
}
