package app;

import controller.StartupController;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 
 * Application starter
 *
 */
public class AppController extends Application {
    
    //launch the app
    public static void main(String[] args){
        launch(args);
    }
    
    //starts up window to display and starts the controller that boots everything
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        StartupController startupController = new StartupController();
        window.setScene(startupController.getStartupView().getScene());
        window.setMaximized(true);
        window.show();
    }


    private Stage window;
}
