package controller;

import view.StartupView;

public class StartupController extends Controller{

    public StartupController() {
        this.view = new StartupView();
        startupView = (StartupView)view;

        initControllers();
    }

    public void initControllers(){
        startupView.getAdminButton().setOnAction(e ->{
            passControl(new AdminController(), e);
        });

        startupView.getCustomerButton().setOnAction(e ->{
            passControl(new CustomerController(), e);
        });
    }


    /**
     * Getter for startupView
     *
     * @return startupView
     */
    public StartupView getStartupView() {
        return startupView;
    }

    /**
     * Setter for startupView
     *
     * @param startupView - startupView
     */
    public void setStartupView(StartupView startupView) {
        this.startupView = startupView;
    }

    private StartupView startupView;
}
