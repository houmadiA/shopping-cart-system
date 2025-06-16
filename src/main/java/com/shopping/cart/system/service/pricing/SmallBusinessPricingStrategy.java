package com.shopping.cart.system.service.pricing;

import com.shopping.cart.system.model.Product;

public class SmallBusinessPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(Product product) {
        return switch (product) {
            case HIGH_END_PHONE -> 1150.0;
            case MID_RANGE_PHONE -> 600.0;
            case LAPTOP -> 1000.0;
        };
    }
}