package com.shopping.cart.system.service.pricing;

import com.shopping.cart.system.model.Product;

public interface PricingStrategy {
    double getPrice(Product product);
}