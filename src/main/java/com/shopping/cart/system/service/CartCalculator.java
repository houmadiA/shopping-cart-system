package com.shopping.cart.system.service;

import com.shopping.cart.system.model.CartItem;
import com.shopping.cart.system.model.client.Client;
import com.shopping.cart.system.model.ShoppingCart;
import com.shopping.cart.system.service.pricing.PricingStrategy;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class CartCalculator {

    public double calculateTotal(Client client, ShoppingCart cart) {
        if (client == null) {
            throw new IllegalArgumentException("Client cannot be null");
        }
        if (cart == null) {
            throw new IllegalArgumentException("Shopping cart cannot be null");
        }

        var pricingStrategy = PricingStrategyFactory.createPricingStrategy(client);

        return cart.getItems().stream()
                .mapToDouble(item -> calculateItemCost(item, pricingStrategy))
                .sum();
    }

    private double calculateItemCost(CartItem item, PricingStrategy pricingStrategy) {
        double unitPrice = pricingStrategy.getPrice(item.product());
        return unitPrice * item.quantity();
    }
}