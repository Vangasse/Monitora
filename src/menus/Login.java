package menus;

import java.util.Scanner;

public class Login {
	
	private Scanner strScanner =  new Scanner(System.in);

	public Login(/*Receber lista de usuários*/) {
		
		System.out.println("Username:>>");
		String user = strScanner.nextLine();
		
		System.out.println("Password:>>");
		String password = strScanner.nextLine();
	}
}
