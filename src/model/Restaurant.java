package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Restaurant {

	public static final String NAME_FILE_NAME = "data/name.restr";
	public static final String ADDRESS_FILE_NAME = "data/address.restr";
	public static final String PRODUCTS_FILE_NAME = "data/products.restr";
	public static final String PRODUCT_TYPES_FILE_NAME = "data/productTypes.restr";
	public static final String INGREDIENTS_FILE_NAME = "data/ingredients.restr";
	public static final String CLIENTS_FILE_NAME = "data/clients.restr";
	public static final String EMPLOYEES_FILE_NAME = "data/employees.restr";
	public static final String USERS_FILE_NAME = "data/users.restr";
	public static final String ORDERS_FILE_NAME = "data/orders.restr";

	private String name;
	private String address;
	private ArrayList<Product> products;
	private ArrayList<ProductType> productTypes;
	private ArrayList<Ingredient> ingredients;
	private ArrayList<Client> clients;
	private ArrayList<Employee> employees;
	private ArrayList<User> users;
	private ArrayList<Order> orders;
	private User actualUser;

	public Restaurant(String name, String address) {
		this.name = name;
		this.address = address;
		products = new ArrayList<>();
		productTypes = new ArrayList<>();
		ingredients = new ArrayList<>();
		clients = new ArrayList<>();
		employees = new ArrayList<>();
		users = new ArrayList<>();
		orders = new ArrayList<>();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	public ArrayList<ProductType> getProductTypes() {
		return productTypes;
	}

	public void setProductTypes(ArrayList<ProductType> productTypes) {
		this.productTypes = productTypes;
	}

	public ArrayList<Ingredient> getIngredients() {
		return ingredients;
	}

	public void setIngredients(ArrayList<Ingredient> ingredients) {
		this.ingredients = ingredients;
	}

	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}

	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}

	public User getActualUser() {
		return actualUser;
	}

	public void setActualUser(User actualUser) {
		this.actualUser = actualUser;
	}

	//Sorting methods.

	public void sortProductByInsertion(ArrayList<Product> array) {
		for(int i = 1;i < array.size(); i++) {
			for(int j = i; j > 0 && array.get(j-1).getPrice()>array.get(j).getPrice();j--) {
				Product temp = array.get(j);
				array.set(j,array.get(j-1));
				array.set(j-1,temp);
			}
		}
	}

	public void sortClientBySurnameAndName() {
		Comparator<Client> clientComparator = new ClientSurnameAndNameComparator();
		Collections.sort(clients, clientComparator);
	}

	public void sortEmployeeBySurnameAndName() {
		Comparator<Employee> employeeComparator = new EmployeeSurnameAndNameComparator();
		Collections.sort(employees, employeeComparator);
	}

	public void sortUserByUsername() {
		Comparator<User> userComparator = new UserUsernameComparator();
		Collections.sort(users, userComparator);
	}

	public void sortIngredientBySelection(ArrayList<Ingredient> array) {
		for (int i = 0; i < array.size(); i++) {
			String min = array.get(i).getName();

			for(int j=i+1; j<array.size();j++) {
				if(array.get(j).getName().compareTo(min)>0) {
					String temp = array.get(j).getName();
					array.get(j).setName(min);
					min = temp;
				}
			}
			array.get(i).setName(min);
		}
	}

	//Search methods.

	public Product searchProduct(String name) {
		Product foundProduct = null;
		boolean found = false;
		for(Product p: products) {
			if(p.getName().equals(name) && !found) {
				foundProduct = p;
			}
		}
		return foundProduct;
	}

	public ProductType searchProductType(String name) {
		ProductType foundProductType = null;
		int index = binarySearchForProductType(name);
		if(index >= 0) {
			foundProductType = productTypes.get(index);
		}
		return foundProductType;
	}

	public Ingredient searchIngredient(String name) {
		Ingredient foundIngredient = null;
		int index = binarySearchForIngredient(name);
		if(index >= 0) {
			foundIngredient = ingredients.get(index);
		}
		return foundIngredient;
	}

	public Client searchClient(String name) {
		Client foundClient = null;
		boolean found = false;
		for(Client c: clients) {
			if(c.getName().equals(name) && !found) {
				foundClient = c;
				found = true;
			}
		}
		return foundClient;
	}

	public Employee searchEmployee(String name) {
		Employee foundEmployee = null;
		boolean found = false;
		for(Employee e: employees) {
			if(e.getName().equals(name) && !found) {
				foundEmployee = e;
				found = true;
			}
		}
		return foundEmployee;
	}

	public User searchUser(String username) {
		User foundUser = null;
		boolean found = false;
		for(User u: users) {
			if(u.getUsername().equals(username) && !found) {
				foundUser = u;
				found = true;
			}
		}
		return foundUser;
	}

	public int binarySearchForProductType(String name) {
		int pos = -1;
		int i = 0;
		int j = productTypes.size()-1;

		while(i <= j && pos < 0) {
			int middle = (i+j)/2;
			if(productTypes.get(middle).getName().compareTo(name) == 0) {
				pos = middle;
			}else if(productTypes.get(middle).getName().compareTo(name) > 0) {
				j = middle-1;
			}else {
				i = middle+1;
			}
		}
		return pos;
	}

	public int binarySearchForIngredient(String name) {
		int pos = -1;
		int i = 0;
		int j = ingredients.size()-1;

		while(i <= j && pos < 0) {
			int middle = (i+j)/2;
			if(ingredients.get(middle).getName().compareTo(name) == 0) {
				pos = middle;
			}else if(ingredients.get(middle).getName().compareTo(name) < 0) {
				j = middle-1;
			}else {
				i = middle+1;
			}
		}
		return pos;
	}

	//Add methods.

	public void addProduct(String name, ProductType productType, List<Ingredient> ingredients, ProductSize productSize, int price, User user) {
		Product product = new Product(name, productType, ingredients, productSize, price, user);
		products.add(product);
		sortProductByInsertion(products);
	}

	public void addProductType(String name, User user) {
		ProductType productType = new ProductType(name, user);
		productTypes.add(productType);
		Collections.sort(productTypes);
	}

	public void addIngredient(String name, User user) {
		Ingredient ingredient = new Ingredient(name, user);
		ingredients.add(ingredient);
		sortIngredientBySelection(ingredients);
	}

	public Client addClient(String name, String surname, int ID, String address, int phoneNumber, String observations, User user) {
		Client client = new Client(name, surname, ID, address, phoneNumber, observations, user);
		clients.add(client);
		sortClientBySurnameAndName();
		return client;
	}

	public Employee addEmployee(String name, String surname, int ID) {
		Employee employee = new Employee(name, surname, ID);
		employees.add(employee);
		sortEmployeeBySurnameAndName();
		return employee;
	}

	public void addUser(String name, String surname, int iD, String username, String password) {
		User user = searchUser(username);
		if(users.size() == 0 || user == null) {
			User newUser = new User(name, surname, iD, username, password);
			users.add(newUser);
			employees.add(newUser);
			sortUserByUsername();
			sortEmployeeBySurnameAndName();
		}
	}

	public void addOrder(OrderState orderstate, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoDelivered, LocalDateTime date, String observations, User user) {
		int orderCode = 0;
		Order order = new Order(orderCode, orderstate, products, quantity, client, employeeWhoDelivered, date, observations, user);
		orders.add(order);
		Collections.sort(orders);
	}
	
	public void addOrder(int orderCode, OrderState orderstate, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoDelivered, LocalDateTime date, String observations, User user) {
		Order order = new Order(orderCode, orderstate, products, quantity, client, employeeWhoDelivered, date, observations, user);
		orders.add(order);
		Collections.sort(orders);
	}

	//Delete methods.

	public void deleteProduct(Product product) {
		boolean canDelete = true;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getProducts().contains(product)) {
				canDelete = false;
			}
		}
		if(canDelete) {
			products.remove(product);
		}
	}

	public void deleteProductType(ProductType productType) {
		boolean canDelete = true;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductType() == productType) {
				canDelete = false;
			}
		}
		if(canDelete) {
			productTypes.remove(productType);
		}
	}

	public void deleteIngredient(Ingredient ingredient) {
		boolean canDelete = true;
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getIngredients().contains(ingredient)) {
				canDelete = false;
			}
		}
		if(canDelete) {
			ingredients.remove(ingredient);
		}
	}

	public void deleteClient(Client client) {
		boolean canDelete = true;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getClient() == client) {
				canDelete = false;
			}
		}
		if(canDelete) {
			clients.remove(client);
		}
	}

	public void deleteEmployee(Employee employee) {
		boolean canDelete = true;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getEmployeeWhoDelivered() == employee) {
				canDelete = false;
			}
		}
		if(canDelete) {
			employees.remove(employee);
		}
		if(employee instanceof User) {
			deleteUser((User)employee);
		}
	}

	public void deleteUser(User user) {
		boolean canDelete = true;
		for(int i = 0; i < orders.size(); i++) {
			if(orders.get(i).getUserWhoCreated() == user || orders.get(i).getLastUserWhoModified() == user) {
				canDelete = false;
			}
		}
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getUserWhoCreated() == user || products.get(i).getLastUserWhoModified() == user) {
				canDelete = false;
			}
		}
		for(int i = 0; i < clients.size(); i++) {
			if(clients.get(i).getUserWhoCreated() == user || clients.get(i).getLastUserWhoModified() == user) {
				canDelete = false;
			}
		}
		for(int i = 0; i < ingredients.size(); i++) {
			if(ingredients.get(i).getUserWhoCreated() == user || ingredients.get(i).getLastUserWhoModified() == user) {
				canDelete = false;
			}
		}
		for(int i = 0; i < productTypes.size(); i++) {
			if(productTypes.get(i).getUserWhoCreated() == user || productTypes.get(i).getLastUserWhoModified() == user) {
				canDelete = false;
			}
		}
		if(canDelete) {
			users.remove(user);
		}
	}

	public void deleteOrder(Order order) {
		orders.remove(order);
	}

	//Update methods.

	public void updateProduct(Product product, String name, ProductType productType, List<Ingredient> ingredients, ProductSize productSize, int price, User lastUserWhoModified) {
		product.setName(name);
		product.setProductType(productType);
		product.setIngredients(ingredients);
		product.setProductSize(productSize);
		product.setProductSize(productSize);
		product.setLastUserWhoModified(lastUserWhoModified);
	}

	public void updateProductType(ProductType productType, String name, User userWhoCreated, User lastUserWhoModified) {
		productType.setName(name);
		productType.setLastUserWhoModified(lastUserWhoModified);
	}

	public void updateIngredient(Ingredient ingredient, String name, User lastUserWhoModified) {
		ingredient.setName(name);
		ingredient.setLastUserWhoModified(lastUserWhoModified);
	}

	public void updateClient(Client client, String name, String surname, int ID, String address, int phoneNumber, String observations, User lastUserWhoModified) {
		client.setName(name);
		client.setSurname(surname);
		client.setID(ID);
		client.setAddress(address);
		client.setPhoneNumber(phoneNumber);
		client.setObservations(observations);
		client.setLastUserWhoModified(lastUserWhoModified);
	}

	public void updateEmployee(Employee employee, String name, String surname, int ID) {
		employee.setName(name);
		employee.setSurname(surname);
		employee.setID(ID);
	}

	public void updateUser(User user, String name, String surname, int iD, String username, String password) {
		updateEmployee(user, name, surname, iD);
		user.setUsername(username);
		user.setPassword(password);
	}

	public void updateOrder(Order order, int orderCode, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoDelivered, String observations, User lastUserWhoModified) {
		order.setOrderCode(orderCode);
		order.setProducts(products);
		order.setQuantity(quantity);
		order.setClient(client);
		order.setEmployeeWhoDelivered(employeeWhoDelivered);
		order.setObservations(observations);
		order.setLastUserWhoModified(lastUserWhoModified);
	}

	public void updateOrderState(Order order) {
		OrderState status = order.getOrderState();
		switch(status) {
		case Requested:
			status = OrderState.In_Process;
			break;
		case In_Process:
			status = OrderState.Sent;
			break;
		case Sent:
			status = OrderState.Delivered;
			break;
		case Delivered:
			status = OrderState.Delivered;
			break;
		}
		order.setOrderState(status);
	}

	//Disable methods.

	public void disableProduct(Product product, boolean option) {
		product.setDisabled(option);
	}

	public void disableProductType(ProductType productType, boolean option) {
		productType.setDisabled(option);
	}

	public void disableIngredient(Ingredient ingredient, boolean option) {
		ingredient.setDisabled(option);
	}

	public void disableClient(Client client, boolean option) {
		client.setDisabled(option);
	}

	public void disableEmployee(Employee employee, boolean option) {
		employee.setDisabled(option);
	}

	public void disableUser(User user, boolean option) {
		user.setDisabled(option);
	}

	//Report generating methods.

	public void generateOrderReport(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);

		//Pending

		pw.close();
	}

	public void generateEmployeeReport(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);

		//Pending

		pw.close();
	}

	public void generateProductReport(String fileName, String separator) throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(fileName);

		//Pending

		pw.close();
	}

	//Import methods.

	public void importClientData(String fileName, String separator) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/CLIENTS_DATA.csv"));

		String line = br.readLine();
		while(line != null) {
			String[] ClientsData = line.split(separator);
			String name = ClientsData[0];
			String surname = ClientsData[1];
			int ID = Integer.parseInt(ClientsData[2]);
			String address = ClientsData[3];
			int phoneNumber = Integer.parseInt(ClientsData[4]);
			String observations = ClientsData[5];
			addClient(name, surname, ID, address, phoneNumber, observations, actualUser);
			line = br.readLine();

		}

		br.close();
	}

	public void importProductData(String fileName, String separator) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/PRODUCTS_DATA.csv"));

		String line = br.readLine();
		while(line != null) {
			String[] productsData = line.split(separator);
			
			String name = productsData[0];
			
			ProductType productType = new ProductType(productsData[1], null);
			String[] ingredientList = productsData[2].split(",");
			for (int i = 0; i < ingredientList.length; i++) {
				addIngredient(ingredientList[i], actualUser);
			}
			
			String productSizeTxt = productsData[3]; 
			ProductSize productSize = ProductSize.Meal_Box_For_One;
			switch(productSizeTxt) {
			case "Caja personal": 
				productSize = ProductSize.Meal_Box_For_One;
				break;
			case "Caja para dos":
				productSize = ProductSize.Meal_Box_For_Two;
				break;
			}
			
			int price = Integer.parseInt(productsData[4]);
	
			addProduct(name, productType, ingredients, productSize, price, actualUser);
			line = br.readLine();

		}

		br.close();
	}

	public void importOrderData(String fileName, String separator) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader("data/ORDER_DATA.csv"));

		String line = br.readLine();
		while(line != null) {
			String[] ordersData = line.split(separator);
			
			int orderCode = Integer.parseInt(ordersData[0]);
			
			String orderStateTxt = ordersData[1];
			OrderState orderState = OrderState.Requested;
			switch(orderStateTxt) {
			case "Solicitado":
				orderState = OrderState.Requested;
				break;
			case "En proceso":
				orderState = OrderState.In_Process;
				break;
			case "Enviado":
				orderState = OrderState.Sent;
				break;
			case "Entregado":
				orderState = OrderState.Delivered;
				break;
			}
						
			List<Product> products = new ArrayList<Product>();
			String[] productsList = ordersData[2].split(",");
			
			List<Integer> quantity = new ArrayList<Integer>();
			String[] quantityList = ordersData[3].split(",");
			
			for (int i = 0; i < productsList.length; i++) {
				Product productFound = searchProduct(productsList[i]);
				if (productFound != null) {
					products.add(productFound);
					quantity.add(Integer.parseInt(quantityList[i]));
				}
			}
			
			String[] clientNameAndSurname = ordersData[4].split(" ");
			Client client = addClient(clientNameAndSurname[0], clientNameAndSurname[1], 0, "", 0, "", actualUser);
			
			String[] employeeNameAndSurname = ordersData[5].split(" ");
			Employee employee = addEmployee(employeeNameAndSurname[0], employeeNameAndSurname[1], 0);
			
			String[] dateInfo = ordersData[6].split("-");
			String[] dayAndTimeInfo = dateInfo[2].split(" ");
			String[] timeInfo = dayAndTimeInfo[1].split(":");
			LocalDateTime date = LocalDateTime.of(Integer.parseInt(dateInfo[0]), Integer.parseInt(dateInfo[1]), Integer.parseInt(dayAndTimeInfo[0]), Integer.parseInt(timeInfo[0]), Integer.parseInt(timeInfo[1]), Integer.parseInt(timeInfo[2]));
			
			String observations = ordersData[7];
			
			addOrder(orderCode, orderState, products, quantity, client, employee, date, observations, actualUser);
			line = br.readLine();
		}

		br.close();
	}
	
	

	//Save methods

	public void saveName() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(NAME_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveAddress() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ADDRESS_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveProducts() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCTS_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveProductTypes() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(PRODUCT_TYPES_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveIngredients() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(INGREDIENTS_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveClients() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(CLIENTS_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveEmployees() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EMPLOYEES_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveUsers() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(USERS_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	public void saveOrders() throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ORDERS_FILE_NAME));
		oos.writeObject(name);
		oos.close();
	}

	//Load methods.

	public boolean loadName() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(NAME_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			name = (String)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	public boolean loadAddress() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(ADDRESS_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			address = (String)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadProducts() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(PRODUCTS_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			products = (ArrayList<Product>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadProductTypes() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(PRODUCT_TYPES_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			productTypes = (ArrayList<ProductType>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadIngredients() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(INGREDIENTS_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			ingredients = (ArrayList<Ingredient>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadClients() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(CLIENTS_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			clients = (ArrayList<Client>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadEmployees() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(EMPLOYEES_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			employees = (ArrayList<Employee>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadUsers() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(USERS_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			users = (ArrayList<User>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	@SuppressWarnings("unchecked")
	public boolean loadOrders() throws NullPointerException, IOException, ClassNotFoundException, FileNotFoundException {
		File file = new File(ORDERS_FILE_NAME);
		boolean loaded = false;
		if(file.exists()) {
			ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
			orders = (ArrayList<Order>)ois.readObject();
			ois.close();
			loaded = true;
		}
		return loaded;
	}

	public boolean logIn(String username, String password) {
		boolean canLogIn = false;
		User user = searchUser(username);
		if(user != null && user.getPassword().equals(password)) {
			canLogIn = true;
			actualUser = user;
		}
		return canLogIn;
	}

}
