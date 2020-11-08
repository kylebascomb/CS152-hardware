package model;

import java.util.ArrayList;

public class Cart extends Inventory {
	
	public Cart(ArrayList<Product> products) {
		super(products);
	}
	
	public Cart() {
		super();
	}
	
	public float getTotal() {
		float total = 0;
		for(Product p : super.getProducts()) {
			total += (float)p.getQuantity() * p.getPrice();
		}
		return total;
	}

}
