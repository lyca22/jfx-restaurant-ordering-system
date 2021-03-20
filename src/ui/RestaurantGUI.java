package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Restaurant;

public class RestaurantGUI {

	private Restaurant restaurant;

	//Main pane.

	@FXML
	private GridPane mainPane;

	//Login fields.

	@FXML
	private TextField txtLoginName;

	@FXML
	private PasswordField txtLoginPassword;

	//Register fields.

	@FXML
	private TextField txtRegisterName;

	@FXML
	private TextField txtRegisterSurname;

	@FXML
	private TextField txtRegisterID;

	@FXML
	private TextField txtRegisterUsername;

	@FXML
	private PasswordField txtRegisterPassword;

	//Table pane.

	@FXML
	private GridPane tablePane;

	//Product list.

	@FXML
	private TableView<model.Product> tvProducts;

	@FXML
	private TableColumn<model.Product, String> tcProductName;

	@FXML
	private TableColumn<model.Product, String> tcProductType;

	@FXML
	private TableColumn<model.Product, String> tcProductIngredients;

	@FXML
	private TableColumn<model.Product, String> tcProductSize;

	@FXML
	private TableColumn<model.Product, String> tcProductPrice;

	//Ingredient list.

	@FXML
	private TableView<model.Ingredient> tvIngredients;

	@FXML
	private TableColumn<model.Ingredient, String> tcIngredientName;

	//Client list.

	@FXML
	private TableView<model.Client> tvClients;

	@FXML
	private TableColumn<model.Client, String> tcClientName;

	@FXML
	private TableColumn<model.Client, String> tcClientSurnames;

	@FXML
	private TableColumn<model.Client, String> tcClientID;

	@FXML
	private TableColumn<model.Client, String> tcClientAddress;

	@FXML
	private TableColumn<model.Client, String> tcClientPhone;

	@FXML
	private TableColumn<model.Client, String> tcClientObservations;

	//Employee list.

	@FXML
	private TableView<model.Employee> tvEmployees;

	@FXML
	private TableColumn<model.Employee, String> tcEmployeeName;

	@FXML
	private TableColumn<model.Employee, String> tcEmployeeSurname;

	@FXML
	private TableColumn<model.Employee, String> tcEmployeeID;

	//User list.

	@FXML
	private TableView<model.User> tvUsers;

	@FXML
	private TableColumn<model.Employee, String> tcUserName;

	@FXML
	private TableColumn<model.Employee, String> tcUserSurname;

	@FXML
	private TableColumn<model.Employee, String> tcUserID;

	@FXML
	private TableColumn<model.Employee, String> tcUserUsername;

	//Order list.

	@FXML
	private TableView<model.Order> tvOrders;

	@FXML
	private TableColumn<model.Order, String> tcOrderCode;

	@FXML
	private TableColumn<model.Order, String> tcOrderStatus;

	@FXML
	private TableColumn<model.Order, String> tcOrderProducts;

	@FXML
	private TableColumn<model.Order, String> tcOrderQuantity;

	@FXML
	private TableColumn<model.Order, String> tcOrderClient;

	@FXML
	private TableColumn<model.Order, String> tcOrderEmployee;

	@FXML
	private TableColumn<model.Order, String> tcOrderDate;

	@FXML
	private TableColumn<model.Order, String> tcOrderObservations;

	@FXML
	Dialog<String> dialog;

	@FXML
	private TextField txtIngredientName;

