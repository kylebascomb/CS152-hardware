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
import view.components.ProductTableView;

/**
 * 
 * View for receipt screen
 *
 */
public class ReceiptView extends View {
	
	/**
	 * Constructor
	 */
	public ReceiptView() {
		super();
		setStyles();
	}
	
	/**
	 * initialize components
	 */
	public void initComponents(){
        layout = new VBox();
        total = new Label("Total:    $");
        total.setFont(new Font(20.0));
        datetime = new Label();
        datetime.setFont(new Font(20.0));
        backButton = new Button("Cancel");
        saveButton = new Button("Confirm");
        cartTable = new ProductTableView();
        borderPane = new BorderPane();
        titleText = new Text(TITLE_TEXT);


        scene = new Scene(borderPane);
        scene.getStylesheets().add("/stylesheets/stylesheets.css");
    }

	/**
	 * layout components in format
	 */
    public void layoutComponents(){
	    VBox title = new VBox();
    	HBox table = new HBox(cartTable);
    	HBox buttons = new HBox(saveButton, backButton);
    	title.getChildren().add(titleText);
    	title.getStyleClass().add("title-background");
        layout.getChildren().addAll(table, total, datetime, buttons);

        layout.setAlignment(Pos.CENTER);
        table.setAlignment(Pos.CENTER);
        buttons.setAlignment(Pos.CENTER);
        borderPane.setCenter(layout);
        borderPane.setTop(title);
    }

    /**
     * sets style to given CSS 
     */
    public void setStyles(){
	    titleText.getStyleClass().add("title-text");
    }
    
    /**
     * return layout
     * @return layout
     */
    public VBox getLayout() {
    	return layout;
    }
    
    /**
     * return total rice
     * @return total price
     */
    public Label getTotal() {
    	return total;
    }
    
    /**
     * return datetime
     * @return datetime
     */
    public Label getDateTime() {
    	return datetime;
    }
    
    /**
     * return back button
     * @return back button
     */
    public Button getBackButton() {
    	return backButton;
    }
    
    /**
     * return save button
     * @return save button
     */
    public Button getSaveButton() {
    	return saveButton;
    }
    
    /**
     * return cart table
     * @return cart table
     */
    public ProductTableView getCartTable() {
    	return cartTable;
    }
	
	private VBox layout;
	private Label total;
	private Label datetime;
    private Button backButton;
    private Button saveButton;
    private ProductTableView cartTable;
    private BorderPane borderPane;
    private Text titleText;
    private final String TITLE_TEXT = "Checkout";

}
