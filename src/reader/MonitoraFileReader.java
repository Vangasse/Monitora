package reader;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

import objects.Message;
import objects.Group;
import users.*;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.simple.parser.JSONParser;
import java.util.Map;

public class MonitoraFileReader {

	protected ArrayList<User> users;
	protected ArrayList<Message> messages;
	protected ArrayList<Group> classes;

	JSONArray json;
	JSONParser parser;
	FileReader file;

	public MonitoraFileReader() {
		
		users = new ArrayList<User>();
		messages = new ArrayList<Message>();
		classes = new ArrayList<Group>();
		
		try {
			
			file = new FileReader("data.json");
			
			parser = new JSONParser();
	
			json = new JSONArray(parser.parse(file));
	
			JSONArray jUsers = json.getJSONArray(0);
			JSONArray jGroups = json.getJSONArray(1);
			JSONArray jMessages = json.getJSONArray(2);
	
			int i;
			
			JSONObject jUser;
			
			int id;
			String username;
			String password;
			int cpf;
			String school;
			String type;
			String theme;
			
			Monitor monitor;
			Student student;
			Professor professor;
			
			HashMap<Integer, User> mapUsers = new HashMap<Integer, User>();
	
			for(i = 0; i < jUsers.length(); i++){
				jUser = jUsers.getJSONObject(i);
	
				id = jUser.getInt("id");
				username = jUser.getString("username");
				password = jUser.getString("password");
				cpf = jUser.getInt("cpf");
				school = jUser.getString("school");
				type = jUser.getString("type");
				
				if(type.equals("monitor")) {
					theme = jUser.getString("theme");
					monitor = new Monitor(id, username, password, cpf, school, type, theme);
					users.add(monitor);
					mapUsers.put(id, monitor);
				}
				else if(type.equals("student")){
					student = new Student(id, username, password, cpf, school, type);
					users.add(student);
					mapUsers.put(id, student);
				}
				else if(type.equals("professor")){
					professor = new Professor(id, username, password, cpf, school, type);
					users.add(professor);
					mapUsers.put(id, professor);
				}
			}
			
			JSONObject jGroup;
			ArrayList<User> groupUsers = new ArrayList<User>();
			JSONArray jGroupUserIds;
			String stringId;
			//String password;
			//String school;
			//String theme;
			
			Group group;
			
			int j;
			
			//PREPAREI O ARRAY DE USUARIOS, UM DOS ATTRIB DOS GRUPOS
			for(i = 0; i < jGroups.length(); i++) {
				jGroup = jGroups.getJSONObject(i);
				
				jGroupUserIds = jGroup.getJSONArray("users");
				for(j = 0; j < jGroupUserIds.length(); j++) {
					groupUsers.add(mapUsers.get(jGroupUserIds.getInt(j)));
				}
				stringId = jGroup.getString("id");
				password = jGroup.getString("password");
				school = jGroup.getString("school");
				theme = jGroup.getString("theme");
				
				group = new Group(groupUsers, stringId, password, school, theme);
				
				classes.add(group);
				
			}
			
			JSONObject jMessage;
			User sender;
			User recipient;
			String message;
			
			Message objMessage;
			
			for(i = 0; i < jMessages.length(); i++) {
				jMessage = jMessages.getJSONObject(i);
				
				sender = mapUsers.get(jMessage.getInt("sender"));
				recipient = mapUsers.get(jMessage.getInt("recipient"));
				message = jMessage.getString("message");
				
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
