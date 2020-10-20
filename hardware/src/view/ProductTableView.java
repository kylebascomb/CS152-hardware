package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Inventory;
import model.Product;

public class ProductTableView extends TableView {


    public ProductTableView(Inventory inventory) {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        // added the inventory
        this.inventory = inventory;
        this.observableInventory = FXCollections.observableArrayList(inventory.getProducts());

        createColumns();
        fillTable();
    }

    public ProductTableView() {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);

        createColumns();
    }

    public void createColumns(){
        titleColumn = new TableColumn<>();

        nameColumn = new TableColumn<>("Product");
        priceColumn = new TableColumn<>("Price");

        nameColumn.setMinWidth(20);
        priceColumn.setMinWidth(20);

        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));


        this.getColumns().add(titleColumn);
        titleColumn.setText("Products");
    }

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

    public void addPriceColumn(){
        titleColumn.getColumns().add(priceColumn);
    }


    /**
     * REMOVING COLUMNS FROM THE TABLE
     */

    public void removeNameColumn() {
        titleColumn.getColumns().remove(nameColumn);
    }

    public void removePriceColumn(){
        titleColumn.getColumns().remove(priceColumn);
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
    private TableColumn<Product, String> titleColumn;
    private TableColumn<Product, String> nameColumn;
    private TableColumn<Product, Float> priceColumn;

}
