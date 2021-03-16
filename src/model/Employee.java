package model;

public class Employee implements Comparable<Employee>{
	
	private String name;
	private String surname;
	private int ID;
	private boolean disabled;
	
	public Employee(String name, String surname, int ID) {
		this.name = name;
		this.surname = surname;
		this.ID = ID;
		disabled = false;
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

	public int getID() {
		return ID;
	}

	public void setID(int ID) {
		this.ID = ID;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}

	@Override
	public int compareTo(Employee o) {
		return name.compareTo(o.getName());
	}
	
}
