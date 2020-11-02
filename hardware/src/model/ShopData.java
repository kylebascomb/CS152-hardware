package model;

import java.io.Serializable;

public class ShopData implements Serializable {


    public ShopData(Report report, Inventory inventory) {
        this.report = report;
        this.inventory = inventory;
    }

    public ShopData() {
        this.inventory = new Inventory();
        this.report = new Report();
    }

    public Report getReport() {
        return report;
    }

    public void setReport(Report report) {
        this.report = report;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    private Report report;
    private Inventory inventory;
}
