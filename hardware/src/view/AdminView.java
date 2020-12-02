package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import view.components.*;

/**
 * 
 * View for admin screen
 *
 */
public class AdminView extends View{

	/**
	 * Constructor
	 */
    public AdminView() {
        super();
    }

    /**
     * Initializes components
     */
    public void initComponents(){
        layout = new BorderPane();
        backButton = new Button("Save & Close");
        inventoryBox = new InventoryBox();
        reportBox = new ReportBox();
        menuBar = new MenuBar();
        scene = new Scene(layout);
        scene.getStylesheets().add("/stylesheets/stylesheets.css");
        titleText = new Text(TITLE_TEXT);
        initMenu();
        setStyles();
    }

    /**
     * Puts components in layout
     */
    public void layoutComponents(){
        VBox topBox = new VBox();
        topBox.getChildren().addAll(titleText, menuBar);
        topBox.getStyleClass().add("title-background");
        layout.setTop(topBox);
        layout.setCenter(inventoryBox);
        layout.setRight(backButton);
    }

    /**
     * initializes menu bar
     */
    public void initMenu(){
        menuBar = new MenuBar();

        menu = new Menu("Menu");
        inventoryMenuItem = new MenuItem("Inventory");
        reportMenuItem = new MenuItem("Report");

        menuBar.getMenus().add(menu);
        menu.getItems().addAll(inventoryMenuItem, reportMenuItem);

    }

    /**
     * sets style to css file
     */
    public void setStyles(){
        menuBar.getStyleClass().add("menu-bar");
        titleText.getStyleClass().add("title-text");

    }

    /**
     * return menu bar
     * @return menu bar
     */
    public MenuBar getMenuBar() {
        return menuBar;
    }

    /**
     * sets menu bar
     * @param menuBar new menu bar
     */
    public void setMenuBar(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    /**
     * return report table
     * @return report table
     */
    public ReportTableView getReportTable() {
        return reportBox.getReportTable();
    }
    
    /**
     * sets report table
     * @param reportTable new report table
     */
    public void setReportTable(ReportTableView reportTable) {
        this.reportBox.setReportTable(reportTable);
    }

    /**
     * return menu
     * @return menu
     */
    public Menu getMenu() {
        return menu;
    }

    /**
     * set menu
     * @param menu new menu
     */
    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    /**
     * return inventory menu item
     * @return inventory menu item
     */
    public MenuItem getInventoryMenuItem() {
        return inventoryMenuItem;
    }

    /**
     * sets inventory menu item
     * @param inventoryMenuItem new inventory meu item
     */
    public void setInventoryMenuItem(MenuItem inventoryMenuItem) {
        this.inventoryMenuItem = inventoryMenuItem;
    }

    /**
     * return report menu item
     * @return report menu item
     */
    public MenuItem getReportMenuItem() {
        return reportMenuItem;
    }

    /**
     * sets report menu item
     * @param reportMenuItem new report menu item
     */
    public void setReportMenuItem(MenuItem reportMenuItem) {
        this.reportMenuItem = reportMenuItem;
    }

    /**
     * return layout
     * @return layout
     */
    public BorderPane getLayout() {
        return layout;
    }

    /**
     * set layout
     * @param layout
 new layout     */
    public void setLayout(BorderPane layout) {
        this.layout = layout;
    }

    /**
     * return inventory box
     * @return inventory box
     */
    public InventoryBox getInventoryBox() {
        return inventoryBox;
    }

    /**
     * set inventory box
     * @param inventoryBox inventory box
     */
    public void setInventoryBox(InventoryBox inventoryBox) {
        this.inventoryBox = inventoryBox;
    }

    /**
     * return report box
     * @return report box
     */
    public ReportBox getReportBox() {
        return reportBox;
    }

    /**
     * set report box
     * @param reportBox new report box
     */
    public void setReportBox(ReportBox reportBox) {
        this.reportBox = reportBox;
    }

    /**
     * reeturn cart table
     * @return cart table
     */
    public CartTableView getCartTable(){
        return this.reportBox.getCartTable();
    }

    /**
     * sets cart table
     * @param cartTable new cart table
     */
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
    private Text titleText;
    private final String TITLE_TEXT = "Administration";
}
