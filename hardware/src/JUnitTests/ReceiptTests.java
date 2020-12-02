package JUnitTests;

import static org.junit.Assert.*;
import java.time.LocalDateTime;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import model.Cart;
import model.Product;
import model.Receipt;

public class ReceiptTests {

	public void setup() {
		name1 = "Box Nails";
		price1 = 13;
		type1 = "Components";
		quantity1 = 15;
		description1 = "For light construction";
		productId1 = 12345;
		
		name2 = "Common Nails";
		price2 = 7;
		type2 = "Components";
		quantity2 = 5;
		description2 = "For construction";
		productId2 = 5678;
	}
		
	@Before
	public void init() {
		setup();
		product1 = new Product(name1, price1, quantity1, description1, type1, productId1);
		product2 = new Product(name2, price2, quantity2, description2, type2, productId2);
		cart.addProduct(product1);
		cart.addProduct(product2);
	}
	
	@Test
	public void computeTimeStampTest() {
		datetime = LocalDateTime.now();
		String clock = datetime.getHour() + ":" + datetime.getMinute() + " "
				+ datetime.getMonth() + " " + datetime.getDayOfMonth()
				+ ", " + datetime.getYear();
		assertEquals(clock, receipt.computeTimestamp());
	}
	
	@Test
	public void getTotalTest() {
		int total = (int) receipt.getCart().getTotal();
		assertEquals(230, total);
	}
	@After
	public void destroy() {
		cart.removeProduct(product1);
		cart.removeProduct(product2);
	}

	protected String name1, type1, description1, name2, type2, description2;
	protected float price1, price2;
	protected int quantity1, productId1, quantity2, productId2;
	private Product product1, product2;
	private Cart cart = new Cart();
	private Receipt receipt = new Receipt(cart);
	private LocalDateTime datetime;
}
