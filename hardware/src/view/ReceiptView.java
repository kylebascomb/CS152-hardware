package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import view.components.AddProductBox;

public class ReceiptView extends View {
	
	public ReceiptView() {
		super();
	}
	
	public void initComponents(){
        layout = new HBox();
        total = new Label("Total:    $");
        total.setFont(new Font(20.0));
        backButton = new Button("Cancel");
        saveButton = new Button("Confirm");
        cartTable = new ProductTableView();
        scene = new Scene(layout);
    }

    public void layoutComponents(){
    	VBox holder = new VBox();
    	HBox table = new HBox(cartTable);
    	HBox label = new HBox(total);
    	HBox buttons = new HBox(saveButton, backButton);
        holder.getChildren().addAll(table, label, buttons);
        layout.getChildren().addAll(holder);
    }
    
    public HBox getLayout() {
    	return layout;
    }
    
    public Label getTotal() {
    	return total;
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
	
	private HBox layout;
	private Label total;
    private Button backButton;
    private Button saveButton;
    private ProductTableView cartTable;

}
