package model;

public class Ingredient implements Comparable<Ingredient>{

	private String name;
	private User userWhoCreated;
	private User lastUserWhoModified;
	private boolean disabled;

	public Ingredient(String name, User user) {
		this.name = name;
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
	public int compareTo(Ingredient o) {
		return name.compareTo(o.getName());
	}

	@Override
	public String toString() {
		return "Ingredient [name=" + name + ", userWhoCreated=" + userWhoCreated + ", lastUserWhoModified="
				+ lastUserWhoModified + ", disabled=" + disabled + "]\n";
	}
	
	
	
}
