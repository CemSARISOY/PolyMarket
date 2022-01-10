package test;

import static org.junit.Assert.assertTrue;

import java.sql.Date;

import org.junit.Test;

import Core.User;
import Core.Cart;
import Core.CartFacade;
import Core.Product;

public class CartTest {


	@Test
	void addProductTest() {
		Cart cart = new Cart(-1,"Junit");
		
		assertTrue(cart.getNbItems() == 0);
		Product product = new Product(-1, null, null, null, null, null, null, 0, null, false);
		cart.addProduct(product);
		assertTrue(cart.getNbItems()==1);
		assertTrue(cart.getItemsInCart().contains(product));
	}
}
