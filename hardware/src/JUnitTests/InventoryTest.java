package JUnitTests;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Inventory;
import model.Product;

public class InventoryTest {

	public void setup() {
		name = "Box Nails";
		price = 13;
		type = "Components";
		quantity = 15;
		description = "For light construction";
		productId = 12345;
	}

	@Before
	public void init() {
		setup();
		product = new Product(name, price, quantity, description, type, productId);
		storage.addProduct(product);
	}

	@Test
	public void getSizeTest() {
		int size = storage.getSize();
		assertEquals(1, size);
	}

	@Test 
	public void getProductTest() {
		Boolean test = false;
		if (storage.getProduct(12345).getProductId() == product.getProductId()) {
			test = true;
		}
		assertEquals(true, test); 
	}
	
	@Test
	public void addProductTest() {
		Boolean test = false;
		
		String n = storage.getProduct(12345).getName();
		String t = storage.getProduct(12345).getType();
		String d = storage.getProduct(12345).getDescription();
		
		float p = storage.getProduct(12345).getPrice();
		if ((int) p == 13) {
			test = true;
		}
		
		assertEquals("Box Nails", n);
		assertEquals("Components", t);
		assertEquals("For light construction", d);
		assertEquals(true, test);
	}
	
	@Test
	public void removeProductTest() {
		storage.removeProduct(product, 7);
		int count = storage.getProduct(12345).getQuantity();
		assertEquals(8, count);
	}

	@After
	public void destroy() {
		storage.removeProduct(product);
	}

	protected String name, type, description;
	protected float price;
	protected int quantity, productId;
	private Product product;
	private Inventory storage = new Inventory();
}
