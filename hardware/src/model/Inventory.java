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

	private ArrayList<Product> products;

}
