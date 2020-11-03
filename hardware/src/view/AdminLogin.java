package view;

import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.scene.control.*;
import javafx.geometry.*;

public class AdminLogin 
{
  public static void display(String title, String message)
  {
    Stage window = new Stage();
    window.setTitle(" Login to [Hardware] ");
    
    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.setVgap(10);	
    grid.setHgap(10);
    
    //Prompt Label
    Label promptLabel = new Label(" Enter your credentials: ");
    GridPane.setConstraints(promptLabel, 0, 0);
    
    //Username Label
    Label usernameLabel = new Label(" Username ");
    GridPane.setConstraints(usernameLabel, 2, 1);
    
    //Username Input
    TextField usernameInput = new TextField();
    usernameInput.setPromptText(" Admin ID ");
    GridPane.setConstraints(usernameLabel, 1, 1);
    
    //Password Label
    Label passwordLabel = new Label(" Password: ");
    GridPane.setConstraints(passwordLabel, 2, 2);    
    
    //Password Input
    TextField passwordInput = new TextField();
    passwordInput.setPromptText(" Password ");
    GridPane.setConstraints(usernameLabel, 1, 2);
    
    // Submit Button
    Button submitButton = new Button(" Submit ");
    GridPane.setConstraints(submitButton, 0, 2);
    
    grid.getChildren().addAll(promptLabel, usernameLabel, usernameInput, passwordLabel, passwordInput, submitButton);
    
    Scene scene = new Scene(grid, 800, 600);
    window.setScene(scene);
    window.show();    
  }
}
