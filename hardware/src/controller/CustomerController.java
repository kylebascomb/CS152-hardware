package controller;

import model.*;
import view.AlertBox;
import view.CustomerView;
import view.InputBox;

/**
 * 
 * Controller responsible for communicating between customer view and the inventory/cart
 *
 */
public class CustomerController extends Controller {

	/**
	 * Constructor
	 * @param shopData data that must be passed along program
	 */
    public CustomerController(ShopData shopData) {
        this.shopData = shopData;
        this.inventory = shopData.getInventory();
        cart = new Cart();

        view = new CustomerView();
        customerView = (CustomerView)view;

        initTables();
        initControllers();
    }
    
    /**
     * Controller
     * @param inventory
     * @param cart
     */
    public CustomerController(Inventory inventory, Cart cart) {
        this.inventory = inventory;
        this.cart = cart;
        cart = new Cart();

        view = new CustomerView();
        customerView = (CustomerView)view;

        initTables();
        initControllers();
    }

    /**
     * initializes all button controllers 
     */
    public void initControllers(){
    	//go back to main menu
        customerView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(shopData), e);
        });
        
        //add item to cart
        customerView.getAddButton().setOnAction(e ->{
        	int i = customerView.getProductTable().getSelectionModel().getSelectedIndex();
        	Product p = inventory.getProducts().get(i);
        	
        	//asks for input in how many items to add
        	InputBox inputBox = new InputBox("Add Quantity", "Please input how many items you wish to add to cart");
        	inputBox.getConfirmButton().setOnAction(event ->{
                try {
                	int num = Integer.parseInt(inputBox.getNumber().getText());
                	//checks to see if value is negative an dinvalid
                	if(num <= 0) {
                		AlertBox alertbox = new AlertBox("Error", "Please enter a positive number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                	//tries to remove given amount from inventory and updates tables and price if successful
                	else if(inventory.removeProduct(p, num)) {
                    	cart.addProduct(p, num);
                    	customerView.getProductTable().setInventory(inventory);
                    	customerView.getCartTable().setInventory(cart);
                    	customerView.getPriceLabel().setText("Total:    $" + String.format("%.2f", cart.getTotal()));
                    	inputBox.getWindow().close();
                    }
                	//if failed to remove, ask for another input
                	else {
                		AlertBox alertbox = new AlertBox("Error", "Not enough stock. Please input smaller number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                }
                //catches non integer inputs
                catch(NumberFormatException nfe) {
                	AlertBox alertbox = new AlertBox("Error", "Please input a whole number");
                    alertbox.getCloseButton().setOnAction(ev ->{
                        alertbox.getWindow().close();
                    });
                    alertbox.display();
                }
            });
        	inputBox.display();
        });
        
        //remove item from cart
        customerView.getRemoveButton().setOnAction(e ->{
        	int i = customerView.getCartTable().getSelectionModel().getSelectedIndex();
        	Product p = cart.getProducts().get(i);
        	
        	//asks for amount to be removed from ccart
        	InputBox inputBox = new InputBox("Remove Quantity", "Please input how many items you wish to remove from cart");
        	inputBox.getConfirmButton().setOnAction(event ->{
                try {
                	int num = Integer.parseInt(inputBox.getNumber().getText());
                	//checks for invalid input of negative number
                	if(num < 0) {
                		AlertBox alertbox = new AlertBox("Error", "Please enter a positive number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                	//tries to remove product from cart and updates tables if successful
                	else if(cart.removeProduct(p, num)) {
                		if(p.getQuantity() == 0) {
                			cart.removeProduct(p);
                		}
                    	inventory.addProduct(p, num);
                    	customerView.getProductTable().setInventory(inventory);
                    	customerView.getCartTable().setInventory(cart);
                    	customerView.getPriceLabel().setText("Total:    $" + String.format("%.2f", cart.getTotal()));
                    	inputBox.getWindow().close();
                    }
                	//if can't remove from cart it asks for a smaller input
                	else {
                		AlertBox alertbox = new AlertBox("Error", "Not enough in cart. Please input smaller number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                }
                //catches non integer input
                catch(NumberFormatException nfe) {
                	AlertBox alertbox = new AlertBox("Error", "Please input a whole number");
                    alertbox.getCloseButton().setOnAction(ev ->{
                        alertbox.getWindow().close();
                    });
                    alertbox.display();
                }
            });
        	inputBox.display();
        });
        
        //procede to checkout
        customerView.getCheckoutButton().setOnAction(e ->{
            passControl(new ReceiptController(shopData, cart), e);
        });
    }

    /**
     * initializes tables
     */
    public void initTables(){
        customerView.getProductTable().setInventory(inventory);
        customerView.getProductTable().addNameColumn();
        customerView.getProductTable().addPriceColumn();
        customerView.getProductTable().addQuantityColumn();
        
        customerView.getCartTable().setInventory(cart);
        customerView.getCartTable().addNameColumn();
        customerView.getCartTable().addPriceColumn();
        customerView.getCartTable().addQuantityColumn();
        
        customerView.getPriceLabel().setText(customerView.getPriceLabel().getText() + "0.00");
    }

    private CustomerView customerView;
    private Inventory inventory;
    private ShopData shopData;
    private Cart cart;
}
