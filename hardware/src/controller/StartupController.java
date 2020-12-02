package controller;

import javafx.scene.Node;
import javafx.stage.Stage;
import model.Inventory;
import model.ShopData;
import view.StartupView;

import java.io.*;

/**
 * 
 * Controller that controls start up view and gives contrl to subsequent views
 *
 */
public class StartupController extends Controller{

	/**
	 * Base constructor for fresh app
	 */
    public StartupController() {
        this.view = new StartupView();
        startupView = (StartupView)view;

        shopData = new ShopData();
        getAllData();

        initControllers();
    }

    /**
     * Constructor that uses saved data
     * @param shopData saved data 
     */
    public StartupController(ShopData shopData){
        this.shopData = shopData;

        this.view = new StartupView();
        startupView = (StartupView)view;

        initControllers();
    }
    
    /**
     * initializes button controllers
     */
    public void initControllers(){
    	//go to admin view
        startupView.getAdminButton().setOnAction(e ->{
            passControl(new AdminController(shopData), e);
        });

        //go to customer view
        startupView.getCustomerButton().setOnAction(e ->{
            passControl(new CustomerController(shopData), e);
        });

        //save and quit application
        startupView.getSaveButton().setOnAction(e ->{
            saveAllData();
            Stage primaryStage = (Stage)((Node)e.getSource()).getScene().getWindow();
            primaryStage.close();
        });
    }

    /**
     * Serializes the shop data
     */
    public void saveAllData(){
        String filename = this.FILE_PATH;

        // Serialization
        try
        {
            //Saving of object in a file
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(shopData);

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

    /**
     * deserializes the data
     * @return
     */
    public boolean getAllData(){
        String filename = FILE_PATH;
        try
        {
            // Reading the object from a file
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);

            // Method for deserialization of object
            shopData = (ShopData)in.readObject();

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
    private ShopData shopData;

    private String FILE_PATH = "./hardware/resources/inventory.dat";
}
