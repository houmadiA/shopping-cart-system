package com.shopping.cart.system.service.pricing;

import com.shopping.cart.system.model.Product;

public class LargeBusinessPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(Product product) {
        return switch (product) {
            case HIGH_END_PHONE -> 1000.0;
            case MID_RANGE_PHONE -> 550.0;
            case LAPTOP -> 900.0;
        };
    }
}