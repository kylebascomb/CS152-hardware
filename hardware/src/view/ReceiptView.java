package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import view.components.ProductTableView;

public class ReceiptView extends View {
	
	public ReceiptView() {
		super();
	}
	
	public void initComponents(){
        layout = new VBox();
        total = new Label("Total:    $");
        total.setFont(new Font(20.0));
        datetime = new Label();
        datetime.setFont(new Font(20.0));
        backButton = new Button("Cancel");
        saveButton = new Button("Confirm");
        cartTable = new ProductTableView();
        scene = new Scene(layout);
        scene.getStylesheets().add("/stylesheets/stylesheets.css");
    }

    public void layoutComponents(){
    	HBox table = new HBox(cartTable);
    	HBox buttons = new HBox(saveButton, backButton);
        layout.getChildren().addAll(table, total, datetime, buttons);
    }
    
    public VBox getLayout() {
    	return layout;
    }
    
    public Label getTotal() {
    	return total;
    }
    
    public Label getDateTime() {
    	return datetime;
    }
    
    public Button getBackButton() {
    	return backButton;
    }
    
    public Button getSaveButton() {
    	return saveButton;
    }
    
    public ProductTableView getCartTable() {
    	return cartTable;
    }
	
	private VBox layout;
	private Label total;
	private Label datetime;
    private Button backButton;
    private Button saveButton;
    private ProductTableView cartTable;

}
