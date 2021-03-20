package model;

public class Client {
	
	private String name;
	private String surname;
	private int ID;
	private String address;
	private int phoneNumber;
	private String observations;
	private User userWhoCreated;
	private User lastUserWhoModified;
	private boolean disabled;
	
	public Client (String name, String surname, int ID, String address, int phoneNumber, String observations, User user) {
		this.name = name;
		this.surname = surname;
		this.ID = ID;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.observations = observations;
		userWhoCreated = user;
		lastUserWhoModified = user;
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

	public void setID(int iD) {
		ID = iD;
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

	public User getUserWhoCreated() {
		return userWhoCreated;
	}

	public void setUserWhoCreated(User userWhoCreated) {
		this.userWhoCreated = userWhoCreated;
	}

	public User getLastUserWhoModified() {
		return lastUserWhoModified;
	}

	public void setLastUserWhoModified(User lastUserWhoModified) {
		this.lastUserWhoModified = lastUserWhoModified;
	}

	public boolean isDisabled() {
		return disabled;
	}

	public void setDisabled(boolean disabled) {
		this.disabled = disabled;
	}
	
	@Override
	public String toString() {
		return "Client [name=" + name + ", surname=" + surname + ", ID=" + ID + ", address=" + address
				+ ", phoneNumber=" + phoneNumber + ", observations=" + observations + ", userWhoCreated="
				+ userWhoCreated + ", lastUserWhoModified=" + lastUserWhoModified + ", disabled=" + disabled + "]\n";
	}
	
}
