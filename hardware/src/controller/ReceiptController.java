package controller;

import model.Cart;
import model.Inventory;
import model.Product;
import view.ReceiptView;

public class ReceiptController extends Controller {
	
	public ReceiptController(Inventory inventory, Cart cart) {
		this.inventory = inventory;
		this.cart = cart;
		total=0;
		
		receiptView = new ReceiptView();
		view = receiptView;
		
		initComponents();
		initControllers();
	}
	
	private void initControllers() {
		receiptView.getBackButton().setOnAction(e ->{
            passControl(new CustomerController(inventory, cart), e);
        });
		
		receiptView.getSaveButton().setOnAction(e ->{
			//Saves all data
            StartupController startupController = new StartupController(inventory);
            startupController.saveAllData();
            //passes control
            passControl(startupController, e);
        });
		
	}

	private void initComponents() {
		receiptView.getCartTable().setInventory(cart);
		receiptView.getCartTable().addNameColumn();
		receiptView.getCartTable().addPriceColumn();
		receiptView.getCartTable().addQuantityColumn();
		
		for(Product p : cart.getProducts()) {
			total += p.getPrice() * p.getQuantity();
		}
		receiptView.getTotal().setText(receiptView.getTotal().getText() + total);
	}

	private ReceiptView receiptView;
	private Inventory inventory;
	private Cart cart;
	private float total;
}
