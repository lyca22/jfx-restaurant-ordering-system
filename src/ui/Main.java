package ui;

import model.ProductType;
import model.Restaurant;
import model.User;

import java.util.ArrayList;

import model.*;

//import javafx.application.Application;
//import javafx.stage.Stage;

public class Main {
	

	//@Override
	//public void start(Stage primaryStage) throws Exception {

	//}

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant("casa dorada","cr 9");
		/*restaurant.addClient("Laura", "Arango", 12, "cr 4", 234, "dfgg", null);
		restaurant.addClient("Raul", "Arango", 12, "cr 4", 234, "dfgg", null);
		restaurant.addClient("David", "Bedoya", 12, "cr 4", 234, "dfgg", null);
		System.out.println(restaurant.getClients().toString());*/
		//restaurant.addUser("Ariel", "Martinez", 123, "ariel12", "asd");
		User user = new User("Ariel", "Martinez", 123, "ariel12", "asd");
		restaurant.addIngredient("zanahoria",user);
		restaurant.addIngredient("papa",user);
		restaurant.addIngredient("tomate",user);
		restaurant.addIngredient("arroz",user);
		System.out.println(restaurant.getIngredients().toString());
		
		ProductType productType = new ProductType("bebida", user);
		ArrayList<Ingredient> ingredient = new ArrayList<>();
		restaurant.addProduct("pizza", productType, ingredient, ProductSize.Meal_Box_For_One, 1000, user);
		restaurant.addProduct("gaseosa", productType, ingredient, ProductSize.Meal_Box_For_One, 2500, user);
		restaurant.addProduct("papas", productType, ingredient, ProductSize.Meal_Box_For_One, 500, user);
		restaurant.addProduct("sushi", productType, ingredient, ProductSize.Meal_Box_For_One, 5000, user);
		System.out.println(restaurant.getProducts().toString());
	}

}
