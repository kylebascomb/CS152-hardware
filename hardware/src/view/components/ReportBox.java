package view.components;

import javafx.geometry.Pos;
import javafx.scene.layout.HBox;

/**
 * 
 * Report section of admin screen
 *
 */
public class ReportBox extends HBox {

	/**
	 * constructor
	 */
    public ReportBox() {
        initComponents();
        layoutComponents();
    }

    /**
     * initializes components
     */
    private void initComponents() {
        reportTable = new ReportTableView();
        cartTable = new CartTableView();
    }

    /**
     * layouts and formats componeents
     */
    private void layoutComponents(){
        getChildren().addAll(reportTable, cartTable);
        setAlignment(Pos.CENTER);
    }

    /**
     * return report table
     * @return report table
     */
    public ReportTableView getReportTable() {
        return reportTable;
    }

    /**
     * sets report table
     * @param reportTable new report table
     */
    public void setReportTable(ReportTableView reportTable) {
        this.reportTable = reportTable;
    }

    /**
     * returns cart table
     * @return cart table
     */
    public CartTableView getCartTable() {
        return cartTable;
    }

    /**
     * sets cart table
     * @param cartTable new cart table
     */
    public void setCartTable(CartTableView cartTable) {
        this.cartTable = cartTable;
    }

    private ReportTableView reportTable;
    private CartTableView cartTable;
}
