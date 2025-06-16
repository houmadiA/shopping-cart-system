package com.shopping.cart.system.service;

import com.shopping.cart.system.model.client.BusinessClient;
import com.shopping.cart.system.model.client.IndividualClient;
import com.shopping.cart.system.model.Product;
import com.shopping.cart.system.model.ShoppingCart;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class CartCalculatorTest {
    private CartCalculator calculator;
    private ShoppingCart cart;

    @BeforeEach
    public void setUp() {
        calculator = new CartCalculator();
        cart = new ShoppingCart();
    }

    @Test
    public void testIndividualClientCalculation() {
        var client = new IndividualClient("001", "John", "Doe");
        cart.addItem(Product.HIGH_END_PHONE, 1);
        cart.addItem(Product.LAPTOP, 2);

        double total = calculator.calculateTotal(client, cart);
        double expected = 1500 + (1200 * 2); // 3900

        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testSmallBusinessClientCalculation() {
        var client = new BusinessClient("002", "SmallBiz", null,
                "123456789", 5_000_000);
        cart.addItem(Product.HIGH_END_PHONE, 2);
        cart.addItem(Product.MID_RANGE_PHONE, 1);

        double total = calculator.calculateTotal(client, cart);
        double expected = (1150 * 2) + 600; // 2900

        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testLargeBusinessClientCalculation() {
        var client = new BusinessClient("003", "BigCorp", "FR123456789",
                "987654321", 50_000_000);
        cart.addItem(Product.LAPTOP, 3);
        cart.addItem(Product.MID_RANGE_PHONE, 2);

        double total = calculator.calculateTotal(client, cart);
        double expected = (900 * 3) + (550 * 2); // 3800

        assertEquals(expected, total, 0.01);
    }

    @Test
    public void testEmptyCart() {
        var client = new IndividualClient("001", "John", "Doe");

        double total = calculator.calculateTotal(client, cart);
        assertEquals(0.0, total, 0.01);
    }

    @Test
    public void testNullInputs() {
        var client = new IndividualClient("001", "John", "Doe");

        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateTotal(null, cart));
        assertThrows(IllegalArgumentException.class,
                () -> calculator.calculateTotal(client, null));
    }
}