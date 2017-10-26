package fileManager;


//import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import objects.Message;
import objects.Group;
import users.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Map;

public class MonitoraFileReader {

	protected ArrayList<User> users;
	protected ArrayList<Message> messages;
	protected ArrayList<Group> classes;

	JSONArray json;
	//JSONObject jsonObj;
	JSONParser parser;
	FileReader file;

	public MonitoraFileReader() {
		
		users = new ArrayList<User>();
		messages = new ArrayList<Message>();
		classes = new ArrayList<Group>();
		
		try {
			
			file = new FileReader("data.json");
			//System.out.println(new File(".").getAbsoluteFile());
			
			parser = new JSONParser();
			
			//jsonObj = (JSONObject) parser.parse(file);
	
			json = (JSONArray) parser.parse(file);
	
			JSONArray jUsers = (JSONArray) json.get(0);
			JSONArray jGroups = (JSONArray) json.get(1);
			JSONArray jMessages = (JSONArray) json.get(2);
	
			int i;
			
			JSONObject jUser;
			
			String id;
			String username;
			String password;
			String cpf;
			String school;
			String type;
			String theme;
			
			Monitor monitor;
			Student student;
			Professor professor;
			
			HashMap<String, User> mapUsers = new HashMap<String, User>();
	
			for(i = 0; i < jUsers.size(); i++){
				jUser = (JSONObject) jUsers.get(i);
	
				id = (String) jUser.get("id");
				username = (String) jUser.get("username");
				password = (String) jUser.get("password");
				cpf = (String) jUser.get("cpf");
				school = (String) jUser.get("school");
				type = (String) jUser.get("type");
				
				if(type.equals("monitor")) {
					theme = (String) jUser.get("theme");
					monitor = new Monitor(Integer.parseInt(id), username, password, cpf, school, type, theme);
					users.add(monitor);
					mapUsers.put(id, monitor);
				}
				else if(type.equals("student")){
					student = new Student(Integer.parseInt(id), username, password, cpf, school, type);
					users.add(student);
					mapUsers.put(id, student);
				}
				else if(type.equals("professor")){
					professor = new Professor(Integer.parseInt(id), username, password, cpf, school, type);
					users.add(professor);
					mapUsers.put(id, professor);
				}
			}
			
			JSONObject jGroup;
			ArrayList<User> groupUsers = new ArrayList<User>();
			JSONArray jGroupUserIds;
			String groupId;
			//String password;
			//String school;
			//String theme;
			
			Group group;
			
			int j;
			
			for(i = 0; i < jGroups.size(); i++) {
				jGroup = (JSONObject) jGroups.get(i);
				
				jGroupUserIds = (JSONArray) jGroup.get("users");
				for(j = 0; j < jGroupUserIds.size(); j++) {
					groupUsers.add(mapUsers.get((String) jGroupUserIds.get(j)));
				}
				groupId = (String) jGroup.get("id");
				password = (String) jGroup.get("password");
				school = (String) jGroup.get("school");
				theme = (String) jGroup.get("theme");
				
				group = new Group(groupUsers, groupId, password, school, theme);
				
				classes.add(group);
				
			}
			
			JSONObject jMessage;
			User sender;
			User recipient;
			String message;
			
			Message objMessage;
			
			for(i = 0; i < jMessages.size(); i++) {
				jMessage = (JSONObject) jMessages.get(i);
				
				sender = mapUsers.get((String) jMessage.get("sender"));
				recipient = mapUsers.get((String) jMessage.get("recipient"));
				message = (String) jMessage.get("message");
				
				objMessage = new Message(sender, recipient, message);
				
				messages.add(objMessage);
			}
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
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
