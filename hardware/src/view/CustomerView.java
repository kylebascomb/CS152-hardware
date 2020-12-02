package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import view.components.CartTableView;
import view.components.ProductTableView;

/**
 * 
 * View for customer screen 
 *
 */
public class CustomerView extends View{

	/**
	 * Constructor
	 */
    public CustomerView() {
        super();
        setStyles();
    }

    /**
     * initializes components
     */
    public void initComponents(){
        layout = new HBox();
        backButton = new Button("Back");
        addButton = new Button("Add to Cart");
        removeButton = new Button("Remove from Cart");
        checkoutButton = new Button("Checkout");
        priceLabel = new Label("Total:    $");
        priceLabel.setFont(new Font(20.0));
        productTable = new ProductTableView();
        cartTable = new CartTableView();
        titleText = new Text(TITLE_TEXT);
        borderpane = new BorderPane();

        scene = new Scene(borderpane);
        scene.getStylesheets().add("/stylesheets/stylesheets.css");
    }

    /**
     * puts and layouts components in window
     */
    public void layoutComponents(){
        //create container boxes
    	VBox cart = new VBox(10);
    	VBox buttons = new VBox(20);
    	VBox title = new VBox();

        title.getStyleClass().add("title-background");

    	title.getChildren().add(titleText);
    	buttons.getChildren().addAll(addButton, removeButton, checkoutButton, backButton);
    	cart.getChildren().addAll(cartTable, priceLabel);
        layout.getChildren().addAll(productTable, cart, buttons);

        borderpane.setCenter(layout);
        borderpane.setTop(title);

        layout.setAlignment(Pos.CENTER);
        layout.setSpacing(20);
    }

    /**
     * assigns given CSS styles to view
     */
    public void setStyles(){
        titleText.getStyleClass().add("title-text");

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
     * Getter for priceLabel
     * @return priceLabel
     */
    public Label getPriceLabel(){
    	return priceLabel;
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

    private BorderPane borderpane;
    private HBox layout;
    private Button backButton;
    private Button addButton;
    private Button removeButton;
    private Button checkoutButton;
    private Label priceLabel;
    private ProductTableView productTable;
    private CartTableView cartTable;
    private Text titleText;
    private final String TITLE_TEXT = "Shop";
}
