package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Inventory of store. Stores products
 *
 */
public class Inventory implements Serializable {

	/**
	 * Constructor with set of products
	 * @param products initial set of products
	 */
	public Inventory(ArrayList<Product> products) {
		this.products = products;
	}
	
	/**
	 * base constructor for fresh inventory
	 */
	public Inventory(){
		products = new ArrayList<>();
	}
	
	/**
	 * return size of inventory
	 * @return size of inventory
	 */
	public int getSize(){
		return products.size();
	}
	
	/**
	 * Returns product with given id
	 * @param productID id of desired product
	 * @return product with id
	 */
	public Product getProduct(int productID){
		//searches through array list for product with given id
		for(Product product: products){
			if(product.getProductId() == productID){
				return product;
			}
		}
		return null;
	}

	/**
	 * Adds product straight to inventory
	 * @param product product to be added
	 */
	public void addProduct(Product product){
		products.add(product.clone());
	}
	
	/**
	 * Adds certain amount of given product. If product exists
	 * it adds the quantity and adds new product if none else exists.
	 * @param product product to be added
	 * @param amount amount to be added
	 */
	public void addProduct(Product product, int amount) {
		int index = -1;
		int id = product.getProductId();
		//searches through ivnentory to find product with same id
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductId() == id) {
				index = i;
				i = products.size();
			}
		}
		//updates quantity if product found
		if(index > -1) {
			Product p = products.get(index);
			p.setQuantity(p.getQuantity() + amount);
		}
		//adds new product if none found
		else {
			Product temp = product.clone();
			temp.setQuantity(amount);
			addProduct(temp);
		}
	}

	/**
	 * removes product 
	 * @param product product to be removed
	 */
	public void removeProduct(Product product){
		products.remove(product);
	}
	
	/**
	 * Removes a certain amount of product fro inventory
	 * @param product product to be removed
	 * @param amount amount to be removed
	 * @return true if there is enough of product to remove or false otherwise
	 */
	public boolean removeProduct(Product product, int amount) {
		int index = -1;
		int id = product.getProductId();
		//tries to find product
		for(int i = 0; i < products.size(); i++) {
			if(products.get(i).getProductId() == id) {
				index = i;
				i = products.size();
			}
		}
		//if item found tries to remove quantity
		if(index > -1) {
			Product p = products.get(index);
			//removes if enough quantity
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
