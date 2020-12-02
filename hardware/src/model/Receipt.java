package model;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Receipt implements Serializable{
	
	/**
	 * Constructor 
	 * @param cart cart that is purchased for given receipt
	 */
	public Receipt(Cart cart) {
		datetime = LocalDateTime.now();
		timeStamp = computeTimestamp();
		this.cart = cart;
		total=0;
		for(Product p : cart.getProducts()) {
			total += p.getPrice() * (float)p.getQuantity();
		}
	}
	
	/**
	 * Returns formatted timestamp string
	 * @return formatted timestamp string
	 */
	public String computeTimestamp() {
		return datetime.getHour() + ":" + datetime.getMinute() + " "
				+ datetime.getMonth() + " " + datetime.getDayOfMonth()
				+ ", " + datetime.getYear();
	}
	
	/**
	 * returns cart
	 * @return cart
	 */
	public Cart getCart() {
		return cart;
	}
	
	/**
	 * returns total price
	 * @return total price
	 */
	public float getTotal() {
		return total;
	}
	
	/**
	 * returns datetime
	 * @return datetime
	 */
	public LocalDateTime getDateTime() {
		return datetime;
	}
	
	/**
	 * Returns timestamp
	 * @return timestamp
	 */
	public String getTimeStamp() {
		return timeStamp;
	}
	
	/**
	 * Sets timestamp
	 * @param timeStamp timestamp to be set
	 */
	public void setTimeStamp(String timeStamp) {
		this.timeStamp = timeStamp;
	}

	private Cart cart;
	private float total;
	private LocalDateTime datetime;
	private String timeStamp;

}
