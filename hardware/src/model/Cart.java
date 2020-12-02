package model;

import java.util.ArrayList;

/**
 * 
 * Holds a collection of products to be purchased
 *
 */
public class Cart extends Inventory {
	
	/**
	 * Constructor with initial set of products
	 * @param products initial set of products
	 */
	public Cart(ArrayList<Product> products) {
		super(products);
	}
	
	/**
	 * Base Constructor
	 */
	public Cart() {
		super();
	}
	
	/**
	 * Returns total price of all items in the cart
	 * @return total price of items in cart
	 */
	public float getTotal() {
		float total = 0;
		//goes through every product and  adds product of quantity and price to total
		for(Product p : super.getProducts()) {
			total += (float)p.getQuantity() * p.getPrice();
		}
		return total;
	}

}
