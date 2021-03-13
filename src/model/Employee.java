package model;

public class Employee {
	private String name;
	private String surname;
	private int iD;
	
	public Employee(String name, String surname, int iD) {
		this.name = name;
		this.surname = surname;
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}
	
	

}
