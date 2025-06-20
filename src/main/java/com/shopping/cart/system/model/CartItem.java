package com.shopping.cart.system.model;

public record CartItem(Product product, int quantity) {
    public CartItem {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
    }
}