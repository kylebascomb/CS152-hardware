package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import controller.AdminController;
import model.Inventory;
import model.Product;
import model.ShopData;

public class AdminControllerTest {

	protected void setup() {
		name = "Box Nails";
		price = "1.75";
		type = "12345";
		quantity = "15";
		description = "Components";
		productId = "Light construction";
	}


	@Before 
	public void init() { 
		admin.addProduct(name, price, type, quantity, description, productId);
	}

	@Test
	public void addProductTest() {
		Boolean itemAdded = false;
		storage = admin.getInventory();
		for (int i = 0; i < storage.getSize(); i++) {
			if (storage.getProduct(i).getName() == name) {
				itemAdded = true;
			}
		}
		assertEquals("New product has been added to the inventory", true, itemAdded);
	}

	@After
	public void destroy() {

	}

	protected String name, price, type, quantity, description, productId;
	private Product product;
	private ShopData shopData;
	private Inventory storage;
	private AdminController admin = new AdminController(shopData);
}
