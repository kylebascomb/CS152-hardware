package controller;

import java.time.LocalDateTime;

import model.Cart;
import model.Inventory;
import model.Product;
import model.Receipt;
import view.ReceiptView;

public class ReceiptController extends Controller {
	
	public ReceiptController(Inventory inventory, Cart cart) {
		this.inventory = inventory;
		this.cart = cart;
		receipt = new Receipt(cart);
		
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
		
		receiptView.getTotal().setText(receiptView.getTotal().getText() + receipt.getTotal());
		receiptView.getDateTime().setText(receipt.getTimestamp());
		}

	private ReceiptView receiptView;
	private Inventory inventory;
	private Cart cart;
	private Receipt receipt;
}
