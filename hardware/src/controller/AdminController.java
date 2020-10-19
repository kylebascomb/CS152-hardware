package controller;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.AdminView;

public class AdminController extends Controller {

    public AdminController() {
        view = new AdminView();
        adminView = (AdminView)view;

        initControllers();
    }

    public void initControllers(){
        adminView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(), e);
        });
    }


    private AdminView adminView;
}
