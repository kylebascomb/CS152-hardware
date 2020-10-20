package controller;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import model.Inventory;
import model.Product;
import view.AdminView;

public class AdminController extends Controller {

    public AdminController(Inventory inventory) {
        this.inventory = inventory;

        view = new AdminView();
        adminView = (AdminView)view;

        initControllers();

        //TESTING
        System.out.print(inventory.getSize());
    }

    public void initControllers(){
        adminView.getBackButton().setOnAction(e ->{
            //TEMPORARY TESTING
            inventory.addProduct(new Product("Test Product", 20));


            passControl(new StartupController(inventory), e);
        });
    }


    private AdminView adminView;
    private Inventory inventory;
}
