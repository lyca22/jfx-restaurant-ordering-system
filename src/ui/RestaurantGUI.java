package ui;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Client;
import model.Employee;
import model.Ingredient;
import model.OrderState;
import model.Product;
import model.ProductSize;
import model.ProductType;
import javafx.stage.FileChooser;
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

	//ProductType list.

	@FXML
	private TableView<model.ProductType> tvProductTypes;

	@FXML
	private TableColumn<model.ProductType, String> tcProductTypeName;

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

	@FXML
	private TextField txtEmployeeName;

	@FXML
	private TextField txtEmployeeSurname;

	@FXML
	private TextField txtEmployeeID;

	@FXML
	private TextField txtUserName;

	@FXML
	private TextField txtUserSurname;

	@FXML
	private TextField txtUserID;

	@FXML
	private TextField txtUserUsername;

	@FXML
	private PasswordField txtUserPassword;

	@FXML
	private TextField txtClientName;

	@FXML
	private TextField txtClientSurname;

	@FXML
	private TextField txtClientID;

	@FXML
	private TextField txtClientAddress;

	@FXML
	private TextField txtClientPhone;

	@FXML
	private TextField txtClientObservations;

	@FXML
	private TextField txtProductName;

	@FXML
	private ChoiceBox<String> cbProductType;

	@FXML
	private VBox vbProductIngredients;

	@FXML
	private ChoiceBox<String> cbProductSize;

	@FXML
	private TextField txtProductPrice;

	@FXML
	private VBox vbOrderProducts;

	@FXML
	private VBox vbOrderClients;

	@FXML
	private VBox vbOrderEmployee;

	@FXML
	private TextField txtOrderObservations;

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
		tcProductType.setCellValueFactory(new PropertyValueFactory<model.Product, String>("productTypeAsString"));
		tcProductIngredients.setCellValueFactory(new PropertyValueFactory<model.Product, String>("ingredientsAsString"));
		tcProductSize.setCellValueFactory(new PropertyValueFactory<model.Product, String>("sizeAsString"));
		tcProductPrice.setCellValueFactory(new PropertyValueFactory<model.Product, String>("price"));

	}

	private void initializeProductTypeTableView() {
		ObservableList<model.ProductType> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getProductTypes());
		tvProductTypes.setItems(observableList);
		tcProductTypeName.setCellValueFactory(new PropertyValueFactory<model.ProductType, String>("name"));
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
		tcOrderStatus.setCellValueFactory(new PropertyValueFactory<model.Order, String>("orderStateAsString"));
		tcOrderProducts.setCellValueFactory(new PropertyValueFactory<model.Order, String>("productsAsString"));
		tcOrderQuantity.setCellValueFactory(new PropertyValueFactory<model.Order, String>("quantityAsString"));
		tcOrderClient.setCellValueFactory(new PropertyValueFactory<model.Order, String>("clientAsString"));
		tcOrderEmployee.setCellValueFactory(new PropertyValueFactory<model.Order, String>("employeeAsString"));
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

	public void viewProductTypes() {
		loadTable("productType-table-view.fxml");
		initializeProductTypeTableView();
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

	public ButtonType openWindow(String resource) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
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
		return acceptButtonType;
	}

	public void addProducts() {
		ButtonType acceptButtonType = openWindow("add-product.fxml");
		for(ProductType i: restaurant.getProductTypes()) {
			cbProductType.getItems().add(i.getName());
		}
		for(Ingredient i: restaurant.getIngredients()) {
			CheckBox newCheckBox = new CheckBox();
			newCheckBox.setText(i.getName());
			vbProductIngredients.getChildren().add(newCheckBox);
		}
		cbProductSize.getItems().addAll("Caja personal", "Caja para dos");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String productName = txtProductName.getText();
				ProductType productType = restaurant.searchProductType(cbProductType.getSelectionModel().getSelectedItem().toString());
				CheckBox checkBox;
				ArrayList<Ingredient> productIngredients = new ArrayList<>();
				Ingredient ingredient;
				for(int i = 0; i < vbProductIngredients.getChildren().size(); i++) {
					if(vbProductIngredients.getChildren().get(i) instanceof CheckBox) {
						checkBox = (CheckBox) vbProductIngredients.getChildren().get(i);
						if (checkBox.isSelected()) {
							ingredient = restaurant.searchIngredient(checkBox.getText());
							if(ingredient != null) {
								productIngredients.add(ingredient);
							}
						}
					}
				}
				ProductSize productSize = ProductSize.Meal_Box_For_One;
				switch (cbProductSize.getSelectionModel().getSelectedItem().toString()) {
				case "Caja personal":
					productSize = ProductSize.Meal_Box_For_One;
					break;
				case "Caja para dos":
					productSize = ProductSize.Meal_Box_For_Two;
					break;
				}
				int productPrice = Integer.parseInt(txtProductPrice.getText());
				restaurant.addProduct(productName, productType, productIngredients, productSize, productPrice, restaurant.getActualUser());
				viewProducts();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addProductType() {
		ButtonType acceptButtonType = openWindow("add-productType.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String productTypeName = txtIngredientName.getText();
				restaurant.addProductType(productTypeName, restaurant.getActualUser());
				viewProductTypes();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addIngredients() {
		ButtonType acceptButtonType = openWindow("add-ingredient.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String ingredientName = txtIngredientName.getText();
				restaurant.addIngredient(ingredientName, restaurant.getActualUser());
				viewIngredients();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addClients() {
		ButtonType acceptButtonType = openWindow("add-client.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String clientName = txtClientName.getText();
				String clientSurname = txtClientSurname.getText();
				int clientID = Integer.parseInt(txtClientID.getText());
				String clientAddress = txtClientAddress.getText();
				int clientPhone = Integer.parseInt(txtClientPhone.getText());
				String clientObservations = txtClientObservations.getText();
				restaurant.addClient(clientName, clientSurname, clientID, clientAddress, clientPhone, clientObservations, restaurant.getActualUser());
				viewClients();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addEmployees() {
		ButtonType acceptButtonType = openWindow("add-employee.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String employeeName = txtEmployeeName.getText();
				String employeeSurname = txtEmployeeSurname.getText();
				int employeeID = Integer.parseInt(txtEmployeeID.getText());
				restaurant.addEmployee(employeeName, employeeSurname, employeeID);
				viewEmployees();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateUsers() {
		ButtonType acceptButtonType = openWindow("update-user.fxml");
		txtUserName.setText(restaurant.getActualUser().getName());
		txtUserSurname.setText(restaurant.getActualUser().getSurname());
		txtUserID.setText(String.valueOf(restaurant.getActualUser().getID()));
		txtUserUsername.setText(restaurant.getActualUser().getUsername());
		txtUserPassword.setText(restaurant.getActualUser().getPassword());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String userName = txtUserName.getText();
				String userSurname = txtUserSurname.getText();
				int userID = Integer.parseInt(txtUserID.getText());
				String userUsername = txtUserUsername.getText();
				String userPassword = txtUserPassword.getText();
				restaurant.updateUser(restaurant.getActualUser(), userName, userSurname, userID, userUsername, userPassword);
				viewUsers();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addOrders() {
		ButtonType acceptButtonType = openWindow("add-order.fxml");
		for(Product i: restaurant.getProducts()) {
			HBox newHBox = new HBox();
			Label newLabel = new Label();
			newLabel.setText(i.getName());
			TextField newTextField = new TextField();
			newTextField.setText("0");
			newHBox.getChildren().addAll(newLabel, newTextField);
			vbOrderProducts.getChildren().add(newHBox);
		}
		ToggleGroup clientToggleGroup = new ToggleGroup();
		for(Client i: restaurant.getClients()) {
			RadioButton newRadioButton = new RadioButton();
			newRadioButton.setText(i.getName());
			clientToggleGroup.getToggles().add(newRadioButton);
			vbOrderClients.getChildren().add(newRadioButton);
		}
		ToggleGroup employeeToggleGroup = new ToggleGroup();
		for(Employee i: restaurant.getEmployees()) {
			RadioButton newRadioButton = new RadioButton();
			newRadioButton.setText(i.getName());
			employeeToggleGroup.getToggles().add(newRadioButton);
			vbOrderEmployee.getChildren().add(newRadioButton);
		}
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				HBox hbox;
				Label label;
				TextField textField;
				ArrayList<Product> orderProducts = new ArrayList<>();
				ArrayList<Integer> orderProductQuantity = new ArrayList<>();
				Product product;
				for(int i = 0; i < vbOrderProducts.getChildren().size(); i++) {
					hbox = (HBox) vbOrderProducts.getChildren().get(i);
					for(int j = 0; j < hbox.getChildren().size(); j++) {
						if(hbox.getChildren().get(j) instanceof TextField) {
							label = (Label) hbox.getChildren().get(j-1);
							textField = (TextField) hbox.getChildren().get(j);
							product = restaurant.searchProduct(label.getText());
							if(product != null) {
								orderProducts.add(product);
								orderProductQuantity.add(Integer.parseInt(textField.getText()));
							}
						}
					}
				}
				RadioButton radioButton;
				Client client = null;
				for(int i = 0; i < vbOrderClients.getChildren().size(); i++) {
					if(vbOrderClients.getChildren().get(i) instanceof RadioButton) {
						radioButton = (RadioButton) vbOrderClients.getChildren().get(i);
						if (radioButton.isSelected()) {
							client = restaurant.searchClient(radioButton.getText());
						}
					}
				}
				Employee employee = null;
				for(int i = 0; i < vbOrderEmployee.getChildren().size(); i++) {
					if(vbOrderEmployee.getChildren().get(i) instanceof RadioButton) {
						radioButton = (RadioButton) vbOrderEmployee.getChildren().get(i);
						if (radioButton.isSelected()) {
							employee = restaurant.searchEmployee(radioButton.getText());
						}
					}
				}
				LocalDateTime date = LocalDateTime.now();
				String observations = txtOrderObservations.getText();
				restaurant.addOrder(OrderState.Requested, orderProducts, orderProductQuantity, client, employee, date, observations, restaurant.getActualUser());
				viewOrders();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void importProducts() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Products Data");
		File file = fileChooser.showOpenDialog(null);
		String separator = ",";
		try {
			restaurant.importProductData(file.getAbsolutePath(), separator);
			initializeProductsTableView();
		} catch (IOException e) {
			System.out.println("IOException found");
		} catch (NullPointerException npe) {
			System.out.println("NP Exception found");
		} catch (NumberFormatException nfe) {
			System.out.println("NF Exception found");
		}
		try {
			restaurant.saveProducts();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importClients() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Client Data");
		File file = fileChooser.showOpenDialog(null);
		String separator = ",";
		try {
			restaurant.importClientData(file.getAbsolutePath(), separator);
			initializeClientsTableView();
		} catch (IOException e) {
			System.out.println("IOException found");
		} catch (NullPointerException npe) {
			System.out.println("NP Exception found");
		} catch (NumberFormatException nfe) {
			System.out.println("NF Exception found");
		}
		try {
			restaurant.saveClients();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void importOrders() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Order Data");
		File file = fileChooser.showOpenDialog(null);
		String separator = ",";
		try {
			restaurant.importOrderData(file.getAbsolutePath(), separator);
			initializeOrdersTableView();
		} catch (IOException e) {
			System.out.println("IOException found");
		} catch (NullPointerException npe) {
			System.out.println("NP Exception found");
		} catch (NumberFormatException nfe) {
			System.out.println("NF Exception found");
		}
		try {
			restaurant.saveOrders();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void exportProducts() {

	}

	public void exportEmployees() {

	}

	public void exportOrders() {

	}

}
