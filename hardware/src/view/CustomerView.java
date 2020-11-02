package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.components.CartTableView;
import view.components.ProductTableView;

public class CustomerView extends View{

    public CustomerView() {
        super();
    }

    public void initComponents(){
        layout = new HBox();
        backButton = new Button("Back");
        addButton = new Button("Add to Cart");
        removeButton = new Button("Remove from Cart");
        checkoutButton = new Button("Checkout");
        productTable = new ProductTableView();
        cartTable = new CartTableView();
        scene = new Scene(layout);
    }

    public void layoutComponents(){
        layout.getChildren().addAll(productTable, cartTable, addButton, removeButton, checkoutButton, backButton);
    }

    /**
     * Getter for layout
     *
     * @return layout
     */
    public HBox getLayout() {
        return layout;
    }

    /**
     * Setter for layout
     *
     * @param layout - layout
     */
    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    /**
     * Getter for backButton
     *
     * @return backButton
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Setter for backButton
     *
     * @param backButton - backButton
     */
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }
    
    /**
     * Getter for addButton
     *
     * @return addButton
     */
    public Button getAddButton() {
        return addButton;
    }
    
    /**
     * Getter for removeButton
     *
     * @return removeButton
     */
    public Button getRemoveButton() {
        return removeButton;
    }
    
    /**
     * Getter for checkoutButton
     * 
     * @return checkoutButton
     */
    public Button getCheckoutButton() {
    	return checkoutButton;
    }


    /**
     * Getter for productTable
     *
     * @return productTable
     */
    public ProductTableView getProductTable() {
        return productTable;
    }

    /**
     * Setter for productTable
     *
     * @param productTable - productTable
     */
    public void setProductTable(ProductTableView productTable) {
        this.productTable = productTable;
    }
    
    /**
     * Getter for cartTable
     *
     * @return cartTable
     */
    public ProductTableView getCartTable() {
        return cartTable;
    }

    private HBox layout;
    private Button backButton;
    private Button addButton;
    private Button removeButton;
    private Button checkoutButton;
    private ProductTableView productTable;
    private CartTableView cartTable;
}
