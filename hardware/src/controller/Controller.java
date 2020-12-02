package controller;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.stage.Window;
import view.View;

/**
 * 
 * Superclass of all controllers
 *
 */
public class Controller {

    public Controller(){

    }

    /**
     * Passes control to another controller
     * @param controller controller to be given control
     * @param e event that triggered passing
     */
    public void passControl(Controller controller, ActionEvent e){
        View newView = controller.getView();
        Window window = ((Node)e.getSource()).getScene().getWindow();
        
        double height = window.getHeight();
        double width = window.getWidth();
        double x = window.getX();
        double y = window.getY();

        //change to new scene of controlller
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        primaryStage.setScene(newView.getScene());
        
        //keeps window size constant
        primaryStage.setWidth(width);
        primaryStage.setHeight(height);
        primaryStage.setX(x);
        primaryStage.setY(y);
        primaryStage.setMaximized(true);

    }

    /**
     * Getter for gui
     *
     * @return gui
     */
    public View getView() {
        return view;
    }

    /**
     * Setter for View
     *
     * @param view - view
     */
    public void setView(View view) {
        this.view = view;
    }

    protected View view;

}

