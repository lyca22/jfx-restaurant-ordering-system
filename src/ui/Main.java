package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Restaurant;

public class Main extends Application {

	private Restaurant restaurant;
	private RestaurantGUI restaurantGUI;
	
	public Main() {
		restaurant = new Restaurant("La Casa Dorada", "Cali, Valle del Cauca");
		restaurantGUI = new RestaurantGUI(restaurant);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("main-pane.fxml"));
		fxmlLoader.setController(restaurantGUI);
		Parent root = fxmlLoader.load();
		Scene scene = new Scene(root);
		primaryStage.setScene(scene);
		primaryStage.setTitle("La Casa Dorada");
		primaryStage.show();
		restaurantGUI.loadScreen("login.fxml");
	}

	public static void main(String[] args) {
		launch(args);
	}

}
