package menus;

import java.util.ArrayList;

import objects.Group;
import users.Monitor;
import users.User;

public class Tables {

	protected ArrayList<User> users;
	protected ArrayList<Monitor> monitors;
	protected ArrayList<Group> classes;
	
	public Tables(ArrayList<User> users, ArrayList<Group> classes) {
		
		monitors = new ArrayList<Monitor>();
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getType().equals("monitor")) {
				monitors.add((Monitor) users.get(i));
			}
		}
		this.classes = classes;
	}
	
	public void showMonitors() {
		System.out.println("Indice\t|\tMonitor\t|\tSchool\t|\tTheme\t|\n");
		for(int i = 0; i < monitors.size(); i++) {
			System.out.println(i+"\t|\t" +monitors.get(i).getUsername()+
					"\t|\t" +monitors.get(i).getSchool()+
					"\t|\t" +monitors.get(i).getTheme()+ "\t|\n");
		}
	}
	
	public void showClasses() {
		System.out.println("Indice\t|\tMonitor\t|\tSchool\t|\tTheme\t|\n");
		for(int i = 0; i < classes.size(); i++) {
			System.out.println(i+1 +"\t|\t" +classes.get(i).getId()
					+ "\t|\t" +classes.get(i).getSchool()
					+ "\t|\t" +classes.get(i).getTheme()+ "\t|\n");
		}
	}
	
	public ArrayList<Monitor> getMonitors(){
		return monitors;
	}
	
	public ArrayList<Group> getClasses(){
		return classes;
	}
}
