package view.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Product;

/**
 * 
 * Display for product table
 *
 */
public class ProductTableView extends TableView {

	/**
	 * Constructor
	 * @param inventory inventory to display
	 */
    public ProductTableView(Inventory inventory) {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        // added the inventory
        this.inventory = inventory;
        this.observableInventory = FXCollections.observableArrayList(inventory.getProducts());

        createColumns();
        fillTable();
    }

    /**
     * Constructor for empty table
     */
    public ProductTableView() {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        createColumns();
    }

    /**
     * Adds all columns to table
     */
    public void createColumns(){
        titleColumn = new TableColumn<>();

        nameColumn = new TableColumn<>("Product");
        productIdColumn = new TableColumn<>("ID");
        priceColumn = new TableColumn<>("Price");
        typeColumn = new TableColumn<>("Type");
        quantityColumn = new TableColumn<>("Quantity");
        descriptionColumn = new TableColumn<>("Description");

        nameColumn.setMinWidth(100);
        productIdColumn.setMinWidth(20);
        priceColumn.setMinWidth(20);
        typeColumn.setMinWidth(50);
        quantityColumn.setMinWidth(20);
        descriptionColumn.setMinWidth(200);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        productIdColumn.setCellValueFactory(new PropertyValueFactory<>("productId"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        descriptionColumn.setCellValueFactory(new PropertyValueFactory<>("description"));


        this.getColumns().add(titleColumn);
        titleColumn.setText("Products");
    }

    /**
     * fills table with items from data
     */
    public void fillTable(){
        this.getItems().clear();
        this.getItems().addAll(observableInventory);
    }

    /**
     * ADDING COLUMNS TO THE TABLE
     */

    public void addNameColumn(){
        titleColumn.getColumns().add(nameColumn);
    }
    
    public void addProductIdColumn(){
        titleColumn.getColumns().add(productIdColumn);
    }

    public void addPriceColumn(){
        titleColumn.getColumns().add(priceColumn);
    }
    
    public void addTypeColumn(){
        titleColumn.getColumns().add(typeColumn);
    }
    
    public void addQuantityColumn(){
        titleColumn.getColumns().add(quantityColumn);
    }

    public void addDescriptionColumn(){
        titleColumn.getColumns().add(descriptionColumn);
    }
    


    /**
     * REMOVING COLUMNS FROM THE TABLE
     */

    public void removeNameColumn() {
        titleColumn.getColumns().remove(nameColumn);
    }
    
    public void removeProductIdColumn(){
        titleColumn.getColumns().remove(productIdColumn);
    }

    public void removePriceColumn(){
        titleColumn.getColumns().remove(priceColumn);
    }

    public void removeTypeColumn(){
        titleColumn.getColumns().remove(typeColumn);
    }

    public void removeQuantityColumn(){
        titleColumn.getColumns().remove(quantityColumn);
    }

    public void removeDescriptionColumn(){
        titleColumn.getColumns().remove(descriptionColumn);
    }

    /**
     * Getter for inventory
     *
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Setter for inventory
     *
     * @param inventory - inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
        this.observableInventory =FXCollections.observableArrayList(inventory.getProducts());
        fillTable();
    }

    private Inventory inventory;
    private ObservableList<Product> observableInventory;
    protected TableColumn<Product, String> titleColumn;
    private TableColumn<Product, Integer> productIdColumn;
    private TableColumn<Product, String> nameColumn;
    private TableColumn<Product, Float> priceColumn;
    private TableColumn<Product, String> typeColumn;
    private TableColumn<Product, Integer> quantityColumn;
    private TableColumn<Product, String> descriptionColumn;


}
