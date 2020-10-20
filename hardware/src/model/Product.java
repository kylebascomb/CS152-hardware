package model;

import java.io.Serializable;

public class Product implements Serializable {


    public Product(String name, float price, int quantity, String description, String type) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.description = description;
        this.type = type;
    }

    /**
     * Getter for name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for name
     *
     * @param name - name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter for price
     *
     * @return price
     */
    public float getPrice() {
        return price;
    }

    /**
     * Setter for price
     *
     * @param price - price
     */
    public void setPrice(float price) {
        this.price = price;
    }

    /**
     * Getter for quantity
     *
     * @return quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Setter for quantity
     *
     * @param quantity - quantity
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Getter for description
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for description
     *
     * @param description - description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Getter for productId
     *
     * @return productId
     */
    public int getProductId() {
        return productId;
    }

    /**
     * Setter for productId
     *
     * @param productId - productId
     */
    public void setProductId(int productId) {
        this.productId = productId;
    }

    /**
     * Getter for type
     *
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Setter for type
     *
     * @param type - type
     */
    public void setType(String type) {
        this.type = type;
    }

    private String name;
    private float price;
    private int quantity;
    private String description;
    private int productId;
    private String type;
}
