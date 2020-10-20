package view.components;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class AddProductBox extends VBox {


    public AddProductBox() {
        initComponents();
        layoutComponents();
    }

    public void initComponents(){
        nameLabel = new Label("Product");
        priceLabel = new Label("Price ");
        typeLabel = new Label("Type");
        quantityLabel = new Label("Quantity");
        descriptionLabel = new Label("Description");

        nameField = new TextField();
        priceField = new TextField();
        typeField = new TextField();
        quantityField = new TextField();
        descriptionField = new TextArea();

        addButton = new Button("Add");
    }

    public void layoutComponents(){

        nameLabel.setMinWidth(64);
        priceLabel.setMinWidth(64);
        typeLabel.setMinWidth(64);
        quantityLabel.setMinWidth(64);
        descriptionLabel.setMinWidth(64);

        HBox nameBox = new HBox(nameLabel, nameField);
        HBox priceBox = new HBox(priceLabel, priceField);
        HBox typeBox = new HBox(typeLabel, typeField);
        HBox quantityBox = new HBox(quantityLabel, quantityField);
        HBox descriptionBox = new HBox(descriptionLabel, descriptionField);
        this.getChildren().addAll(nameBox, priceBox, typeBox, quantityBox, descriptionBox, addButton);
    }


    /**
     * Getter for nameField
     *
     * @return nameField
     */
    public TextField getNameField() {
        return nameField;
    }

    /**
     * Setter for nameField
     *
     * @param nameField - nameField
     */
    public void setNameField(TextField nameField) {
        this.nameField = nameField;
    }

    /**
     * Getter for priceField
     *
     * @return priceField
     */
    public TextField getPriceField() {
        return priceField;
    }

    /**
     * Setter for priceField
     *
     * @param priceField - priceField
     */
    public void setPriceField(TextField priceField) {
        this.priceField = priceField;
    }

    /**
     * Getter for typeField
     *
     * @return typeField
     */
    public TextField getTypeField() {
        return typeField;
    }

    /**
     * Setter for typeField
     *
     * @param typeField - typeField
     */
    public void setTypeField(TextField typeField) {
        this.typeField = typeField;
    }

    /**
     * Getter for quantityField
     *
     * @return quantityField
     */
    public TextField getQuantityField() {
        return quantityField;
    }

    /**
     * Setter for quantityField
     *
     * @param quantityField - quantityField
     */
    public void setQuantityField(TextField quantityField) {
        this.quantityField = quantityField;
    }

    /**
     * Getter for descriptionField
     *
     * @return descriptionField
     */
    public TextArea getDescriptionField() {
        return descriptionField;
    }

    /**
     * Setter for descriptionField
     *
     * @param descriptionField - descriptionField
     */
    public void setDescriptionField(TextArea descriptionField) {
        this.descriptionField = descriptionField;
    }

    /**
     * Getter for addButton
     *
     * @return addButton
     */
    public Button getAddButton() {
        return addButton;
    }

    /**
     * Setter for addButton
     *
     * @param addButton - addButton
     */
    public void setAddButton(Button addButton) {
        this.addButton = addButton;
    }

    private TextField nameField;
    private TextField priceField;
    private TextField typeField;
    private TextField quantityField;
    private TextArea descriptionField;

    private Button addButton;

    private Label nameLabel;
    private Label priceLabel;
    private Label typeLabel;
    private Label quantityLabel;
    private Label descriptionLabel;


}
