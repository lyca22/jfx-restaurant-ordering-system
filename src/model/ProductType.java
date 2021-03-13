package model;

public class ProductType {
	
	private String name;
	private User userWhoCreatedPT;
	private User userWhoModifiedPT;
	
	public ProductType(String name, User userWhoCreatedPT, User userWhoModifiedPT) {
		this.name = name;
		this.userWhoCreatedPT = userWhoCreatedPT;
		this.userWhoModifiedPT = userWhoModifiedPT;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUserWhoCreatedPT() {
		return userWhoCreatedPT;
	}
	public void setUserWhoCreatedPT(User userWhoCreatedPT) {
		this.userWhoCreatedPT = userWhoCreatedPT;
	}
	public User getUserWhoModifiedPT() {
		return userWhoModifiedPT;
	}
	public void setUserWhoModifiedPT(User userWhoModifiedPT) {
		this.userWhoModifiedPT = userWhoModifiedPT;
	}
	
	

}
