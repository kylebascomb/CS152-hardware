package view.components;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Receipt;
import model.Report;


public class ReportTableView extends TableView {

    public ReportTableView(Report report) {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);
        this.report = report;
        this.observableReport = FXCollections.observableArrayList(report.getReport());

        createColumns();
        fillTable();
    }

    public ReportTableView() {
        super();
        this.setColumnResizePolicy(CONSTRAINED_RESIZE_POLICY);


        createColumns();
    }

    private void createColumns() {
        titleColumn = new TableColumn<>();

        timeColumn = new TableColumn<>("Time Stamp");

        timeColumn.setCellValueFactory(new PropertyValueFactory<>("timeStamp"));

        this.getColumns().add(titleColumn);
        titleColumn.setText("Order History");
    }

    private void fillTable(){
        this.getItems().clear();
        this.getItems().addAll(observableReport);
    }

    public void addTimeColumn(){
        titleColumn.getColumns().add(timeColumn);
    }

    public void removeTimeColumn(){
        titleColumn.getColumns().remove(timeColumn);
    }

    public Report getReport() {
        return report;
    }

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
