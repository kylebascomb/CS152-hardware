package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

public class StartupView extends View{


    public StartupView() {
        super();
    }

    public void initComponents(){
        layout = new StackPane();
        horizontalLayout = new HBox(30);
        adminButton = new Button("Administration");
        customerButton = new Button("Customer");
        scene = new Scene( layout, 800, 600);
    }

    public void layoutComponents(){
        horizontalLayout.getChildren().addAll(adminButton, customerButton);
        horizontalLayout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(horizontalLayout);
    }

    /**
     * Getter for adminButton
     *
     * @return adminButton
     */
    public Button getAdminButton() {
        return adminButton;
    }

    /**
     * Setter for adminButton
     *
     * @param adminButton - adminButton
     */
    public void setAdminButton(Button adminButton) {
        this.adminButton = adminButton;
    }

    /**
     * Getter for customerButton
     *
     * @return customerButton
     */
    public Button getCustomerButton() {
        return customerButton;
    }

    /**
     * Setter for customerButton
     *
     * @param customerButton - customerButton
     */
    public void setCustomerButton(Button customerButton) {
        this.customerButton = customerButton;
    }

    private StackPane layout;
    private HBox horizontalLayout;
    private Button adminButton;
    private Button customerButton;
}
