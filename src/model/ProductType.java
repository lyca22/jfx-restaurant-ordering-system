package model;

import java.io.Serializable;

public class ProductType implements Comparable<ProductType>, Serializable{
	
	private static final long serialVersionUID = 1;
	
	private String name;
	private User userWhoCreated;
	private User lastUserWhoModified;
	private boolean disabled;
	
	public ProductType(String name, User user) {
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
	public int compareTo(ProductType o) {
		return name.compareTo(o.getName());
	}

}
