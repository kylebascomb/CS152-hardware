package model;

import java.io.Serializable;

/**
 * 
 * Holder of inventory and report, which need to be maintained and passed around application
 *
 */
public class ShopData implements Serializable {

	/**
	 * Constructor
	 * @param report report to hold
	 * @param inventory inventory to hold
	 */
    public ShopData(Report report, Inventory inventory) {
        this.report = report;
        this.inventory = inventory;
    }
    
    /**
     * Constructor for fresh shopdata
     */
    public ShopData() {
        this.inventory = new Inventory();
        this.report = new Report();
    }

    /**
     * returns report
     * @return report
     */
    public Report getReport() {
        return report;
    }

    /**
     * sets report
     * @param report new report
     */
    public void setReport(Report report) {
        this.report = report;
    }

    /**
     * returns inventory
     * @return inventory
     */
    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Sets inventory
     * @param inventory new inventory
     */
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private Report report;
    private Inventory inventory;
}
