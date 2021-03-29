package ui;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
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
import model.Order;
import model.OrderState;
import model.Product;
import model.ProductSize;
import model.ProductType;
import javafx.stage.FileChooser;
import model.Restaurant;

public class RestaurantGUI {

	private Restaurant restaurant;
	private ButtonType acceptButtonType;
	private ButtonType cancelButtonType;
	private ButtonType deleteButtonType;
	private ButtonType disableButtonType;
	private ButtonType enableButtonType;
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

	//Add or update window

	@FXML
	Dialog<String> dialog;
	
	@FXML
	Dialog<String> alertDialog;

	@FXML
	ButtonType okayButton;
	
	//Product fields.

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

	//ProductType fields.

	@FXML
	private TextField txtProductTypeName;

	//Ingredient fields.

	@FXML
	private TextField txtIngredientName;

	//Client fields.

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

	//Employee fields.

	@FXML
	private TextField txtEmployeeName;

	@FXML
	private TextField txtEmployeeSurname;

	@FXML
	private TextField txtEmployeeID;

	//User fields.

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

	//Order fields.

	@FXML
	private TextField txtOrderCode;

	@FXML
	private VBox vbOrderProducts;

	@FXML
	private VBox vbOrderClients;

	@FXML
	private VBox vbOrderEmployee;

	@FXML
	private TextField txtOrderObservations;

	@FXML
	private DatePicker orderDatePicker;

	@FXML
	private TextField orderHour;

	//Export fields.

	@FXML
	private DatePicker DpMInDate;

	@FXML
	private DatePicker DpMaxDate;

	@FXML
	private TextField txtFileExportOrder;

	@FXML
	private TextField txtSeparator;

	@FXML
	private TextField txtMinHour;

	@FXML
	private TextField txtMaxHour;

	//Updating title.

	@FXML
	private Label labelTitle;

	@FXML
	private Label labelProductType;

	@FXML
	private Label labelIngredient;

	@FXML
	private Label labelClient;

	@FXML
	private Label labelEmployee;

	@FXML
	private TextField txtClientBrowser;

	//User who created/last modified.

	@FXML
	private Label productsUserCreated;

	@FXML
	private Label productsUserModified;

	@FXML
	private Label productTypesUserCreated;

	@FXML
	private Label productsTypesModified;

	@FXML
	private Label ingredientsCreated;

	@FXML
	private Label ingredientsModified;

	@FXML
	private Label clientsCreated;

	@FXML
	private Label clientsModified;

	@FXML
	private Label employeesCreated;

	@FXML
	private Label employeesModified;

	@FXML
	private Label ordersCreated;

	@FXML
	private Label ordersModified;

	@FXML
	private Label userCreated;

	@FXML
	private Label userModified;

