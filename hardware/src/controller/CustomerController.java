package controller;

import model.*;
import view.AlertBox;
import view.CustomerView;
import view.InputBox;

public class CustomerController extends Controller {

    public CustomerController(ShopData shopData) {
        this.shopData = shopData;
        this.inventory = shopData.getInventory();
        cart = new Cart();

        view = new CustomerView();
        customerView = (CustomerView)view;

        initTables();
        initControllers();
    }
    
    public CustomerController(Inventory inventory, Cart cart) {
        this.inventory = inventory;
        this.cart = cart;
        cart = new Cart();

        view = new CustomerView();
        customerView = (CustomerView)view;

        initTables();
        initControllers();
    }

    public void initControllers(){
        customerView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(shopData), e);
        });
        
        customerView.getAddButton().setOnAction(e ->{
        	int i = customerView.getProductTable().getSelectionModel().getSelectedIndex();
        	Product p = inventory.getProducts().get(i);
        	
        	InputBox inputBox = new InputBox("Add Quantity", "Please input how many items you wish to add to cart");
        	inputBox.getConfirmButton().setOnAction(event ->{
                try {
                	int num = Integer.parseInt(inputBox.getNumber().getText());
                	if(num < 0) {
                		AlertBox alertbox = new AlertBox("Error", "Please enter a positive number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                	else if(inventory.removeProduct(p, num)) {
                    	cart.addProduct(p, num);
                    	customerView.getProductTable().setInventory(inventory);
                    	customerView.getCartTable().setInventory(cart);
                    	customerView.getPriceLabel().setText("Total:    $" + String.format("%.2f", cart.getTotal()));
                    	inputBox.getWindow().close();
                    }
                	else {
                		AlertBox alertbox = new AlertBox("Error", "Not enough stock. Please input smaller number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                }
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
        
        customerView.getRemoveButton().setOnAction(e ->{
        	int i = customerView.getCartTable().getSelectionModel().getSelectedIndex();
        	Product p = cart.getProducts().get(i);
        	
        	InputBox inputBox = new InputBox("Remove Quantity", "Please input how many items you wish to remove from cart");
        	inputBox.getConfirmButton().setOnAction(event ->{
                try {
                	int num = Integer.parseInt(inputBox.getNumber().getText());
                	if(num < 0) {
                		AlertBox alertbox = new AlertBox("Error", "Please enter a positive number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
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
                	else {
                		AlertBox alertbox = new AlertBox("Error", "Not enough in cart. Please input smaller number");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                	}
                }
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
        
        customerView.getCheckoutButton().setOnAction(e ->{
            passControl(new ReceiptController(shopData, cart), e);
        });
    }

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
