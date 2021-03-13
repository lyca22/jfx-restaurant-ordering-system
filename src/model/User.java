package model;

public class User extends Employee {

	private String username;
	private String password;
	
	public User(String name, String surname, int iD, String username, String password) {
		super(name, surname, iD);
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
}
