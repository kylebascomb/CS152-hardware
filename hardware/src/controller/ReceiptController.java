package controller;

import java.time.LocalDateTime;

import model.*;
import view.ReceiptView;

public class ReceiptController extends Controller {
	
	public ReceiptController(ShopData shopData, Cart cart) {
		this.shopData = shopData;
		this.inventory = shopData.getInventory();
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
            StartupController startupController = new StartupController(shopData);
            startupController.saveAllData();
            //adds receipt to report
			shopData.getReport().addReceipt(receipt);
            //passes control
            passControl(startupController, e);
        });
		
	}

	private void initComponents() {
		receiptView.getCartTable().setInventory(cart);
		receiptView.getCartTable().addNameColumn();
		receiptView.getCartTable().addPriceColumn();
		receiptView.getCartTable().addQuantityColumn();
		
		receiptView.getTotal().setText(receiptView.getTotal().getText() + String.format("%.2f", receipt.getTotal()));
		receiptView.getDateTime().setText(receipt.getTimeStamp());
		}

	private ReceiptView receiptView;
	private Inventory inventory;
	private Cart cart;
	private Receipt receipt;
	private ShopData shopData;
}
