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
            passControl(new StartupController(inventory), e);
        });

        adminView.getAddProductBox().getAddButton().setOnAction(e ->{
            String name = adminView.getAddProductBox().getNameField().getText();
            String price = adminView.getAddProductBox().getPriceField().getText();
            String type = adminView.getAddProductBox().getTypeField().getText();
            String quantity = adminView.getAddProductBox().getQuantityField().getText();
            String description = adminView.getAddProductBox().getDescriptionField().getText();

            addProduct(name, price, type, quantity, description);


            adminView.getAddProductBox().getNameField().clear();
            adminView.getAddProductBox().getTypeField().clear();
            adminView.getAddProductBox().getPriceField().clear();
            adminView.getAddProductBox().getQuantityField().clear();
            adminView.getAddProductBox().getDescriptionField().clear();
        });
    }

    public void addProduct(String name, String price, String type, String quantity, String description){
        //TODO error checking
        Float truePrice = Float.parseFloat(price);
        Integer trueQuantity = Integer.parseInt(quantity);
        inventory.addProduct(new Product(name, truePrice, trueQuantity, description, type));
    }



    private AdminView adminView;
    private Inventory inventory;
}
