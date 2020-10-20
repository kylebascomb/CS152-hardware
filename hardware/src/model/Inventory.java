package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Inventory implements Serializable {

	public Inventory(ArrayList<Product> products) {
		this.products = products;
	}

	public Inventory(){
		products = new ArrayList<>();
	}


	public int getSize(){
		return products.size();
	}



	public void addProduct(Product product){
		products.add(product);
	}

	public void removeProduce(Product product){
		products.remove(product);
	}


	/**
	 * Getter for products
	 *
	 * @return products
	 */
	public ArrayList<Product> getProducts() {
		return products;
	}

	/**
	 * Setter for products
	 *
	 * @param products - products
	 */
	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	private ArrayList<Product> products;

}