	public RestaurantGUI(Restaurant restaurant) {
		this.setRestaurant(restaurant);
		setAcceptButtonType(new ButtonType("Aceptar", ButtonData.APPLY));
		setCancelButtonType(new ButtonType("Cancelar", ButtonData.CANCEL_CLOSE));
		setDeleteButtonType(new ButtonType("Borrar", ButtonData.NO));
		setDisableButtonType(new ButtonType("Deshabilitar", ButtonData.OTHER));
		setEnableButtonType(new ButtonType("Habilitar", ButtonData.OK_DONE));
		alertDialog = new Dialog<>();
		okayButton = new ButtonType("OK", ButtonData.OK_DONE);
		alertDialog.getDialogPane().getButtonTypes().add(okayButton);
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void showAlert(String text) {
		alertDialog.getDialogPane().setHeaderText(text);
		alertDialog.showAndWait();
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

		tcProductName.setOnEditStart(t -> updateProduct(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcProductType.setOnEditStart(t -> updateProduct(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcProductIngredients.setOnEditStart(t -> updateProduct(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcProductSize.setOnEditStart(t -> updateProduct(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcProductPrice.setOnEditStart(t -> updateProduct(t.getTableView().getItems().get(t.getTablePosition().getRow())));
	}

	private void initializeProductTypeTableView() {
		ObservableList<model.ProductType> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getProductTypes());
		tvProductTypes.setItems(observableList);
		tcProductTypeName.setCellValueFactory(new PropertyValueFactory<model.ProductType, String>("name"));

		tcProductTypeName.setOnEditStart(t -> updateProductType(t.getTableView().getItems().get(t.getTablePosition().getRow())));
	}

	private void initializeIngredientsTableView() {
		ObservableList<model.Ingredient> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getIngredients());
		tvIngredients.setItems(observableList);
		tcIngredientName.setCellValueFactory(new PropertyValueFactory<model.Ingredient, String>("name"));

		tcIngredientName.setOnEditStart(t -> updateIngredients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
	}

	private void initializeClientsTableView() {
		ObservableList<model.Client> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getClients());
		FilteredList<Client> flClient = new FilteredList<Client>(observableList, p -> true);
		tvClients.setItems(flClient);
		txtClientBrowser.textProperty().addListener((obs, oldValue, newValue) -> {
			flClient.setPredicate(p -> p.getName().toLowerCase().contains(newValue.toLowerCase().trim()));
		});
		tcClientName.setCellValueFactory(new PropertyValueFactory<model.Client, String>("name"));
		tcClientSurnames.setCellValueFactory(new PropertyValueFactory<model.Client, String>("surname"));
		tcClientID.setCellValueFactory(new PropertyValueFactory<model.Client, String>("ID"));
		tcClientAddress.setCellValueFactory(new PropertyValueFactory<model.Client, String>("address"));
		tcClientPhone.setCellValueFactory(new PropertyValueFactory<model.Client, String>("phoneNumber"));
		tcClientObservations.setCellValueFactory(new PropertyValueFactory<model.Client, String>("observations"));

		tcClientName.setOnEditStart(t -> updateClients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcClientSurnames.setOnEditStart(t -> updateClients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcClientID.setOnEditStart(t -> updateClients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcClientAddress.setOnEditStart(t -> updateClients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcClientPhone.setOnEditStart(t -> updateClients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcClientObservations.setOnEditStart(t -> updateClients(t.getTableView().getItems().get(t.getTablePosition().getRow())));
	}

	private void initializeEmployeeTableView() {
		ObservableList<model.Employee> observableList;
		observableList = FXCollections.observableArrayList(restaurant.getEmployees());
		tvEmployees.setItems(observableList);
		tcEmployeeName.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("name"));
		tcEmployeeSurname.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("surname"));
		tcEmployeeID.setCellValueFactory(new PropertyValueFactory<model.Employee, String>("ID"));

		tcEmployeeName.setOnEditStart(t -> updateEmployees(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcEmployeeSurname.setOnEditStart(t -> updateEmployees(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcEmployeeID.setOnEditStart(t -> updateEmployees(t.getTableView().getItems().get(t.getTablePosition().getRow())));
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

		tcOrderCode.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderStatus.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderProducts.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderQuantity.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderClient.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderEmployee.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderDate.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
		tcOrderObservations.setOnEditStart(t -> updateOrders(t.getTableView().getItems().get(t.getTablePosition().getRow())));
	}

	public void logIn() {
		String username = txtLoginName.getText();
		String password = txtLoginPassword.getText();
		if(restaurant.logIn(username, password)) {
			loadScreen("table-view.fxml");
		}else if(username.isEmpty() || password.isEmpty()){
			showAlert("Por favor ingresa un usuario y una contraseña.");
		}else {
			showAlert("El usuario no existe o la contraseña es incorrecta.");
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
			boolean created;
			if(wroteName && wroteSurname && wroteID && wroteUsername && wrotePassword) {
				created = restaurant.addUser(name, surname, ID, username, password);
				if(created) {
					showAlert("Cuenta creada.");
				}else {
					showAlert("El usuario ya existe.");
				}
				
			}else {
				showAlert("Rellena todos los campos del formulario.");
			}
		} catch(NumberFormatException nfe) {
			showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
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

	public void openWindow(String resource) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		fxmlLoader.setController(this);
		dialog = new Dialog<String>();
		dialog.getDialogPane().getButtonTypes().addAll(acceptButtonType, cancelButtonType);
		Parent root;
		try {
			root = fxmlLoader.load();
			dialog.getDialogPane().setContent(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void otherOpenWindow(String resource) {
		FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(resource));
		fxmlLoader.setController(this);
		dialog = new Dialog<String>();
		dialog.getDialogPane().getButtonTypes().addAll(acceptButtonType, cancelButtonType, deleteButtonType, disableButtonType, enableButtonType);
		Parent root;
		try {
			root = fxmlLoader.load();
			dialog.getDialogPane().setContent(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	//Adding methods.

	public void addProducts() {
		openWindow("add-product.fxml");
		for(ProductType i: restaurant.getProductTypes()) {
			if(!i.isDisabled()) {
				cbProductType.getItems().add(i.getName());
			}
		}
		for(Ingredient i: restaurant.getIngredients()) {
			if(!i.isDisabled()) {
				CheckBox newCheckBox = new CheckBox();
				newCheckBox.setText(i.getName());
				vbProductIngredients.getChildren().add(newCheckBox);
			}
		}
		cbProductSize.getItems().addAll("Caja personal", "Caja para dos");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
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
					boolean created;
					if(!productName.isEmpty()) {
						created = restaurant.addProduct(productName, productType, productIngredients, productSize, productPrice, restaurant.getActualUser());
						if(created) {
							viewProducts();
						}else {
							showAlert("El producto ya existe.");
						}
					}else {
						showAlert("Asegúrate de llenar todos los campos.");
					}
				}catch(NullPointerException npe) {
					showAlert("Asegúrate de seleccionar un tipo de producto y un tamaño (NullPointerException).");
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addProductType() {
		openWindow("add-productType.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String productTypeName = txtProductTypeName.getText();
				boolean created;
				if(!productTypeName.isEmpty()) {
					created = restaurant.addProductType(productTypeName, restaurant.getActualUser());
					if(created) {
						viewProductTypes();
					}else {
						showAlert("El tipo de producto ya existe.");
					}
				}else {
					showAlert("Asegúrate de llenar todos los campos.");
				}
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addIngredients() {
		openWindow("add-ingredient.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String ingredientName = txtIngredientName.getText();
				boolean created;
				if(!ingredientName.isEmpty()) {
					created = restaurant.addIngredient(ingredientName, restaurant.getActualUser());
					if(created) {
						viewIngredients();
					}else {
						showAlert("El ingrediente ya existe.");
					}
				}else {
					showAlert("Asegúrate de llenar todos los campos.");
				}
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addClients() {
		openWindow("add-client.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
					String clientName = txtClientName.getText();
					String clientSurname = txtClientSurname.getText();
					int clientID = Integer.parseInt(txtClientID.getText());
					String clientAddress = txtClientAddress.getText();
					BigInteger clientPhone = new BigInteger(txtClientPhone.getText());
					String clientObservations = txtClientObservations.getText();
					if(!clientName.isEmpty() && !clientSurname.isEmpty() && !clientAddress.isEmpty()) {
						restaurant.addClient(clientName, clientSurname, clientID, clientAddress, clientPhone, clientObservations, restaurant.getActualUser());
						viewClients();
					}
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addEmployees() {
		openWindow("add-employee.fxml");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
					String employeeName = txtEmployeeName.getText();
					String employeeSurname = txtEmployeeSurname.getText();
					int employeeID = Integer.parseInt(txtEmployeeID.getText());
					if(!employeeName.isEmpty() && !employeeSurname.isEmpty()) {
						restaurant.addEmployee(employeeName, employeeSurname, employeeID);
						viewEmployees();
					}
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void addOrders() {
		openWindow("add-order.fxml");
		for(Product i: restaurant.getProducts()) {
			if(!i.isDisabled()) {
				HBox newHBox = new HBox();
				Label newLabel = new Label();
				newLabel.setText(i.getName());
				TextField newTextField = new TextField();
				newTextField.setText("0");
				newHBox.getChildren().addAll(newLabel, newTextField);
				vbOrderProducts.getChildren().add(newHBox);
			}
		}
		ToggleGroup clientToggleGroup = new ToggleGroup();
		for(Client i: restaurant.getClients()) {
			if(!i.isDisabled()) {
				RadioButton newRadioButton = new RadioButton();
				newRadioButton.setText(i.getName());
				clientToggleGroup.getToggles().add(newRadioButton);
				vbOrderClients.getChildren().add(newRadioButton);
			}
		}
		ToggleGroup employeeToggleGroup = new ToggleGroup();
		for(Employee i: restaurant.getEmployees()) {
			if(!i.isDisabled()) {
				RadioButton newRadioButton = new RadioButton();
				newRadioButton.setText(i.getName());
				employeeToggleGroup.getToggles().add(newRadioButton);
				vbOrderEmployee.getChildren().add(newRadioButton);
			}
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
							if(product != null && Integer.parseInt(textField.getText()) > 0) {
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
				if(!orderProducts.isEmpty() && client != null && employee != null) {
					restaurant.addOrder(OrderState.Requested, orderProducts, orderProductQuantity, client, employee, date, observations, restaurant.getActualUser());
					viewOrders();
				}
			}
			return null;
		});
		dialog.showAndWait();
	}

	//Update methods.

	public void updateProduct(Product product) {
		otherOpenWindow("add-product.fxml");
		labelProductType.setText("Modifica el producto:");
		txtProductName.setText(product.getName());
		for(ProductType i: restaurant.getProductTypes()) {
			cbProductType.getItems().add(i.getName());
		}
		for(Ingredient i: restaurant.getIngredients()) {
			CheckBox newCheckBox = new CheckBox();
			newCheckBox.setText(i.getName());
			vbProductIngredients.getChildren().add(newCheckBox);
		}
		cbProductSize.getItems().addAll("Caja personal", "Caja para dos");
		txtProductPrice.setText(String.valueOf(product.getPrice()));
		productsUserCreated.setText(product.getUserWhoCreated().getName());
		productsUserModified.setText(product.getLastUserWhoModified().getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
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
					if(!productName.isEmpty()) {
						restaurant.updateProduct(product, productName, productType, productIngredients, productSize, productPrice, restaurant.getActualUser());
						viewProducts();
					}else {
						showAlert("Asegúrate de llenar todos los campos.");
					}
				}catch(NullPointerException npe) {
					showAlert("Asegúrate de seleccionar un tipo de producto y un tamaño (NullPointerException).");
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}
			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteProduct(product);
				viewProducts();
			}else if(dialogButton == disableButtonType) {
				product.setDisabled(true);
			}else if(dialogButton == enableButtonType) {
				product.setDisabled(false);
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateProductType(ProductType productType) {
		otherOpenWindow("add-productType.fxml");
		labelProductType.setText("Modifica el tipo de producto:");
		txtProductTypeName.setText(productType.getName());
		productTypesUserCreated.setText(productType.getUserWhoCreated().getName());
		productsTypesModified.setText(productType.getLastUserWhoModified().getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String productTypeName = txtProductTypeName.getText();
				if(!productTypeName.isEmpty()) {
					restaurant.updateProductType(productType, productTypeName, restaurant.getActualUser());
					viewProductTypes();
				}else {
					showAlert("Asegúrate de llenar todos los campos.");
				}
			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteProductType(productType);
				viewProductTypes();
			}else if(dialogButton == disableButtonType) {
				productType.setDisabled(true);
			}else if(dialogButton == enableButtonType) {
				productType.setDisabled(false);
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateIngredients(Ingredient ingredient) {
		otherOpenWindow("add-ingredient.fxml");
		labelIngredient.setText("Modifica este ingrediente:");
		txtIngredientName.setText(ingredient.getName());
		ingredientsCreated.setText(ingredient.getUserWhoCreated().getName());
		ingredientsModified.setText(ingredient.getLastUserWhoModified().getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String ingredientName = txtIngredientName.getText();
				if(!ingredientName.isEmpty()) {
					restaurant.updateIngredient(ingredient, ingredientName, restaurant.getActualUser());
					viewIngredients();
				}else {
					showAlert("Asegúrate de llenar todos los campos.");
				}
			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteIngredient(ingredient);
				viewIngredients();
			}else if(dialogButton == disableButtonType) {
				ingredient.setDisabled(true);
			}else if(dialogButton == enableButtonType) {
				ingredient.setDisabled(false);
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateClients(Client client) {
		otherOpenWindow("add-client.fxml");
		labelClient.setText("Modifica a este cliente:");
		txtClientName.setText(client.getName());
		txtClientSurname.setText(client.getSurname());
		txtClientID.setText(String.valueOf(client.getID()));
		txtClientAddress.setText(client.getAddress());
		txtClientPhone.setText(String.valueOf(client.getPhoneNumber()));
		txtClientObservations.setText(client.getObservations());
		clientsCreated.setText(client.getUserWhoCreated().getName());
		clientsModified.setText(client.getLastUserWhoModified().getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
					String clientName = txtClientName.getText();
					String clientSurname = txtClientSurname.getText();
					int clientID = Integer.parseInt(txtClientID.getText());
					String clientAddress = txtClientAddress.getText();
					BigInteger clientPhone = new BigInteger(txtClientPhone.getText());
					String clientObservations = txtClientObservations.getText();
					if(!clientName.isEmpty() && !clientSurname.isEmpty() && !clientAddress.isEmpty()) {
						restaurant.updateClient(client, clientName, clientSurname, clientID, clientAddress, clientPhone, clientObservations, restaurant.getActualUser());
						viewClients();
					}else {
						showAlert("Asegúrate de llenar todos los campos.");
					}
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}
			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteClient(client);
				viewClients();
			}else if(dialogButton == disableButtonType) {
				client.setDisabled(true);
			}else if(dialogButton == enableButtonType) {
				client.setDisabled(false);
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateEmployees(Employee employee) {
		otherOpenWindow("add-employee.fxml");
		labelEmployee.setText("Modifica a este empleado:");
		txtEmployeeName.setText(employee.getName());
		txtEmployeeSurname.setText(employee.getSurname());
		txtEmployeeID.setText(String.valueOf(employee.getID()));
		employeesCreated.setText(employee.getName());
		employeesModified.setText(employee.getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
					String employeeName = txtEmployeeName.getText();
					String employeeSurname = txtEmployeeSurname.getText();
					int employeeID = Integer.parseInt(txtEmployeeID.getText());
					if(!employeeName.isEmpty() && !employeeSurname.isEmpty()) {
						restaurant.updateEmployee(employee, employeeName, employeeSurname, employeeID);
						viewEmployees();
					}else {
						showAlert("Asegúrate de llenar todos los campos.");
					}
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}
			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteEmployee(employee);
			}else if(dialogButton == disableButtonType) {
				employee.setDisabled(true);
			}else if(dialogButton == enableButtonType) {
				employee.setDisabled(false);
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateUsers() {
		otherOpenWindow("update-user.fxml");
		txtUserName.setText(restaurant.getActualUser().getName());
		txtUserSurname.setText(restaurant.getActualUser().getSurname());
		txtUserID.setText(String.valueOf(restaurant.getActualUser().getID()));
		txtUserUsername.setText(restaurant.getActualUser().getUsername());
		txtUserPassword.setText(restaurant.getActualUser().getPassword());
		userCreated.setText(restaurant.getActualUser().getName());
		userModified.setText(restaurant.getActualUser().getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				try {
					String userName = txtUserName.getText();
					String userSurname = txtUserSurname.getText();
					int userID = Integer.parseInt(txtUserID.getText());
					String userUsername = txtUserUsername.getText();
					String userPassword = txtUserPassword.getText();
					if(!userName.isEmpty() && !userSurname.isEmpty() && !userUsername.isEmpty() && !userPassword.isEmpty()) {
						restaurant.updateUser(restaurant.getActualUser(), userName, userSurname, userID, userUsername, userPassword);
						viewUsers();
					}else {
						showAlert("Asegúrate de llenar todos los campos.");
					}
				}catch(NumberFormatException nfe) {
					showAlert("Asegúrate de rellenar los campos con la información correcta (NumberFormatException).");
				}

			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteUser(restaurant.getActualUser());
				logOut();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void updateOrders(Order order) {
		otherOpenWindow("update-order.fxml");
		restaurant.setActualOrder(order);
		txtOrderCode.setText(String.valueOf(order.getOrderCode()));
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
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
		String dateInString = order.getDate().format(formatter);
		orderDatePicker.setValue(order.getDate().toLocalDate());
		orderHour.setText(dateInString);
		txtOrderObservations.setText(order.getObservations());
		ordersCreated.setText(order.getUserWhoCreated().getName());
		ordersModified.setText(order.getLastUserWhoModified().getName());
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				HBox hbox;
				Label label;
				TextField textField;
				ArrayList<Product> orderProducts = new ArrayList<>();
				ArrayList<Integer> orderProductQuantity = new ArrayList<>();
				Product product;
				int orderCode = Integer.parseInt(txtOrderCode.getText());
				for(int i = 0; i < vbOrderProducts.getChildren().size(); i++) {
					hbox = (HBox) vbOrderProducts.getChildren().get(i);
					for(int j = 0; j < hbox.getChildren().size(); j++) {
						if(hbox.getChildren().get(j) instanceof TextField) {
							label = (Label) hbox.getChildren().get(j-1);
							textField = (TextField) hbox.getChildren().get(j);
							product = restaurant.searchProduct(label.getText());
							if(product != null && Integer.parseInt(textField.getText()) > 0) {
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
				String orderDate[] = orderDatePicker.getValue().toString().split("-");
				String hour[] = orderHour.getText().split(":");
				LocalDateTime date = LocalDateTime.of(Integer.parseInt(orderDate[0]), Integer.parseInt(orderDate[1]), Integer.parseInt(orderDate[2]), Integer.parseInt(hour[0]), Integer.parseInt(hour[1]), Integer.parseInt(hour[2]));
				String observations = txtOrderObservations.getText();
				if(!orderProducts.isEmpty() && client != null && employee != null) {
					restaurant.updateOrder(order, orderCode, orderProducts, orderProductQuantity, client, employee, date, observations, restaurant.getActualUser());
					viewOrders();
				}else {
					showAlert("Asegúrate de llenar todos los campos.");
				}
			}else if(dialogButton == deleteButtonType) {
				restaurant.deleteOrder(order);
				viewOrders();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void changeOrderStatus() {
		restaurant.updateOrderState(restaurant.getActualOrder());
		viewOrders();
		showAlert("Cambiado a " + restaurant.getActualOrder().getOrderStateAsString());
	}

	public void importProducts() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Products Data");
		File file = fileChooser.showOpenDialog(null);
		String separator = ";";
		try {
			restaurant.importProductData(file.getAbsolutePath(), separator, restaurant.getActualUser());
			initializeProductsTableView();
		} catch (IOException e) {
			System.out.println("IOException found");
		} catch (NullPointerException npe) {
			System.out.println("NP Exception found");
		} catch (NumberFormatException nfe) {
			System.out.println("NF Exception found");
		}
	}

	public void importClients() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Client Data");
		File file = fileChooser.showOpenDialog(null);
		String separator = ";";
		try {
			restaurant.importClientData(file.getAbsolutePath(), separator, restaurant.getActualUser());
			initializeClientsTableView();
		} catch (IOException e) {
			System.out.println("IOException found");
		} catch (NullPointerException npe) {
			System.out.println("NP Exception found");
		} catch (NumberFormatException nfe) {
			System.out.println("NF Exception found");
		}
	}

	public void importOrders() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle("Import Order Data");
		File file = fileChooser.showOpenDialog(null);
		String separator = ";";
		try {
			restaurant.importOrderData(file.getAbsolutePath(), separator, restaurant.getActualUser());
			initializeOrdersTableView();
		} catch (IOException e) {
			System.out.println("IOException found");
		} catch (NullPointerException npe) {
			System.out.println("NP Exception found");
		} catch (NumberFormatException nfe) {
			System.out.println("NF Exception found");
		}
	}

	public void exportOrders() {
		openWindow("export-report.fxml");
		labelTitle.setText("Reporte de ordenes");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String fileName = txtFileExportOrder.getText()+".txt";
				String separator = txtSeparator.getText();
				String[] min = DpMInDate.getValue().toString().split("-");
				String[] max = DpMaxDate.getValue().toString().split("-"); 
				String [] minHour = txtMinHour.getText().split(":");
				String [] maxHour = txtMaxHour.getText().split(":");
				LocalDateTime minDate = LocalDateTime.of(Integer.parseInt(min[0]), Integer.parseInt(min[1]), Integer.parseInt(min[2]), Integer.parseInt(minHour[0]),Integer.parseInt(minHour[1]), Integer.parseInt(minHour[2]));
				LocalDateTime maxDate = LocalDateTime.of(Integer.parseInt(max[0]), Integer.parseInt(max[1]), Integer.parseInt(max[2]), Integer.parseInt(maxHour[0]),Integer.parseInt(maxHour[1]), Integer.parseInt(maxHour[2]));
				try {
					restaurant.generateOrderReport(fileName, separator, minDate, maxDate);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				viewOrders();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void exportEmployees() {
		openWindow("export-report.fxml");
		labelTitle.setText("Reporte de empleados");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String fileName = txtFileExportOrder.getText()+".txt";
				String separator = txtSeparator.getText();
				String[] min = DpMInDate.getValue().toString().split("-");
				String[] max = DpMaxDate.getValue().toString().split("-"); 
				String [] minHour = txtMinHour.getText().split(":");
				String [] maxHour = txtMaxHour.getText().split(":");
				LocalDateTime minDate = LocalDateTime.of(Integer.parseInt(min[0]), Integer.parseInt(min[1]), Integer.parseInt(min[2]), Integer.parseInt(minHour[0]),Integer.parseInt(minHour[1]), Integer.parseInt(minHour[2]));
				LocalDateTime maxDate = LocalDateTime.of(Integer.parseInt(max[0]), Integer.parseInt(max[1]), Integer.parseInt(max[2]), Integer.parseInt(maxHour[0]),Integer.parseInt(maxHour[1]), Integer.parseInt(maxHour[2]));
				try {
					restaurant.generateEmployeeReport(fileName, separator, minDate, maxDate);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				viewOrders();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public void exportProducts() {
		openWindow("export-report.fxml");
		labelTitle.setText("Reporte de productos");
		dialog.setResultConverter(dialogButton -> {
			if (dialogButton == acceptButtonType) {
				String fileName = txtFileExportOrder.getText()+".txt";
				String separator = txtSeparator.getText();
				String[] min = DpMInDate.getValue().toString().split("-");
				String[] max = DpMaxDate.getValue().toString().split("-");
				String [] minHour = txtMinHour.getText().split(":");
				String [] maxHour = txtMaxHour.getText().split(":");
				LocalDateTime minDate = LocalDateTime.of(Integer.parseInt(min[0]), Integer.parseInt(min[1]), Integer.parseInt(min[2]), Integer.parseInt(minHour[0]),Integer.parseInt(minHour[1]), Integer.parseInt(minHour[2]));
				LocalDateTime maxDate = LocalDateTime.of(Integer.parseInt(max[0]), Integer.parseInt(max[1]), Integer.parseInt(max[2]), Integer.parseInt(maxHour[0]),Integer.parseInt(maxHour[1]), Integer.parseInt(maxHour[2]));
				try {
					restaurant.generateProductReport(fileName, separator, minDate, maxDate);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				viewOrders();
			}
			return null;
		});
		dialog.showAndWait();
	}

	public ButtonType getAcceptButtonType() {
		return acceptButtonType;
	}

	public void setAcceptButtonType(ButtonType acceptButtonType) {
		this.acceptButtonType = acceptButtonType;
	}

	public ButtonType getCancelButtonType() {
		return cancelButtonType;
	}

	public void setCancelButtonType(ButtonType cancelButtonType) {
		this.cancelButtonType = cancelButtonType;
	}

	public ButtonType getDeleteButtonType() {
		return deleteButtonType;
	}

	public void setDeleteButtonType(ButtonType deleteButtonType) {
		this.deleteButtonType = deleteButtonType;
	}

	public ButtonType getDisableButtonType() {
		return disableButtonType;
	}

	public void setDisableButtonType(ButtonType disableButtonType) {
		this.disableButtonType = disableButtonType;
	}

	public ButtonType getEnableButtonType() {
		return enableButtonType;
	}

	public void setEnableButtonType(ButtonType enableButtonType) {
		this.enableButtonType = enableButtonType;
	}

}
