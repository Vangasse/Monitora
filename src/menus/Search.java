package menus;

import objects.Group;
import users.User;

import java.util.ArrayList;
import java.util.Scanner;

import users.Monitor;

public class Search {

	private String keyWord;
	private Scanner strScanner;
	
	public Search() {
		strScanner =  new Scanner(System.in);
	}
	
	public ArrayList<Monitor> monitorSearch(ArrayList<Monitor> monitors) {
		System.out.println("Search for word:>>");
		keyWord = strScanner.nextLine();
		
		for(int i = 0; i < monitors.size(); i++) {
			if(!monitors.get(i).getUsername().contains(keyWord) 
					&& !monitors.get(i).getSchool().contains(keyWord)
					&& !monitors.get(i).getTheme().contains(keyWord))
				monitors.remove(i);
		}
		for(int i = 0; i < monitors.size(); i++) {
			System.out.println(i+"\t|\t" +monitors.get(i).getUsername()+
					"\t|\t" +monitors.get(i).getSchool()+
					"\t|\t" +monitors.get(i).getTheme()+ "\t|\n");
		}
		return monitors;
	}
	
	public ArrayList<Group> groupSearch(ArrayList<Group> classes) {
		System.out.println("Search for word:>>");
		keyWord = strScanner.nextLine();
		
		for(int i = 0; i < classes.size(); i++) {
			if(!classes.get(i).getId().contains(keyWord) 
					&& !classes.get(i).getSchool().contains(keyWord)
					&& !classes.get(i).getTheme().contains(keyWord))
				classes.remove(i);
		}
		System.out.println("Indice\t|\tMonitor\t|\tSchool\t|\tTheme\t|\n");
		for(int i = 0; i < classes.size(); i++) {
			System.out.println(i+1 +"\t|\t" +classes.get(i).getId()
					+ "\t|\t" +classes.get(i).getSchool()
					+ "\t|\t" +classes.get(i).getTheme()+ "\t|\n");
		}
		return classes;
	}
}
