package view.components;

import model.Inventory;
import view.components.ProductTableView;

public class CartTableView extends ProductTableView {
	
	public CartTableView(Inventory inventory) {
		super(inventory);
		super.titleColumn.setText("Cart");
	}
	
	public CartTableView() {
		super();
		super.titleColumn.setText("Cart");
	}

}
