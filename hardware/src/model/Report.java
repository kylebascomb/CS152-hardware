package model;

import javafx.scene.control.MenuBar;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * 
 * Collection of receipts for past purchases
 *
 */
public class Report implements Serializable {

	/**
	 * Constructor
	 * @param report list of reports
	 */
    public Report(ArrayList<Receipt> report) {
        this.report = report;
    }

    /**
     * Constructor for fresh report 
     */
    public Report() {
        report = new ArrayList<>();
    }

    /**
     * return size of list
     * @return size of list
     */
    public int getSize() {
        return report.size();
    }

    /**
     * Add receipt to report
     * @param receipt receipt to be added
     */
    public void addReceipt(Receipt receipt) {
        report.add(receipt);
    }

    /**
     * returns report
     * @return report
     */
    public ArrayList<Receipt> getReport() {
        return report;
    }

    /**
     * Sets report tog iven list
     * @param report new report list
     */
    public void setReport(ArrayList<Receipt> report) {
        this.report = report;
    }

    private ArrayList<Receipt> report;


}
