package menus;

import java.util.ArrayList;
import java.util.Scanner;

import objects.Group;
import objects.Message;
import users.User;

public class Messages {

	protected ArrayList<Message> messages;
	
	protected Scanner strScanner;
	
	public Messages(ArrayList<Message> messages) {
		this.messages = messages;
		
		strScanner = new Scanner(System.in);
	}
	
	public void getMessages(User sessionUser) {
		System.out.println("Indice\t|\tSender\t|\tMessage\n");
		int aux = 0;
		for(int i = 0; i < messages.size(); i++) {
			if(sessionUser.getUsername().equals(messages.get(i).getRecipient().getUsername())) {
				System.out.println(i+aux+"\t|\t" +messages.get(i).getSender().getUsername()
						+ "\t|\t" +messages.get(i).getMessage()+ "\t|\n");
				messages.remove(i);
				i--;
				aux++;
			}
		}
	}
	
	public void writeMessage(ArrayList<User> users, User sessionUser) {
		System.out.println("Insert recipient:>>");
		String recipientName = strScanner.nextLine();
		
		for(int i = 0; i < users.size(); i++) {
			if(users.get(i).getUsername().equals(recipientName)) {
				User recipient = users.get(i);
				System.out.println("Write message:>>");
				String message = strScanner.nextLine();
				messages.add(new Message(sessionUser, recipient, message));
				return;
			}
		}
	}
	
	public void groupBroadcast(ArrayList<Group> classes, User sessionUser) {
		System.out.println("Insert group:>>");
		String groupId = strScanner.nextLine();
		
		for(int i = 0; i < classes.size(); i++) {
			if(classes.get(i).getId().equals(groupId)) {
				System.out.println("Write message:>>");
				String message = strScanner.nextLine();
				for(int j = 0; j < classes.get(i).getUsers().size(); j++) {
					User recipient = classes.get(i).getUsers().get(j);
					messages.add(new Message(sessionUser, recipient, message));
					return;
				}
			}
		}
	}
}
