package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.layout.HBox;
import model.Inventory;
import model.Product;
import view.AdminView;
import view.AlertBox;

public class AdminController extends Controller {

    public AdminController(Inventory inventory) {
        this.inventory = inventory;

        view = new AdminView();
        adminView = (AdminView)view;

        initTable();
        initControllers();

        //TESTING
        System.out.print(inventory.getSize());
    }

    public void initControllers(){
        adminView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(inventory), e);
        });

        // add Product
        adminView.getAddProductBox().getAddButton().setOnAction(e ->{
            String name = adminView.getAddProductBox().getNameField().getText();
            String productId = adminView.getAddProductBox().getproductIdField().getText();
            String price = adminView.getAddProductBox().getPriceField().getText();
            String type = adminView.getAddProductBox().getTypeField().getText();
            String quantity = adminView.getAddProductBox().getQuantityField().getText();
            String description = adminView.getAddProductBox().getDescriptionField().getText();

            addProduct(name, price, type, quantity, description, productId);

            clearProductBox();


            adminView.getProductTable().setInventory(inventory);
        });


        // edit product
        adminView.getAddProductBox().getEditButton().setOnAction(e ->{
            String name = adminView.getAddProductBox().getNameField().getText();
            String productId = adminView.getAddProductBox().getproductIdField().getText();
            String price = adminView.getAddProductBox().getPriceField().getText();
            String type = adminView.getAddProductBox().getTypeField().getText();
            String quantity = adminView.getAddProductBox().getQuantityField().getText();
            String description = adminView.getAddProductBox().getDescriptionField().getText();

            //TODO error checking
            Product product = inventory.getProduct(Integer.parseInt(productId));
            if(product != null){
                product.setName(name);
                product.setPrice(Float.parseFloat(price));
                product.setType(type);
                product.setQuantity(Integer.parseInt(quantity));
                product.setDescription(description);
            }

            adminView.getProductTable().setInventory(inventory);
        });

        // delete product
        adminView.getAddProductBox().getDeleteButton().setOnAction(e ->{
            String productId = adminView.getAddProductBox().getproductIdField().getText();
            Product product = inventory.getProduct(Integer.parseInt(productId));

            AlertBox alertBox = new AlertBox("Product Deletion", "Warning, you are about to permanently delete a product");

            alertBox.getCloseButton().setOnAction(event ->{
                inventory.removeProduct(product);
                alertBox.getWindow().close();
            });

            alertBox.display();

            adminView.getProductTable().setInventory(inventory);
        });

        // get info from selected product
        adminView.getProductTable().setRowFactory(e ->{
            TableRow<Product> row = new TableRow();
            row.setOnMouseClicked(event ->{
                selectedProduct = row.getItem();
                adminView.getAddProductBox().getNameField().setText(selectedProduct.getName());
                adminView.getAddProductBox().getproductIdField().setText(Integer.toString(selectedProduct.getProductId()));
                adminView.getAddProductBox().getTypeField().setText(selectedProduct.getType());
                adminView.getAddProductBox().getPriceField().setText(Float.toString(selectedProduct.getPrice()));
                adminView.getAddProductBox().getQuantityField().setText(Integer.toString(selectedProduct.getQuantity()));
                adminView.getAddProductBox().getDescriptionField().setText(selectedProduct.getDescription());
            });
            return row;
        });
    }

    public void clearProductBox(){
        adminView.getAddProductBox().getNameField().clear();
        adminView.getAddProductBox().getproductIdField().clear();
        adminView.getAddProductBox().getTypeField().clear();
        adminView.getAddProductBox().getPriceField().clear();
        adminView.getAddProductBox().getQuantityField().clear();
        adminView.getAddProductBox().getDescriptionField().clear();
    }

    public void addProduct(String name, String price, String type, String quantity, String description, String productId){
        //TODO error checking
    	Integer trueId = Integer.parseInt(productId);
        Float truePrice = Float.parseFloat(price);
        Integer trueQuantity = Integer.parseInt(quantity);
        inventory.addProduct(new Product(name, truePrice, trueQuantity, description, type, trueId));
    }

    public void initTable(){
        adminView.getProductTable().setInventory(inventory);
        adminView.getProductTable().addNameColumn();
        adminView.getProductTable().addProductIdColumn();
        adminView.getProductTable().addPriceColumn();
        adminView.getProductTable().addTypeColumn();
        adminView.getProductTable().addQuantityColumn();
        adminView.getProductTable().addDescriptionColumn();
    }



    private Product selectedProduct;
    private AdminView adminView;
    private Inventory inventory;
}
