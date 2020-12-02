package JUnitTests;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Cart;
import model.Product;
import model.Receipt;
import model.Report;

public class ReportTests {

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
		cart1.addProduct(product1);
		cart2.addProduct(product2);
		receipt1 = new Receipt(cart1);
		receipt2 = new Receipt(cart2);
		report.addReceipt(receipt1);
		report.addReceipt(receipt2);
	}

	@Test 
	public void getSizeTest() {
		int size = report.getSize();
		assertEquals(2, size);
	}

	@Test
	public void addReceiptTest() {
		Boolean test1 = false;
		Boolean test2 = false;

		if (receipt1.getCart().getProduct(productId1) == cart1.getProduct(productId1)) {
			test1 = true;
		}
		assertEquals(true, test1);
		if (receipt2.getCart().getProduct(productId2) == cart2.getProduct(productId2)) {
			test2 = true;
		}
		assertEquals(true, test2);

		for (int i = 0; i < report.getSize(); i++) {
			if (i == 0) {
				assertEquals(195, (int)report.getReport().get(i).getCart().getTotal());	
			}
			if (i == 1) {
				assertEquals(35, (int)report.getReport().get(i).getCart().getTotal());	
			}
		}
	}

	@After
	public void destroy() {
		cart1.removeProduct(product1);
		cart2.removeProduct(product2);
	}

	protected String name1, type1, description1, name2, type2, description2;
	protected float price1, price2;
	protected int quantity1, productId1, quantity2, productId2;
	private Product product1, product2;
	private Cart cart1 = new Cart();
	private Cart cart2 = new Cart();
	private Receipt receipt1, receipt2;
	private Report report = new Report();
}
