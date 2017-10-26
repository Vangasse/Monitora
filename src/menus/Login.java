package menus;

import java.util.ArrayList;
import java.util.Scanner;
import users.User;

public class Login {
	
	private ArrayList<User> users;
	private Scanner strScanner;

	public Login(ArrayList<User> users) {
		
		this.users = users;
		
	}
	
	public User attemptLogin() {
		
		strScanner =  new Scanner(System.in);
		
		System.out.println("Username:>>");
		String username = strScanner.nextLine();
		
		System.out.println("Password:>>");
		String password = strScanner.nextLine();

		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(username) && users.get(i).getPassword().equals(password)) {
				return users.get(i);
			}
		}
		System.out.println("Incorrect credentials.\n");
		return null;
	}
}
