package view;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import view.components.*;

public class AdminView extends View{


    public AdminView() {
        super();
    }

    public void initComponents(){
        layout = new BorderPane();
        backButton = new Button("Save & Close");
        inventoryBox = new InventoryBox();
        reportBox = new ReportBox();
        menuBar = new MenuBar();
        scene = new Scene(layout);
        scene.getStylesheets().add("/stylesheets/stylesheets.css");
        initMenu();
        setStyles();
    }

    public void layoutComponents(){
        layout.setTop(menuBar);
        layout.setCenter(inventoryBox);
        layout.setRight(backButton);
    }

    public void initMenu(){
        menuBar = new MenuBar();




        menu = new Menu("Menu");
        inventoryMenuItem = new MenuItem("Inventory");
        reportMenuItem = new MenuItem("Report");

        menuBar.getMenus().add(menu);
        menu.getItems().addAll(inventoryMenuItem, reportMenuItem);

    }

    public void setStyles(){
        inventoryBox.getAddProductBox().getStyleClass().add("box-border");
        menuBar.getStyleClass().add("menu-bar");
    }

    public MenuBar getMenuBar() {
        return menuBar;
    }

    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public ReportTableView getReportTable() {
        return reportBox.getReportTable();
    }

    public void setReportTable(ReportTableView reportTable) {
        this.reportBox.setReportTable(reportTable);
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public MenuItem getInventoryMenuItem() {
        return inventoryMenuItem;
    }

    public void setInventoryMenuItem(MenuItem inventoryMenuItem) {
        this.inventoryMenuItem = inventoryMenuItem;
    }

    public MenuItem getReportMenuItem() {
        return reportMenuItem;
    }

    public void setReportMenuItem(MenuItem reportMenuItem) {
        this.reportMenuItem = reportMenuItem;
    }

    public BorderPane getLayout() {
        return layout;
    }

    public void setLayout(BorderPane layout) {
        this.layout = layout;
    }

    public InventoryBox getInventoryBox() {
        return inventoryBox;
    }

    public void setInventoryBox(InventoryBox inventoryBox) {
        this.inventoryBox = inventoryBox;
    }

    public ReportBox getReportBox() {
        return reportBox;
    }

    public void setReportBox(ReportBox reportBox) {
        this.reportBox = reportBox;
    }


    public CartTableView getCartTable(){
        return this.reportBox.getCartTable();
    }

    public void setCartTable(CartTableView cartTable){
        this.reportBox.setCartTable(cartTable);
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

    private BorderPane layout;
    private Button backButton;
    private InventoryBox inventoryBox;
    private ReportBox reportBox;
    private MenuBar menuBar;
    private Menu menu;
    private MenuItem inventoryMenuItem;
    private MenuItem reportMenuItem;
}
