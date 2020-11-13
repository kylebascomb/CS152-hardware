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
        productIdLabel = new Label("Product ID");
        priceLabel = new Label("Price ");
        typeLabel = new Label("Type");
        quantityLabel = new Label("Quantity");
        descriptionLabel = new Label("Description");
        

        nameField = new TextField();
        productIdField = new TextField();
        priceField = new TextField();
        typeField = new TextField();
        quantityField = new TextField();
        descriptionField = new TextArea();
        
        addButton = new Button("Add");
        editButton = new Button("Update");
        deleteButton = new Button("Delete");
    }

    public void layoutComponents(){

        nameLabel.setMinWidth(84);
        productIdLabel.setMinWidth(84);
        priceLabel.setMinWidth(84);
        typeLabel.setMinWidth(84);
        quantityLabel.setMinWidth(84);
        descriptionLabel.setMinWidth(84);

        HBox nameBox = new HBox(nameLabel, nameField);
        HBox idBox = new HBox(productIdLabel, productIdField);
        HBox priceBox = new HBox(priceLabel, priceField);
        HBox typeBox = new HBox(typeLabel, typeField);
        HBox quantityBox = new HBox(quantityLabel, quantityField);
        HBox descriptionBox = new HBox(descriptionLabel, descriptionField);
        HBox buttonBox = new HBox(addButton, editButton, deleteButton);
        this.getChildren().addAll(nameBox, idBox, priceBox, typeBox, quantityBox, descriptionBox, buttonBox);
    }


    public Button getDeleteButton() {
        return deleteButton;
    }

    public void setDeleteButton(Button deleteButton) {
        this.deleteButton = deleteButton;
    }

    public Button getEditButton() {
        return editButton;
    }

    public void setEditButton(Button editButton) {
        this.editButton = editButton;
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
     * Setter for productIdField
     *
     * @param productIdField - productIdField
     */
    public void setproductIdField(TextField productIdField) {
        this.productIdField = productIdField;
    }
    
    /**
     * Getter for productIdField
     *
     * @return productIdField
     */
    public TextField getproductIdField() {
        return productIdField;
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
    private TextField productIdField;

    private Button addButton;
    private Button editButton;
    private Button deleteButton;

    private Label nameLabel;
    private Label priceLabel;
    private Label typeLabel;
    private Label quantityLabel;
    private Label descriptionLabel;
    private Label productIdLabel;


}
