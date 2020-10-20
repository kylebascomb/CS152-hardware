package model;

import java.io.Serializable;

public class Product implements Serializable {


    public Product(String name, float price) {
        this.name = name;
        this.price = price;
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

    private String name;
    private float price;
}
