package model;

import java.util.List;

public class Order {
	
	private int orderCode;
	private OrderState orderState;
	private List<Product> products;
	private List<Integer> quantity;
	private Client client;
	private Employee employeeWhoServed;
	private Date date;
	private String observations;
	
	public Order(int orderCode, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoServed, Date date, String observations) {
		setOrderCode(orderCode);
		setOrderState(OrderState.Requested);
		setProducts(products);
		setQuantity(quantity);
		setClient(client);
		setEmployeeWhoServed(employeeWhoServed);
		setDate(date);
		setObservations(observations);
	}

	public int getOrderCode() {
		return orderCode;
	}

	public void setOrderCode(int orderCode) {
		this.orderCode = orderCode;
	}

	public OrderState getOrderState() {
		return orderState;
	}

	public void setOrderState(OrderState orderState) {
		this.orderState = orderState;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Employee getEmployeeWhoServed() {
		return employeeWhoServed;
	}

	public void setEmployeeWhoServed(Employee employeeWhoServed) {
		this.employeeWhoServed = employeeWhoServed;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getObservations() {
		return observations;
	}

	public void setObservations(String observations) {
		this.observations = observations;
	}
	
}
