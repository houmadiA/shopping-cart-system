package com.shopping.cart.system;

import com.shopping.cart.system.model.client.BusinessClient;
import com.shopping.cart.system.model.client.IndividualClient;
import com.shopping.cart.system.model.Product;
import com.shopping.cart.system.model.ShoppingCart;
import com.shopping.cart.system.service.CartCalculator;

public class Main {
    public static void main(String[] args) {
        // Create clients
        var individualClient = new IndividualClient("001", "Alice", "Smith");
        var smallBusiness = new BusinessClient("002", "SmallTech", null,
                "123456789", 5_000_000);
        var largeBusiness = new BusinessClient("003", "BigCorp", "FR123456789",
                "987654321", 25_000_000);

        // Create calculator
        var calculator = new CartCalculator();

        // Demo for individual client
        System.out.println("=== Individual Client Demo ===");
        var individualClientCart = new ShoppingCart();
        individualClientCart.addItem(Product.HIGH_END_PHONE, 1);
        individualClientCart.addItem(Product.LAPTOP, 1);

        double individualClientTotal = calculator.calculateTotal(individualClient, individualClientCart);
        System.out.printf("Client: %s\n", individualClient);
        System.out.printf("Cart: %s\n", individualClientCart);
        System.out.printf("Total: €%.2f\n\n", individualClientTotal);

        // Demo for small business
        System.out.println("=== Small Business Client Demo ===");
        var smallBusinessCart = new ShoppingCart();
        smallBusinessCart.addItem(Product.HIGH_END_PHONE, 2);
        smallBusinessCart.addItem(Product.MID_RANGE_PHONE, 3);

        double smallBusinessTotal = calculator.calculateTotal(smallBusiness, smallBusinessCart);
        System.out.printf("Client: %s\n", smallBusiness);
        System.out.printf("Cart: %s\n", smallBusinessCart);
        System.out.printf("Total: €%.2f\n\n", smallBusinessTotal);

        // Demo for large business
        System.out.println("=== Large Business Client Demo ===");
        var largeBusinessCart = new ShoppingCart();
        largeBusinessCart.addItem(Product.LAPTOP, 5);
        largeBusinessCart.addItem(Product.HIGH_END_PHONE, 1);

        double largeBusinessTotal = calculator.calculateTotal(largeBusiness, largeBusinessCart);
        System.out.printf("Client: %s\n", largeBusiness);
        System.out.printf("Cart: %s\n", largeBusinessCart);
        System.out.printf("Total: €%.2f\n", largeBusinessTotal);
    }
}
