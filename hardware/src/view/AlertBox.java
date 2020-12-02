package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

/**
 * 
 * Box for alerts that must be addressed to continue
 *
 */
public class AlertBox 
{

	/**
	 * Constructor
	 * @param title title of box
	 * @param message message in box
	 */
  public AlertBox(String title, String message ){
    this.title = title;
    this.message = message;
    this.closeButton = new Button("Continue");
    this.cancelButton = new Button("Cancel");
    //display();
  }
  
  /**
   * layouts and then shows box
   */
  public void display()
  {
    window = new Stage();
    
    //User must address the alertbox (read it and close it) before further actions can take place.
    window.initModality(Modality.APPLICATION_MODAL);
    
    window.setTitle(title);
    window.setMinWidth(300);
    
    Label label = new Label();
    label.setText(message);

    cancelButton.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    HBox buttonLayout = new HBox(10);
    buttonLayout.getChildren().addAll(closeButton, cancelButton);
    layout.getChildren().addAll(label, buttonLayout);
    buttonLayout.setAlignment(Pos.CENTER);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();    
  }


  /**
   * returns close button
   * @return close button
   */
  public Button getCloseButton() {
    return closeButton;
  }

  /**
   * sets close butto
   * @param closeButton new closebutton
   */
  public void setCloseButton(Button closeButton) {
    this.closeButton = closeButton;
  }

  /**
   * reutrn title
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
   * return message
   * @return the message
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
   * returns window
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

  private Button closeButton;
  private Button cancelButton;
  private String title;
  private String message;
  private Stage window;

}
