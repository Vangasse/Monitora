package users;

public class Monitor extends User{
	
	protected String theme;

	public Monitor(int id, String username, String password, String cpf, String school, String type, String theme) {
		super(id, username, password, cpf, school, type);
		this.theme = theme;
		// TODO Auto-generated constructor stub
	}
	
	public String getTheme() {
		return theme;
	}

}
