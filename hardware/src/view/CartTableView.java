package view;

import model.Inventory;

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
