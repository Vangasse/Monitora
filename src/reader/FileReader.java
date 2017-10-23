package reader;

import java.util.ArrayList;

import objects.Message;

import objects.Group;
import users.User;

public class FileReader {

	protected ArrayList<User> users;
	protected ArrayList<Message> messages;
	protected ArrayList<Group> classes;
	
	public FileReader() {
		//ABRIR ARQUIVO E REALIZAR INTERPRETAÇÕES
	}
	
	public ArrayList<User> getUsers(){
		return users;	
	}
	
	public ArrayList<Message> getMessages(){
		return messages;	
	}
	
	public ArrayList<Group> getClasses(){
		return classes;	
	}
}
