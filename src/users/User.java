package users;

public abstract class User {
	protected int id;
	protected String username;
	protected String password;
	protected int cpf;
	protected String school;
	protected String type;
	
	public User(int id, String username, String password, int cpf, String school, String type) {
		this.id = id;
		this.username = username;
		this.password = password;
		this.cpf = cpf;
		this.school = school;
		this.type = type;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
	public String getType() {
		return type;
	}
	
	public String getSchool() {
		return school;
	}
	
}
