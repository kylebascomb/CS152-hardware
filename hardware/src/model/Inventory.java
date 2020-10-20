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

		//TODO Automatically assign productId
		product.setProductId(1);
	}
	
	
	public void addProduct(Product product, int amount) {
		int index = products.indexOf(product);
		if(index > -1) {
			product.setQuantity(product.getQuantity() + amount);
		}
		else {
			product.setQuantity(amount);
			addProduct(product);
		}
	}

	
	public void removeProduct(Product product){
		products.remove(product);
	}
	
	
	public boolean removeProduct(Product product, int amount) {
		int index = products.indexOf(product);
		if(index > -1) {
			if(product.getQuantity() >= amount) {
				product.setQuantity(product.getQuantity() - amount);
				return true;
			}
			return false;
		}
		return false;
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
