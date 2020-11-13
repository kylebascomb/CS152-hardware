package view.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

public class ReportBox extends HBox {


    public ReportBox() {
        initComponents();
        layoutComponents();
    }

    private void initComponents() {
        reportTable = new ReportTableView();
        cartTable = new CartTableView();
    }

    private void layoutComponents(){
        getChildren().addAll(reportTable, cartTable);
        setAlignment(Pos.CENTER);
    }


    public ReportTableView getReportTable() {
        return reportTable;
    }

    public void setReportTable(ReportTableView reportTable) {
        this.reportTable = reportTable;
    }

    public CartTableView getCartTable() {
        return cartTable;
    }

    public void setCartTable(CartTableView cartTable) {
        this.cartTable = cartTable;
    }

    private ReportTableView reportTable;
    private CartTableView cartTable;
}
