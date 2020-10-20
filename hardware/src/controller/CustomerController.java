package controller;

import model.*;
import view.CustomerView;

public class CustomerController extends Controller {

    public CustomerController(Inventory inventory) {
        this.inventory = inventory;
        cart = new Cart();

        view = new CustomerView();
        customerView = (CustomerView)view;

        initTables();
        initControllers();
    }

    public void initControllers(){
        customerView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(inventory), e);
        });
        
        customerView.getAddButton().setOnAction(e ->{
        	int i = customerView.getProductTable().getSelectionModel().getSelectedIndex();
        	Product p = inventory.getProducts().get(i);
        	//only add to cart if the item has stock
            if(inventory.removeProduct(p, 1)) {
            	cart.addProduct(p, 1);
            	customerView.getProductTable().setInventory(inventory);
            	customerView.getCartTable().setInventory(cart);
            }
        });
        
        customerView.getRemoveButton().setOnAction(e ->{
        	int i = customerView.getCartTable().getSelectionModel().getSelectedIndex();
        	Product p = cart.getProducts().get(i);
        	//only add to inventory if stuff in cart
        	if(cart.removeProduct(p, 1)) {
        		if(p.getQuantity() == 0) {
        			cart.removeProduct(p);
        		}
            	inventory.addProduct(p, 1);
            	customerView.getProductTable().setInventory(inventory);
            	customerView.getCartTable().setInventory(cart);
            }
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
    }

    private CustomerView customerView;
    private Inventory inventory;
    private Cart cart;
}
