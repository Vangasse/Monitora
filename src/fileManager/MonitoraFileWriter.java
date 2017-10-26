package fileManager;

import users.*;

import java.io.FileWriter;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import objects.*;

public class MonitoraFileWriter {
	
	protected ArrayList<User> users;
	protected ArrayList<Message> messages;
	protected ArrayList<Group> classes;

	public MonitoraFileWriter(ArrayList<User> users, ArrayList<Message> messages, ArrayList<Group> classes) {
		this.users = users;
		this.messages = messages;
		this.classes = classes;
	}
	
	public void terminate() {
		JSONArray json = new JSONArray();
		JSONObject obj = new JSONObject();
		
		JSONArray groupUsers = new JSONArray();
		
		JSONArray jUsers = new JSONArray();
		JSONArray jMessages = new JSONArray();
		JSONArray jGroups = new JSONArray();
		
		int i;
		
		try {
			for(i = 0; i < users.size(); i++) {
				obj.put("id", String.valueOf(users.get(i).getId()));
				obj.put("username", users.get(i).getUsername());
				obj.put("password", users.get(i).getPassword());
				obj.put("cpf", users.get(i).getCpf());
				obj.put("school", users.get(i).getSchool());
				obj.put("type", users.get(i).getType());
				
				if(users.get(i).getType().equals("monitor")) {
					obj.put("theme", ((Monitor) users.get(i)).getTheme());
				}
				else {
					obj.put("theme", "");
				}
				jUsers.add(obj);
				obj = new JSONObject();
			}
			for(i = 0; i < classes.size(); i++) {
				for(int j = 0; j < classes.get(i).getUsers().size(); j++) {
					groupUsers.add(String.valueOf(classes.get(i).getUsers().get(j).getId()));
				}
				obj.put("users", groupUsers);
				obj.put("id", classes.get(i).getId());
				obj.put("password", classes.get(i).getPassword());
				obj.put("school", classes.get(i).getSchool());
				obj.put("theme", classes.get(i).getTheme());

				jGroups.add(obj);
				obj = new JSONObject();
			}
			for(i = 0; i < messages.size(); i++) {
				obj.put("sender", String.valueOf(messages.get(i).getSender().getId()));
				obj.put("recipient", String.valueOf(messages.get(i).getRecipient().getId()));
				obj.put("message", messages.get(i).getMessage());
				
				jMessages.add(obj);
				obj = new JSONObject();
			}
			
			json.add(jUsers);
			json.add(jGroups);
			json.add(jMessages);
			
			System.out.println(json.toString());
			
			FileWriter file = new FileWriter("data.json");
			file.write(json.toString());
			file.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
