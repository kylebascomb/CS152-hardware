package view.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * 
 * Inventory section of the admin screen
 *
 */
public class InventoryBox extends HBox {

	/**
	 * Constructor
	 */
    public InventoryBox() {
        initComponents();
        layoutComponents();
    }

    /**
     * initializes components
     */
    private void initComponents() {
        addProductBox = new AddProductBox();
        productTable = new ProductTableView();
    }

    /**
     * layouts and formats components
     */
    private void layoutComponents(){
        getChildren().addAll(productTable, addProductBox);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }

    /**
     * returns product box
     * @return product box
     */
    public AddProductBox getAddProductBox() {
        return addProductBox;
    }

    /**
     * sets product box
     * @param addProductBox new product box
     */
    public void setAddProductBox(AddProductBox addProductBox) {
        this.addProductBox = addProductBox;
    }

    /**
     * returns product table
     * @return product table
     */
    public ProductTableView getProductTable() {
        return productTable;
    }

    /**
     * sets product table
     * @param productTable new product table
     */
    public void setProductTable(ProductTableView productTable) {
        this.productTable = productTable;
    }

    private AddProductBox addProductBox;
    private ProductTableView productTable;
}
