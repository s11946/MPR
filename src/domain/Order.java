package domain;

import java.util.List;

public class Order extends Entity {
	
	private String orderID;
	private String date;
	private Client client;
	private List<Sail> sails;
	
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	public List<Sail> getSails() {
		return sails;
	}
	public void setSails(List<Sail> sails) {
		this.sails = sails;
	}
	
	

}
