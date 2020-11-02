package model;

import javafx.scene.control.MenuBar;

import java.io.Serializable;
import java.util.ArrayList;

public class Report implements Serializable {

    public Report(ArrayList<Receipt> report) {
        this.report = report;
    }

    public Report() {
        report = new ArrayList<>();
    }

    public int getSize() {
        return report.size();
    }

    /**
     * public Receipt getReceipt() {
     * //return receipt;
     * }
     */


    public void addReceipt(Receipt receipt) {
        //TODO does this need to be cloned?
        report.add(receipt);
    }


    public ArrayList<Receipt> getReport() {
        return report;
    }

    public void setReport(ArrayList<Receipt> report) {
        this.report = report;
    }

    private ArrayList<Receipt> report;


}
