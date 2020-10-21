import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AlertBox 
{
  public static void display(String title, String message)
  {
    Stage window = new Stage();
    
    //User must address the alertbox (read it and close it) before further actions can take place.
    window.initModality(Modality.APPLICATION_MODAL);
    
    window.setTitle(title);
    window.setMinWidth(200);
    
    Label label = new label();
    label.setText(message);
    Button closeButton = new Button("Close");
    closeButton.setOnAction(e -> window.close());
    
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label, closeButton);
    layout.setAlignment(Pos.CENTER);
    
    Scene scene = new Scene(layout);
    window.setScene(scene);
    window.showAndWait();    
  }
}
