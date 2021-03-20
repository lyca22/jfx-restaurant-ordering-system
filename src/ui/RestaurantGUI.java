package ui;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import model.Restaurant;
import model.User;

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

	public RestaurantGUI(Restaurant restaurant) {
		this.setRestaurant(restaurant);
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
	private void initializeIngredientsTableView() {
		ObservableList<model.Ingredient> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getIngredients());
		tvIngredients.setItems(observableList);
		tcIngredientName.setCellValueFactory(new PropertyValueFactory<model.Ingredient, String>("name"));
	}

	@SuppressWarnings("unused")
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

	@SuppressWarnings("unused")
	private void initializeEmployeeTableView() {
		ObservableList<model.Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployees());
		tvEmployees.setItems(observableList);
		tcEmployeeName.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("name"));
		tcEmployeeSurname.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("surname"));
		tcEmployeeID.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("ID"));
	}

	@SuppressWarnings("unused")
	private void initializeUsersTableView() {
		ObservableList<model.User> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getUsers());
		tvUsers.setItems(observableList);
		tcUserName.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("name"));
		tcUserSurname.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("surname"));
		tcUserID.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("ID"));
		tcUserUsername.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("username"));
	}

	@SuppressWarnings("unused")
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

	public void loadLogin() throws Exception {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
		fxmlLoader.setController(this);
		Parent loginPane = fxmlLoader.load();
		mainPane.add(loginPane, 0, 0);
	}

	public void logIn() throws IOException {
		String username = txtLoginName.getText();
		String password = txtLoginPassword.getText();
		User user = restaurant.searchUser(username);
		if(user != null && user.getPassword().equals(password)) {
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("table-view.fxml"));
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
	}

	public void signUp() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("register.fxml"));
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
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
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

	public void logOut() {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("login.fxml"));
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

	public void viewProducts() {

	}

	public void viewIngredients() {

	}

	public void viewClients() {

	}

	public void viewEmployees() {

	}

	public void viewUsers() {

	}

	public void viewOrders() {

	}

	public void addProducts() {

	}

	public void addIngredients() {

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
