package app;

import controller.StartupController;
import javafx.application.Application;
import javafx.stage.Stage;

public class AppController extends Application {

    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        StartupController startupController = new StartupController();
        window.setScene(startupController.getStartupView().getScene());
        window.setMaximized(true);
        window.show();
    }


    private Stage window;
}
