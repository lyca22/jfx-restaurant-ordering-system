package model;

import java.util.List;

public class Product {

	private String name;
	private ProductType productType;
	private List<Ingredient> ingredients;
	private ProductSize productSize;
	private int price;
	
	public Product(String name, ProductType productType, List<Ingredient> ingredients, ProductSize productSize, int price) {
		this.name = name;
		this.productType = productType;
		this.ingredients = ingredients;
		this.productSize = productSize;
		this.price = price;
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
	
	
	
}
