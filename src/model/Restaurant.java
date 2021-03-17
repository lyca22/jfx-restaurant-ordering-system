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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
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

	//Sort Methods
	
		public void sortBySurnameClient() {
			Comparator<Client> clientComparator = new ClientSurnameComparator();
			Collections.sort(clients, clientComparator);
		}
	
	//Add methods
	
	public void addProduct(String name, ProductType productType, List<Ingredient> ingredients, ProductSize productSize, int price, User user) {
		Product product = new Product(name, productType, ingredients, productSize, price, user);
		products.add(product);
		Collections.sort(products);
	}

	public void addProductType(String name, User user) {
		ProductType productType = new ProductType(name, user);
		productTypes.add(productType);
		Collections.sort(productTypes);
	}

	public void addIngredient(String name, User user) {
		Ingredient ingredient = new Ingredient(name, user);
		ingredients.add(ingredient);
		Collections.sort(ingredients);
	}

	public void addClient(String name, String surname, int ID, String address, int phoneNumber, String observations, User user) {
		Client client = new Client(name, surname, ID, address, phoneNumber, observations, user);
		clients.add(client);
		sortBySurnameClient();
	}
	

	public void addEmployee(String name, String surname, int ID) {
		Employee employee = new Employee(name, surname, ID);
		employees.add(employee);
		Collections.sort(employees);
	}

	public void addUser(String name, String surname, int iD, String username, String password) {
		User user = new User(name, surname, iD, username, password);
		users.add(user);
		Collections.sort(users);
	}

	public void addOrder(int orderCode, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoDelivered, Date date, String observations, User user) {
		Order order = new Order(orderCode, products, quantity, client, employeeWhoDelivered, date, observations, user);
		orders.add(order);
		Collections.sort(orders);
	}
	
	

	//Delete methods
	
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

	
	
	//Update methods
	
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
	
	
	
	//Disable methods

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
	
	

	//Generate reports methods
	
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
	

	//Import methods
	
	public void importClientData(String fileName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		//Pending
		
		br.close();
	}

	public void importProductData(String fileName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		//Pending
		
		br.close();
	}

	public void importOrderData(String fileName) throws FileNotFoundException, IOException {
		BufferedReader br = new BufferedReader(new FileReader(fileName));
		
		//Pending
		
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
	

	//Load methods
	
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


}
