package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class CustomerView extends View{

    public CustomerView() {
        super();
    }

    public void initComponents(){
        layout = new HBox();
        backButton = new Button("Back");
        scene = new Scene(layout);
    }

    public void layoutComponents(){
        layout.getChildren().addAll(backButton);
    }

    /**
     * Getter for layout
     *
     * @return layout
     */
    public HBox getLayout() {
        return layout;
    }

    /**
     * Setter for layout
     *
     * @param layout - layout
     */
    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    /**
     * Getter for backButton
     *
     * @return backButton
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Setter for backButton
     *
     * @param backButton - backButton
     */
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    private HBox layout;
    private Button backButton;
}
