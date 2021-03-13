package model;

public class Client {
	
	
	private String name;
	private String surname;
	private int iD;
	private String address;
	private int phoneNumber;
	private String observations;
	private User user;
	
	public Client (String name, String surname, int iD, String address, int phoneNumber, String observations, User user) {
		this.name = name;
		this.surname = surname;
		this.iD = iD;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.observations = observations;
		this.user = user;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	

}
