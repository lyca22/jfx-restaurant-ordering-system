package model;

import java.util.List;

public class Product {

	private String name;
	private ProductType productType;
	private List<Ingredient> ingredients;
	private ProductSize productSize;
	private int price;
	private User userWhoCreated;
	private User lastUserWhoModified;
	private boolean disabled;
	
	public Product(String name, ProductType productType, List<Ingredient> ingredients, ProductSize productSize, int price, User user) {
		this.name = name;
		this.productType = productType;
		this.ingredients = ingredients;
		this.productSize = productSize;
		this.price = price;
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

	public ProductType getProductType() {
		return productType;
	}

	public void setProductType(ProductType productType) {
		this.productType = productType;
	}

	public List<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(List<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public ProductSize getProductSize() {
		return productSize;
	}

	public void setProductSize(ProductSize productSize) {
		this.productSize = productSize;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
		return "Product [name=" + name + ", productType=" + productType + ", ingredients=" + ingredients
				+ ", productSize=" + productSize + ", price=" + price + ", userWhoCreated=" + userWhoCreated
				+ ", lastUserWhoModified=" + lastUserWhoModified + ", disabled=" + disabled + "]\n";
	}

	
	
}
