package users;

public class Monitor extends User{
	
	protected String theme;

	public Monitor(int id, String username, String password, int cpf, String school, String theme) {
		super(id, username, password, cpf, school);
		this.theme = theme;
		// TODO Auto-generated constructor stub
	}

}
