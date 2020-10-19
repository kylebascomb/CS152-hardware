import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;


public class TestView {

    public TestView() {
        initComponents();
        layoutComponents();
    }

    public void initComponents(){
        layout = new StackPane();
        horizontalLayout = new HBox(30);
        lButton = new Button("Left");
        rButton = new Button("Right");
        scene = new Scene( layout, 800, 600);
    }

    public void layoutComponents(){
        horizontalLayout.getChildren().addAll(lButton, rButton);
        horizontalLayout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(horizontalLayout);



    }


    /**
     * Getter for lButton
     *
     * @return lButton
     */
    public Button getlButton() {
        return lButton;
    }

    /**
     * Setter for lButton
     *
     * @param lButton - lButton
     */
    public void setlButton(Button lButton) {
        this.lButton = lButton;
    }

    /**
     * Getter for rButton
     *
     * @return rButton
     */
    public Button getrButton() {
        return rButton;
    }

    /**
     * Setter for rButton
     *
     * @param rButton - rButton
     */
    public void setrButton(Button rButton) {
        this.rButton = rButton;
    }

    /**
     * Getter for scene
     *
     * @return scene
     */
    public Scene getScene() {
        return scene;
    }

    /**
     * Setter for scene
     *
     * @param scene - scene
     */
    public void setScene(Scene scene) {
        this.scene = scene;
    }

    private StackPane layout;
    private HBox horizontalLayout;
    private Button lButton;
    private Button rButton;
    private Scene scene;
}
