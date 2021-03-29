package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

public class Order implements Comparable<Order>, Serializable{

	private static final long serialVersionUID = 1;
	
	private int orderCode;
	private OrderState orderState;
	private List<Product> products;
	private List<Integer> quantity;
	private Client client;
	private Employee employeeWhoDelivered;
	private LocalDateTime date;
	private String observations;
	private User userWhoCreated;
	private User lastUserWhoModified;
	private int price;

	public Order(int orderCode, OrderState orderstate, List<Product> products, List<Integer> quantity, Client client, Employee employeeWhoDelivered, LocalDateTime date, String observations, User user) {
		setOrderCode(orderCode);
		setOrderState(orderstate);
		setProducts(products);
		setQuantity(quantity);
		setClient(client);
		setEmployeeWhoDelivered(employeeWhoDelivered);
		setDate(date);
		setObservations(observations);
		userWhoCreated = user;
		lastUserWhoModified = user;
		setPrice();
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

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
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

	public String getOrderStateAsString() {
		OrderState status = getOrderState();
		String text = "";
		switch(status) {
		case Requested:
			text = "SOLICITADO";
			break;
		case In_Process:
			text = "EN PROCESO";
			break;
		case Sent:
			text = "ENVIADO";
			break;
		case Delivered:
			text = "ENTREGADO";
			break;
		}
		return text;
	}

	public String getProductsAsString() {
		String text;
		String[] products = new String[getProducts().size()];
		for(int i = 0; i < getProducts().size(); i++) {
			products[i] = getProducts().get(i).getName();
		}
		text = Arrays.toString(products)
				.replace("[", "")
				.replace("]", "");
		return text;
	}

	public String getQuantityAsString() {
		String text = Arrays.toString(getQuantity().toArray())
				.replace("[", "")
				.replace("]", "");
		return text;
	}

	public String getClientAsString() {
		String text = getClient().getName();
		return text;
	}
	public String getEmployeeAsString() {
		String text = getEmployeeWhoDelivered().getName();
		return text;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice() {
		price = 0;
		for(int i = 0; i < products.size(); i++) {
			price += products.get(i).getPrice()*quantity.get(i);
		}
	}

}
