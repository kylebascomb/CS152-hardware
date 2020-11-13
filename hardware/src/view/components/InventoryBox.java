package view.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class InventoryBox extends HBox {


    public InventoryBox() {
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        addProductBox = new AddProductBox();
        productTable = new ProductTableView();
    }

    private void layoutComponents(){
        getChildren().addAll(productTable, addProductBox);
        setAlignment(Pos.CENTER);
        setSpacing(20);
    }

    public AddProductBox getAddProductBox() {
        return addProductBox;
    }

    public void setAddProductBox(AddProductBox addProductBox) {
        this.addProductBox = addProductBox;
    }

    public ProductTableView getProductTable() {
        return productTable;
    }

    public void setProductTable(ProductTableView productTable) {
        this.productTable = productTable;
    }

    private AddProductBox addProductBox;
    private ProductTableView productTable;
}
