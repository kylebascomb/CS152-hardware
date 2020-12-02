package view.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Receipt;
import model.Report;

/**
 * 
 * Table to display the report
 *
 */
public class ReportTableView extends TableView {

	/**
	 * constructor
	 * @param report report to display
	 */
    public ReportTableView(Report report) {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        this.report = report;
        this.observableReport = FXCollections.observableArrayList(report.getReport());

        createColumns();
        fillTable();
    }

    /**
     * constructor for empty table
     */
    public ReportTableView() {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);


        createColumns();
    }

    /**
     * makes all the columns of the table
     */
    private void createColumns() {
        titleColumn = new TableColumn<>();

        timeColumn = new TableColumn<>("Time Stamp");

        timeColumn.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));

        this.getColumns().add(titleColumn);
        titleColumn.setText("Order History");
    }

    /**
     * fills table with items 
     */
    private void fillTable(){
        this.getItems().clear();
        this.getItems().addAll(observableReport);
    }

    /**
     * add time column
     */
    public void addTimeColumn(){
        titleColumn.getColumns().add(timeColumn);
    }

    /**
     * removes time column
     */
    public void removeTimeColumn(){
        titleColumn.getColumns().remove(timeColumn);
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
     * @param report new report to display
     */
    public void setReport(Report report) {
        this.report = report;
        this.observableReport=FXCollections.observableArrayList(report.getReport());
        fillTable();
    }

    private Report report;
    private ObservableList<Receipt> observableReport;
    protected TableColumn<Receipt, String> titleColumn;
    private TableColumn<Receipt, String> timeColumn;
}
