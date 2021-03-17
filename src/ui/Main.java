package ui;

import model.Restaurant;

//import javafx.application.Application;
//import javafx.stage.Stage;

public class Main {

	//@Override
	//public void start(Stage primaryStage) throws Exception {

	//}

	public static void main(String[] args) {
		Restaurant restaurant = new Restaurant("casa dorada","cr 9");
		restaurant.addClient("Laura", "Martinez", 12, "cr 4", 234, "dfgg", null);
		restaurant.addClient("Raul", "Arango", 12, "cr 4", 234, "dfgg", null);
		restaurant.addClient("David", "Bedoya", 12, "cr 4", 234, "dfgg", null);
		System.out.println(restaurant.getClients().toString());
	}

}
