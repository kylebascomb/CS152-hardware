package view;

import javafx.stage.Stage;
import javafx.scene.Scene;

/**
 * 
 * Basic View class
 *
 */
public class View {

	/**
	 * Constructor
	 */
    public View() {
        initComponents();
        layoutComponents();
    }

    /**
     * initialize components
     */
    public void initComponents(){

    }

    /**
     * layout components
     */
    public void layoutComponents(){

    }
    
    /**
     * Getter for stage
     *
     * @return stage
     */
    public Stage getStage() {
        return stage;
    }

    /**
     * Setter for stage
     *
     * @param stage - stage
     */
    public void setStage(Stage scene) {
        this.stage = stage;
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
    
    protected Stage stage;
    protected Scene scene;
}
