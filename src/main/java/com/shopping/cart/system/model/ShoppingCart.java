package com.shopping.cart.system.model;

import lombok.ToString;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ToString
public class ShoppingCart {
    private final List<CartItem> items;

    public ShoppingCart() {
        this.items = new ArrayList<>();
    }

    public void addItem(Product product, int quantity) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be positive");
        }
        items.add(new CartItem(product, quantity));
    }

    public void addItem(CartItem item) {
        if (item == null) {
            throw new IllegalArgumentException("Cart item cannot be null");
        }
        items.add(item);
    }

    public List<CartItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public boolean isEmpty() {
        return items.isEmpty();
    }

    public int getTotalItems() {
        return items.stream()
                .mapToInt(CartItem::quantity)
                .sum();
    }

    public void clear() {
        items.clear();
    }
}