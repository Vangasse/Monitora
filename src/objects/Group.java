package objects;

import java.util.ArrayList;

import users.User;

public class Group {

	private ArrayList<User> users;
	private String id;
	private String password;
	private String school;
	private String theme;
	
	public Group(ArrayList<User> users, String id, String password, String school, String theme) {
		this.users = users;
		this.id = id;
		this.password = password;
		this.school = school;
		this.theme = theme;
	}

	public String getId() {
		return id;
	}

	public String getSchool() {
		return school;
	}

	public String getTheme() {
		return theme;
	}

	public ArrayList<User> getUsers() {
		return users;
	}

	public String getPassword() {
		return password;
	}
	
}
