package controller;

import model.*;
import view.ReceiptView;

/**
 * 
 * Controller that communicates between receipt and receipt view
 *
 */
public class ReceiptController extends Controller {
	
	/**
	 * Constructor
	 * @param shopData data to be passed through application
	 * @param cart the cart that was purchased
	 */
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
	
	/**
	 * initializes all button controllers
	 */
	private void initControllers() {
		//go back to customer screen
		receiptView.getBackButton().setOnAction(e ->{
            passControl(new CustomerController(inventory, cart), e);
        });
		
		//confirm purchase
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

	/**
	 * initializes the table and labels 
	 */
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
