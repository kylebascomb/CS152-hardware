package view;

import javafx.scene.Scene;

public class View {


    public View() {
        initComponents();
        layoutComponents();
    }

    public void initComponents(){

    }

    public void layoutComponents(){

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

    protected Scene scene;
}
