package users;

public abstract class User {
	protected int id;
	protected String username;
	protected String password;
	protected int cpf;
	protected String school;
	
	public User(int id, String username, String password, int cpf, String school) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.school = school;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	
}
