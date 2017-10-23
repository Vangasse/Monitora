package menus;

import java.util.ArrayList;
import java.util.Scanner;

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
		for(int i = 0; i < messages.size(); i++) {
			if(sessionUser.getUsername().equals(messages.get(i).getRecipient())) {
				System.out.println(i+"\t|\t" +messages.get(i).getSender()
						+ "\t|\t" +messages.get(i).getMessage()+ "\t|\n");
				messages.remove(i);
				i--;
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
}
