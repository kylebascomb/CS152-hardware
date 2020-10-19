package controller;

import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.stage.Screen;
import javafx.stage.Stage;
import view.View;

public class Controller {

    public Controller(){

    }

    public void passControl(Controller controller, ActionEvent e){
        View newView = controller.getView();
        Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
        primaryStage.setScene(newView.getScene());

        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
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
     * Setter for gui
     *
     * @param gui - gui
     */
    public void setGui(View gui) {
        this.view = view;
    }

    protected View view;

}

