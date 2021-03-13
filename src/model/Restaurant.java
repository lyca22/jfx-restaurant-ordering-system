package model;

import java.util.ArrayList;


public class Restaurant {
	String name;
	String address;
	ArrayList<Client> clients = new ArrayList<>();
	ArrayList<User> users = new ArrayList<>();
	ArrayList<Employee> employees  = new ArrayList<>();
	ArrayList<Order> orders = new ArrayList<>();
	ArrayList<Product> products = new ArrayList<>();
	public Restaurant(String name, String address, ArrayList<Client> clients, ArrayList<User> users, ArrayList<Employee> employees, ArrayList<Order> orders, ArrayList<Product> products) {
		this.name = name;
		this.address = address;
		this.clients = clients;
		this.users = users;
		this.employees = employees;
		this.orders = orders;
		this.products = products;
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
	public ArrayList<Client> getClients() {
		return clients;
	}
	public void setClients(ArrayList<Client> clients) {
		this.clients = clients;
	}
	public ArrayList<User> getUsers() {
		return users;
	}
	public void setUsers(ArrayList<User> users) {
		this.users = users;
	}
	public ArrayList<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(ArrayList<Employee> employees) {
		this.employees = employees;
	}
	public ArrayList<Order> getOrders() {
		return orders;
	}
	public void setOrders(ArrayList<Order> orders) {
		this.orders = orders;
	}
	public ArrayList<Product> getProducts() {
		return products;
	}
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}
	
	
}
