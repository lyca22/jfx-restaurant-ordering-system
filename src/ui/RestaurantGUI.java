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

public class RestaurantGUI {

	private Restaurant restaurant;

	@FXML
	private GridPane mainPane;

	@FXML
	private TextField txtLoginName;

	@FXML
	private PasswordField txtLoginPassword;

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

	@FXML
	private TableView<model.Product> tvProducts;

	@FXML
	private TableView<model.Ingredient> tvIngredients;

	@FXML
	private TableView<model.Client> tvClients;

	@FXML
	private TableView<model.Employee> tvEmployees;

	@FXML
	private TableColumn<model.Employee, String> tcEmployeeName;

	@FXML
	private TableColumn<model.Employee, String> tcEmployeeSurname;

	@FXML
	private TableColumn<model.Employee, String> tcEmployeeID;

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
