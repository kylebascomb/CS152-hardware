package controller;

import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import model.*;
import view.AdminView;
import view.AlertBox;

/**
 * 
 * Class responsible for communicating between the admin views and the model
 *
 */
public class AdminController extends Controller {

    /**
     * Constructor
     * @param shopData - data passed around controllers
     */
    public AdminController(ShopData shopData) {
        this.shopData = shopData;
        this.inventory = shopData.getInventory();
        this.report = shopData.getReport();

        view = new AdminView();
        adminView = (AdminView)view;

        initControllers();
    }

    /**
     * initializes all the components
     */
    public void initControllers(){
        initTable();
        initMenu();
        initInventoryControllers();
        initReportControllers();

        adminView.getBackButton().setOnAction(e ->{
            //Saves all data
            StartupController startupController = new StartupController(shopData);
            startupController.saveAllData();
            //passes control
            passControl(startupController, e);
        });


    }

    /**
     * Initializes the components of the inventory section of admin view
     */
    public void initInventoryControllers(){
        // add Product
        adminView.getAddProductBox().getAddButton().setOnAction(e ->{
            String name = adminView.getAddProductBox().getNameField().getText();
            String productId = adminView.getAddProductBox().getproductIdField().getText();
            String price = adminView.getAddProductBox().getPriceField().getText();
            String type = adminView.getAddProductBox().getTypeField().getText();
            String quantity = adminView.getAddProductBox().getQuantityField().getText();
            String description = adminView.getAddProductBox().getDescriptionField().getText();

             //checks for null or noninteger values where they shouldn't be
            int id = -1;
            try {
            	id = Integer.parseInt(productId);
            }
            catch(NumberFormatException nfe1) {
            	AlertBox alertbox = new AlertBox("Error", "Please input integers for productId and make sure all fields are filled out");
                alertbox.getCloseButton().setOnAction(ev ->{
                    alertbox.getWindow().close();
                });
                alertbox.display();
            }
            if(id != -1) {
            //check for duplicate product in inventory
            Product product2 = inventory.getProduct(id);
            if(product2 == null){
            	///if no duplicate add product
            	try {
            	 addProduct(name, price, type, quantity, description, productId);
                 clearProductBox();
            	}
            	//check for non integers or floats where they should be
            	catch(NumberFormatException nfe) {
            		AlertBox alertbox = new AlertBox("Error", "Please input integers for quantity and decimal value for price");
                    alertbox.getCloseButton().setOnAction(ev ->{
                        alertbox.getWindow().close();
                    });
                    alertbox.display();
            	}
            	//check for null values
            	catch(NullPointerException npe) {
            		AlertBox alertbox = new AlertBox("Error", "Please fill out all fields");
                    alertbox.getCloseButton().setOnAction(ev ->{
                        alertbox.getWindow().close();
                    });
                    alertbox.display();
            	}
            } else{
            	//duplicate item can't be added again
                AlertBox alertbox = new AlertBox("Sorry", "  This Product ID: " + productId +" already exist. "
                		+ "\n  maybe, consider editing the product  ");
                alertbox.getCloseButton().setOnAction(event ->{
                    alertbox.getWindow().close();
                });
                alertbox.display();
            }
            }
            //update inventory
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

            //check for product in inventory
            int id = -1;
            try {
            	id = Integer.parseInt(productId);
            }
            //check for bad values in productId
            catch(NumberFormatException nfe1) {
            	AlertBox alertbox = new AlertBox("Error", "Please input integers for productId and make sure all fields are filled out");
                alertbox.getCloseButton().setOnAction(ev ->{
                    alertbox.getWindow().close();
                });
                alertbox.display();
            }
            if(id != -1) {
            //check for product in inventory
            Product product = inventory.getProduct(id);
            if(product != null){
            	//if item exists change values
            	try {
            		float f = Float.parseFloat(price);
            		int i = Integer.parseInt(quantity);
            		//checks for negative numbers where there shouldn't be
            		if(f >= 0 && i >= 0){
                        product.setName(name);
                        product.setPrice(f);
                        product.setType(type);
                        product.setQuantity(i);
                        product.setDescription(description);
                    } else{
                        AlertBox alertbox = new AlertBox("Error", "Please make sure all numbers are positive.");
                        alertbox.getCloseButton().setOnAction(ev ->{
                            alertbox.getWindow().close();
                        });
                        alertbox.display();
                    }

            	}
            	//catch mismatch of data type
            	catch(NumberFormatException nfe) {
            		AlertBox alertbox = new AlertBox("Error", "Please input integers for productId and quantity and decimal value for price");
                    alertbox.getCloseButton().setOnAction(ev ->{
                        alertbox.getWindow().close();
                    });
                    alertbox.display();
            	}
            	catch(NullPointerException npe) {
            		AlertBox alertbox = new AlertBox("Error", "Please fill out all fields");
                    alertbox.getCloseButton().setOnAction(ev ->{
                        alertbox.getWindow().close();
                    });
                    alertbox.display();
            	}
            } else{
            	//if no product then it can't be edited
                AlertBox alertbox = new AlertBox("Error", "No such product exists with \n Product ID: " + productId);
                alertbox.getCloseButton().setOnAction(event ->{
                    alertbox.getWindow().close();
                });
                alertbox.display();
            }
            }

            adminView.getProductTable().setInventory(inventory);
        });

        // delete product
        adminView.getAddProductBox().getDeleteButton().setOnAction(e ->{
            String productId = adminView.getAddProductBox().getproductIdField().getText();
            Product product = inventory.getProduct(Integer.parseInt(productId));
            //if product is selected prompt user to understand gravity fo situation
            if(product != null) {
                AlertBox alertBox = new AlertBox("Product Deletion", "Warning, you are about to permanently delete a product");

                alertBox.getCloseButton().setOnAction(event -> {
                    inventory.removeProduct(product);
                    alertBox.getWindow().close();
                });

                alertBox.display();
            } else {
            	//if no product found it can't be deleted
                AlertBox alertbox = new AlertBox("Error", "No such product exists with \n Product ID: " + productId);
                alertbox.getCloseButton().setOnAction(event ->{
                    alertbox.getWindow().close();
                });
                alertbox.display();
            }
            //up[date inventory on view
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

    /**
     * initializes controllers for report section of admin view
     */
    public void initReportControllers(){
    	//make report table and allow clicking gto pop up detailed view
        adminView.getReportTable().setRowFactory(e ->{
            TableRow<Receipt> row = new TableRow<>();
            row.setOnMouseClicked(event ->{
            adminView.getCartTable().setInventory(row.getItem().getCart());
            });
            return row;
        });
    }

    /**
     * clears input box 
     */
    public void clearProductBox(){
        adminView.getAddProductBox().getNameField().clear();
        adminView.getAddProductBox().getproductIdField().clear();
        adminView.getAddProductBox().getTypeField().clear();
        adminView.getAddProductBox().getPriceField().clear();
        adminView.getAddProductBox().getQuantityField().clear();
        adminView.getAddProductBox().getDescriptionField().clear();
    }

    /**
     * Adds product with given attributes to the inventory mdel
     * @param name
     * @param price
     * @param type
     * @param quantity 
     * @param description
     * @param productId
     */
    public void addProduct(String name, String price, String type, String quantity, String description, String productId){
        //TODO error checking
    	Integer trueId = Integer.parseInt(productId);
        Float truePrice = Float.parseFloat(price);
        Integer trueQuantity = Integer.parseInt(quantity);
        if(truePrice >= 0 && trueQuantity >= 0 && trueId > 0) {
            inventory.addProduct(new Product(name, truePrice, trueQuantity, description, type, trueId));
        } else{
            AlertBox alertbox = new AlertBox("Error", "Please make sure all numbers are positive.");
            alertbox.getCloseButton().setOnAction(event ->{
                alertbox.getWindow().close();
            });
            alertbox.display();
        }
    }

    /**
     * initializes all the tables in the view
     */
    public void initTable(){
        //Product Table
        adminView.getProductTable().setInventory(inventory);
        adminView.getProductTable().addNameColumn();
        adminView.getProductTable().addProductIdColumn();
        adminView.getProductTable().addPriceColumn();
        adminView.getProductTable().addTypeColumn();
        adminView.getProductTable().addQuantityColumn();
        adminView.getProductTable().addDescriptionColumn();

        //Report Table
        adminView.getReportTable().setReport(shopData.getReport());
        adminView.getReportTable().addTimeColumn();
        
        //Report Cart
        adminView.getCartTable().addNameColumn();
        adminView.getCartTable().addProductIdColumn();
        adminView.getCartTable().addPriceColumn();
        adminView.getCartTable().addTypeColumn();
        adminView.getCartTable().addQuantityColumn();
        adminView.getCartTable().addDescriptionColumn();
    }

    /**
     * initializes controllers for the menu to switch between views
     */
    public void initMenu(){
        adminView.getInventoryMenuItem().setOnAction(e ->{
            adminView.getLayout().setCenter(adminView.getInventoryBox());
        });
        adminView.getReportMenuItem().setOnAction(e -> {
            adminView.getLayout().setCenter(adminView.getReportBox());
        });

    }



    private Product selectedProduct;
    private AdminView adminView;
    private Inventory inventory;
    private Report report;
    private ShopData shopData;
}
