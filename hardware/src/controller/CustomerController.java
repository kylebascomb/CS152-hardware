package controller;

import model.Inventory;
import view.CustomerView;

public class CustomerController extends Controller {

    public CustomerController(Inventory inventory) {
        this.inventory = inventory;

        view = new CustomerView();
        customerView = (CustomerView)view;

        initTables();
        initControllers();
    }

    public void initControllers(){
        customerView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(inventory), e);
        });
    }

    public void initTables(){
        customerView.getProductTable().setInventory(inventory);
        customerView.getProductTable().addNameColumn();
        customerView.getProductTable().addPriceColumn();
        customerView.getProductTable().addQuantityColumn();
    }

    private CustomerView customerView;
    private Inventory inventory;
}
