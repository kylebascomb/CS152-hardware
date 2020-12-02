package view.components;

import model.Inventory;
import view.components.ProductTableView;

/**
 * 
 * Extension of product table except for cart
 *
 */
public class CartTableView extends ProductTableView {
	
	/**
	 * Constructor
	 * @param inventory inventory to be passsed
	 */
	public CartTableView(Inventory inventory) {
		super(inventory);
		super.titleColumn.setText("Cart");
	}
	
	/**
	 * Constructor
	 */
	public CartTableView() {
		super();
		super.titleColumn.setText("Cart");
	}

}
