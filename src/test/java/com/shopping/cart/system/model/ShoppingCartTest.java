package com.shopping.cart.system.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ShoppingCartTest {
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        cart = new ShoppingCart();
    }

    @Test
    public void testEmptyCart() {
        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getTotalItems());
        assertEquals(0, cart.getItems().size());
    }

    @Test
    public void testAddItem() {
        cart.addItem(Product.HIGH_END_PHONE, 2);

        assertFalse(cart.isEmpty());
        assertEquals(2, cart.getTotalItems());
        assertEquals(1, cart.getItems().size());

        CartItem item = cart.getItems().get(0);
        assertEquals(Product.HIGH_END_PHONE, item.product());
        assertEquals(2, item.quantity());
    }

    @Test
    public void testAddMultipleItems() {
        cart.addItem(Product.HIGH_END_PHONE, 1);
        cart.addItem(Product.LAPTOP, 2);

        assertEquals(3, cart.getTotalItems());
        assertEquals(2, cart.getItems().size());
    }

    @Test
    public void testAddInvalidItem() {
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(Product.HIGH_END_PHONE, 0));
        assertThrows(IllegalArgumentException.class,
                () -> cart.addItem(null, 1));
    }

    @Test
    public void testClearCart() {
        cart.addItem(Product.HIGH_END_PHONE, 1);
        cart.clear();

        assertTrue(cart.isEmpty());
        assertEquals(0, cart.getTotalItems());
    }
}