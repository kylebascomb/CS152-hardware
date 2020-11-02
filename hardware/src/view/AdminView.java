package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import view.components.AddProductBox;
import view.components.InventoryBox;
import view.components.ProductTableView;
import view.components.ReportTableView;

public class AdminView extends View{


    public AdminView() {
        super();
    }

    public void initComponents(){
        layout = new HBox();
        backButton = new Button("Save & Close");
        inventoryBox = new InventoryBox();
        reportTable = new ReportTableView();
        scene = new Scene(layout);
    }

    public void layoutComponents(){
        layout.getChildren().addAll(inventoryBox, reportTable,  backButton);
    }

    public ReportTableView getReportTable() {
        return reportTable;
    }

    public void setReportTable(ReportTableView reportTable) {
        this.reportTable = reportTable;
    }

    /**
     * Getter for layout
     *
     * @return layout
     */
    public HBox getLayout() {
        return layout;
    }

    /**
     * Setter for layout
     *
     * @param layout - layout
     */
    public void setLayout(HBox layout) {
        this.layout = layout;
    }

    /**
     * Getter for backButton
     *
     * @return backButton
     */
    public Button getBackButton() {
        return backButton;
    }

    /**
     * Setter for backButton
     *
     * @param backButton - backButton
     */
    public void setBackButton(Button backButton) {
        this.backButton = backButton;
    }

    /**
     * Getter for addProductBox
     *
     * @return addProductBox
     */
    public AddProductBox getAddProductBox() {
        return inventoryBox.getAddProductBox();
    }

    /**
     * Setter for addProductBox
     *
     * @param addProductBox - addProductBox
     */
    public void setAddProductBox(AddProductBox addProductBox) {
        this.inventoryBox.setAddProductBox(addProductBox);
    }

    /**
     * Getter for productTable
     *
     * @return productTable
     */
    public ProductTableView getProductTable() {
        return inventoryBox.getProductTable();
    }

    /**
     * Setter for productTable
     *
     * @param productTable - productTable
     */
    public void setProductTable(ProductTableView productTable) {
        this.inventoryBox.setProductTable(productTable);
    }

    private HBox layout;
    private Button backButton;
    private InventoryBox inventoryBox;
    private ReportTableView reportTable;
}
