package model;

import java.util.Date;
import java.util.List;

public class Order implements Comparable<Order>{
	
	private int orderCode;
	private OrderState orderState;
	private List<Product> products;
	private List<Integer> quantity;
	private Client client;
	private Employee employeeWhoDelivered;
	private Date date;
	private String observations;
	private User userWhoCreated;
	private User lastUserWhoModified;
	
	public Order(int orderCode, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoDelivered, Date date, String observations, User user) {
		setOrderCode(orderCode);
		setOrderState(OrderState.Requested);
		setProducts(products);
		setQuantity(quantity);
		setClient(client);
		setEmployeeWhoDelivered(employeeWhoDelivered);
		setDate(date);
		setObservations(observations);
		userWhoCreated = user;
		lastUserWhoModified = user;
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

	public Employee getEmployeeWhoDelivered() {
		return employeeWhoDelivered;
	}

	public void setEmployeeWhoDelivered(Employee employeeWhoDelivered) {
		this.employeeWhoDelivered = employeeWhoDelivered;
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

	public User getUserWhoCreated() {
		return userWhoCreated;
	}

	public void setUserWhoCreated(User userWhoCreated) {
		this.userWhoCreated = userWhoCreated;
	}

	public User getLastUserWhoModified() {
		return lastUserWhoModified;
	}

	public void setLastUserWhoModified(User lastUserWhoModified) {
		this.lastUserWhoModified = lastUserWhoModified;
	}

	@Override
	public int compareTo(Order o) {
		return orderCode - o.getOrderCode();
	}
	
}
