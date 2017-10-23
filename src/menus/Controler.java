package menus;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Message;

import objects.Group;
import users.User;
import users.Monitor;

public class Controler {

	private Scanner strScanner;
	private Scanner intScanner;
	
	protected Login ctrLogin;
	protected Tables ctrTables;
	protected Messages messages;
	protected Search searchTool;
	
	protected User sessionUser;
	
	public Controler(ArrayList<User> users, ArrayList<Message> messages, ArrayList<Group> classes) {
		
		strScanner = new Scanner(System.in);
		intScanner = new Scanner(System.in);
		
		this.ctrLogin = new Login(users);
		this.ctrTables = new Tables(users, classes);
		this.messages = new Messages(messages);
		
		this.searchTool = new Search();
		
		this.sessionUser = null;
	}
	
	public boolean login() {
		sessionUser = ctrLogin.attemptLogin();
		while( sessionUser == null) {
			System.out.println("Try again? Y/n:>>");
			String quitCondition = strScanner.nextLine();
			if(quitCondition.equals("n") || quitCondition.equals("N"))
				return false;
			sessionUser = ctrLogin.attemptLogin();
		}
		return true;
	}
	
	public void start() {
		System.out.println("Go to:\n[1] - Tables;\n[2] - Search;\n"
				+ "[3] - My new messages;\n[4] - Write message;\n[0] - Sair.\n");
		int select = intScanner.nextInt();
		switch(select) {
		case 0:
			return;
		case 1:
			this.menuTables();
			break;
		case 2:
			this.menuSearch();
			break;
		case 3:
			messages.getMessages(sessionUser);
			break;
		default:
			return;
		}
	}
	
	public void menuTables() {
		System.out.println("Tables:\n[1] - Monitors;\n[2] - Groups;\n[0] - Return.\n");
		int select = intScanner.nextInt();
		switch(select) {
		case 0:
			this.start();
			break;
		case 1:
			this.ctrTables.showMonitors();
			break;
		case 2:
			this.ctrTables.showClasses();
			break;
		}
	}
	
	public void menuSearch() {
		System.out.println("Search for:\n[1] - Monitors;\n[2] - Groups;\n[0] - Return.\n");
		int select = intScanner.nextInt();
		switch(select) {
		case 0:
			this.start();
			break;
		case 1:
			innerSearch(searchTool.monitorSearch(ctrTables.getMonitors()));
			break;
		case 2:
			innerSearchC(searchTool.groupSearch(ctrTables.getClasses()));
			break;
		}
	}
	
	public void innerSearch(ArrayList<Monitor> monitors) {
		System.out.println("Keep searching? Y/n:>>");
		String select = strScanner.nextLine();
		if(select.equals("N") || select.equals("n"))
			return;
		searchTool.groupSearch(ctrTables.getClasses());
	}
	
	public void innerSearchC(ArrayList<Group> classes) {
		System.out.println("Keep searching? Y/n:>>");
		String select = strScanner.nextLine();
		if(select.equals("N") || select.equals("n"))
			return;
		searchTool.groupSearch(ctrTables.getClasses());
	}
}
