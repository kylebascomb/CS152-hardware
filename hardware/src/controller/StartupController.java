package controller;

import javafx.scene.Node;
import javafx.stage.Stage;
import model.Inventory;
import view.StartupView;

import java.io.*;

public class StartupController extends Controller{

    public StartupController() {
        this.view = new StartupView();
        startupView = (StartupView)view;

        inventory = new Inventory();
        getAllData();

        initControllers();
    }

    public StartupController(Inventory inventory){
        this.inventory = inventory;

        this.view = new StartupView();
        startupView = (StartupView)view;

        initControllers();
    }

    public void initControllers(){
        startupView.getAdminButton().setOnAction(e ->{
            passControl(new AdminController(inventory), e);
        });

        startupView.getCustomerButton().setOnAction(e ->{
            passControl(new CustomerController(inventory), e);
        });

        startupView.getSaveButton().setOnAction(e ->{
            saveAllData();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.close();
        });
    }


    public void saveAllData(){
        String filename = this.FILE_PATH;

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(inventory);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        }
        catch(IOException ex)
        {
            System.out.println("OException is caught");
            System.out.println(ex.getMessage());
            System.out.println(ex.getCause());
        }
    }

    public boolean getAllData(){
        String filename = FILE_PATH;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            inventory = (Inventory)in.readObject();

            in.close();
            file.close();

            System.out.println("Object has been deserialized ");
        }

        catch(IOException ex)
        {
            System.out.println("IException is caught");
            return false;
        }

        catch(ClassNotFoundException ex)
        {
            System.out.println("ClassNotFoundException is caught");
            return false;
        }
        return true;
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
    private Inventory inventory;

    private String FILE_PATH = "./hardware/resources/inventory.dat";
}
