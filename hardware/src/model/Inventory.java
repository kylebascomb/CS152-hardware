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



	public Product getProduct(int productID){
		//TODO optimize this?
		for(Product product: products){
			if(product.getProductId() == productID){
				return product;
			}
		}
		return null;
	}


	public void addProduct(Product product){
		products.add(product.clone());
	}
	
	
	public void addProduct(Product product, int amount) {
		int index = -1;
		int id = product.getProductId();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductId() == id) {
				index = i;
				i = products.size();
			}
		}
		if(index > -1) {
			Product p = products.get(index);
			p.setQuantity(p.getQuantity() + amount);
		}
		else {
			Product temp = product.clone();
			temp.setQuantity(amount);
			addProduct(temp);
		}
	}

	
	public void removeProduct(Product product){
		products.remove(product);
	}
	
	
	public boolean removeProduct(Product product, int amount) {
		int index = -1;
		int id = product.getProductId();
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductId() == id) {
				index = i;
				i = products.size();
			}
		}
		if(index > -1) {
			Product p = products.get(index);
			if(p.getQuantity() >= amount) {
				p.setQuantity(p.getQuantity() - amount);
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
