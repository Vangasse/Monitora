package objects;

import users.User;

public class Message {

	protected User sender;
	protected User recipient;
	protected String message;
	
	public Message(User sender, User recipient, String message) {
		this.sender = sender;
		this.recipient = recipient;
		this.message = message;
	}
	
	public User getSender() {
		return sender;
	}
	public User getRecipient() {
		return recipient;
	}
	public String getMessage() {
		return message;
	}
}
