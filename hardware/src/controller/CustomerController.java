package controller;

import view.CustomerView;

public class CustomerController extends Controller {

    public CustomerController() {
        view = new CustomerView();
        customerView = (CustomerView)view;

        initControllers();
    }

    public void initControllers(){
        customerView.getBackButton().setOnAction(e ->{
            passControl(new StartupController(), e);
        });
    }

    private CustomerView customerView;
}
