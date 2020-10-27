package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox 
{

  public AlertBox(String title, String message ){
    this.title = title;
    this.message = message;
    this.closeButton = new Button("Continue");
    this.cancelButton = new Button("Cancel");
    //display();
  }
  public void display()
  {
    window = new Stage();
    
    //User must address the alertbox (read it and close it) before further actions can take place.
    window.initModality(Modality.APPLICATION_MODAL);
    
    window.setTitle(title);
    window.setMinWidth(200);
    
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



  public Button getCloseButton() {
    return closeButton;
  }

  public void setCloseButton(Button closeButton) {
    this.closeButton = closeButton;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Stage getWindow() {
    return window;
  }

  public void setWindow(Stage window) {
    this.window = window;
  }

  private Button closeButton;
  private Button cancelButton;
  private String title;
  private String message;
  private Stage window;

}
