package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/**
 * 
 * Box for receiving input
 *
 */
public class InputBox {
	/**
	 * Constructor
	 * @param title title fo box
	 * @param message messgae of box
	 */
	  public InputBox(String title, String message ){
		  this.title = title;
		  this.message = message;
		  confirmButton = new Button("Confirm");
		  cancelButton = new Button("Cancel");
		  number = new TextField();
	  }
	  
	  /**
	   * formats and displays box
	   */
	  public void display(){
		    window = new Stage();
		    
		    //User must address the alertbox (read it and close it) before further actions can take place.
		    window.initModality(Modality.APPLICATION_MODAL);
		    
		    window.setTitle(title);
		    window.setMinWidth(300);
		    
		    Label label = new Label();
		    label.setText(message);
		    
		    number.setMinWidth(64);

		    cancelButton.setOnAction(e -> window.close());
		    
		    VBox layout = new VBox(10);
		    HBox buttonLayout = new HBox(10);
		    buttonLayout.getChildren().addAll(confirmButton, cancelButton);
		    layout.getChildren().addAll(label, number, buttonLayout);
		    buttonLayout.setAlignment(Pos.CENTER);
		    layout.setAlignment(Pos.CENTER);
		    
		    Scene scene = new Scene(layout);
		    window.setScene(scene);
		    window.showAndWait();    
		  }


	  /**
	   * return confirm button
	   * @return confirm button
	   */
	  public Button getConfirmButton() {
		    return confirmButton;
		  }

	  /**
	   * set close button
	   * @param closeButton new close button
	   */
	  public void setConfirmButton(Button closeButton) {
		    this.confirmButton = closeButton;
		  }

	  /**
	   * return title
	   * @return title
	   */
	  public String getTitle() {
		    return title;
		  }

	  /**
	   * sets title
	   * @param title new title
	   */
	  public void setTitle(String title) {
		    this.title = title;
		  }

	  /**
	   * returns message
	   * @return message
	   */
	  public String getMessage() {
		    return message;
		  }

	  /**
	   * sets message
	   * @param message new message
	   */
	  public void setMessage(String message) {
		    this.message = message;
		  }

	  /**
	   * return window
	   * @return window
	   */
	  public Stage getWindow() {
		    return window;
		  }

	  /**
	   * sets window
	   * @param window new window
	   */
	  public void setWindow(Stage window) {
		    this.window = window;
		  }
	  
	  /**
	   * return number
	   * @return number
	   */
	  public TextField getNumber() {
		  return number;
	  }

	  private Button confirmButton;
	  private Button cancelButton;
	  private String title;
	  private String message;
	  private TextField number;
	  private Stage window;
	
}
