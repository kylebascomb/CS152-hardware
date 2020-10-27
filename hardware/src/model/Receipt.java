package model;

import java.time.LocalDateTime;

public class Receipt {
	
	public Receipt(Cart cart) {
		datetime = LocalDateTime.now();
		this.cart = cart;
		total=0;
		for(Product p : cart.getProducts()) {
			total += p.getPrice() * p.getQuantity();
		}
	}
	
	public String getTimestamp() {
		return datetime.getHour() + ":" + datetime.getMinute() + " "
				+ datetime.getMonth() + " " + datetime.getDayOfMonth()
				+ ", " + datetime.getYear();
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public float getTotal() {
		return total;
	}
	
	public LocalDateTime getDateTime() {
		return datetime;
	}
	
	private Cart cart;
	private float total;
	private LocalDateTime datetime;

}