	public RestaurantGUI(Restaurant restaurant) {
		this.setRestaurant(restaurant);
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void loadScreen(String resource) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		fxmlLoader.setController(this);
		Parent loginPane;
		try {
			loginPane = fxmlLoader.load();
			mainPane.getChildren().clear();
			mainPane.add(loginPane, 0, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void loadTable(String resource) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		fxmlLoader.setController(this);
		Parent loginPane;
		try {
			loginPane = fxmlLoader.load();
			tablePane.getChildren().clear();
			tablePane.add(loginPane, 0, 0);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initializeProductsTableView() {
		ObservableList<model.Product> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getProducts());
		tvProducts.setItems(observableList);
		tcProductName.setCellValueFactory(new PropertyValueFactory<model.Product, String>("name"));
		tcProductType.setCellValueFactory(new PropertyValueFactory<model.Product, String>("productType"));
		tcProductIngredients.setCellValueFactory(new PropertyValueFactory<model.Product, String>("ingredients"));
		tcProductSize.setCellValueFactory(new PropertyValueFactory<model.Product, String>("productSize"));
		tcProductPrice.setCellValueFactory(new PropertyValueFactory<model.Product, String>("price"));

	}

	private void initializeIngredientsTableView() {
		ObservableList<model.Ingredient> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getIngredients());
		tvIngredients.setItems(observableList);
		tcIngredientName.setCellValueFactory(new PropertyValueFactory<model.Ingredient, String>("name"));
	}

	private void initializeClientsTableView() {
		ObservableList<model.Client> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getClients());
		tvClients.setItems(observableList);
		tcClientName.setCellValueFactory(new PropertyValueFactory<model.Client, String>("name"));
		tcClientSurnames.setCellValueFactory(new PropertyValueFactory<model.Client, String>("surname"));
		tcClientID.setCellValueFactory(new PropertyValueFactory<model.Client, String>("ID"));
		tcClientAddress.setCellValueFactory(new PropertyValueFactory<model.Client, String>("address"));
		tcClientPhone.setCellValueFactory(new PropertyValueFactory<model.Client, String>("phoneNumber"));
		tcClientObservations.setCellValueFactory(new PropertyValueFactory<model.Client, String>("observations"));
	}

	private void initializeEmployeeTableView() {
		ObservableList<model.Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployees());
		tvEmployees.setItems(observableList);
		tcEmployeeName.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("name"));
		tcEmployeeSurname.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("surname"));
		tcEmployeeID.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("ID"));
	}

	private void initializeUsersTableView() {
		ObservableList<model.User> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getUsers());
		tvUsers.setItems(observableList);
		tcUserName.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("name"));
		tcUserSurname.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("surname"));
		tcUserID.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("ID"));
		tcUserUsername.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("username"));
	}

	private void initializeOrdersTableView() {
		ObservableList<model.Order> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getOrders());
		tvOrders.setItems(observableList);
		tcOrderCode.setCellValueFactory(new PropertyValueFactory<model.Order, String>("orderCode"));
		tcOrderStatus.setCellValueFactory(new PropertyValueFactory<model.Order, String>("orderState"));
		tcOrderProducts.setCellValueFactory(new PropertyValueFactory<model.Order, String>("products"));
		tcOrderQuantity.setCellValueFactory(new PropertyValueFactory<model.Order, String>("quantity"));
		tcOrderClient.setCellValueFactory(new PropertyValueFactory<model.Order, String>("client"));
		tcOrderEmployee.setCellValueFactory(new PropertyValueFactory<model.Order, String>("employeeWhoDelivered"));
		tcOrderDate.setCellValueFactory(new PropertyValueFactory<model.Order, String>("date"));
		tcOrderObservations.setCellValueFactory(new PropertyValueFactory<model.Order, String>("observations"));
	}

	public void logIn() {
		String username = txtLoginName.getText();
		String password = txtLoginPassword.getText();
		if(restaurant.logIn(username, password)) {
			loadScreen("table-view.fxml");
		}
	}

	public void signUp() {
		loadScreen("register.fxml");
	}

	public void createAccount() {
		try {
			boolean wroteName = !txtRegisterName.getText().isEmpty();
			boolean wroteSurname = !txtRegisterSurname.getText().isEmpty();
			boolean wroteID = !txtRegisterID.getText().isEmpty();
			boolean wroteUsername = !txtRegisterUsername.getText().isEmpty();
			boolean wrotePassword = !txtRegisterPassword.getText().isEmpty();
			String name = txtRegisterName.getText();
			String surname = txtRegisterSurname.getText();
			int ID = Integer.parseInt(txtRegisterID.getText());
			String username = txtRegisterUsername.getText();
			String password = txtRegisterPassword.getText();
			if(wroteName && wroteSurname && wroteID && wroteUsername && wrotePassword) {
				restaurant.addUser(name, surname, ID, username, password);
			}
		} catch(NumberFormatException nfe) {
			System.out.println("nfe");
		}
	}

	public void signIn() {
		loadScreen("login.fxml");
	}

	public void logOut() {
		loadScreen("login.fxml");
	}

	public void viewProducts() {
		loadTable("products-table-view.fxml");
		initializeProductsTableView();
	}

	public void viewIngredients() {
		loadTable("ingredient-table-view.fxml");
		initializeIngredientsTableView();
	}

	public void viewClients() {
		loadTable("client-table-view.fxml");
		initializeClientsTableView();
	}

	public void viewEmployees() {
		loadTable("employee-table-view.fxml");
		initializeEmployeeTableView();
	}

	public void viewUsers() {
		loadTable("user-table-view.fxml");
		initializeUsersTableView();
	}

	public void viewOrders() {
		loadTable("order-table-view.fxml");
		initializeOrdersTableView();
	}

	public void addProducts() {
		
	}

	public void addIngredients() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("add-ingredient.fxml"));
		fxmlLoader.setController(this);
		dialog = new Dialog<String>();
		ButtonType acceptButtonType = new ButtonType("Aceptar", ButtonData.APPLY);
		dialog.getDialogPane().getButtonTypes().addAll(acceptButtonType, ButtonType.CANCEL);
		Parent root;
		try {
			root = fxmlLoader.load();
			dialog.getDialogPane().setContent(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String ingredientName = txtIngredientName.getText();
				restaurant.addIngredient(ingredientName, restaurant.getActualUser());
				System.out.println(restaurant.getIngredients().toString());
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addClients() {

	}

	public void addEmployees() {

	}

	public void addUsers() {

	}

	public void addOrders() {

	}

	public void importProducts() {

	}

	public void importClients() {

	}

	public void importOrders() {

	}

	public void exportProducts() {

	}

	public void exportEmployees() {

	}

	public void exportOrders() {

	}

}
