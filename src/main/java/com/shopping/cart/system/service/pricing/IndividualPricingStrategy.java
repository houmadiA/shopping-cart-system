package com.shopping.cart.system.service.pricing;

import com.shopping.cart.system.model.Product;

public class IndividualPricingStrategy implements PricingStrategy {
    @Override
    public double getPrice(Product product) {
        return switch (product) {
            case HIGH_END_PHONE -> 1500.0;
            case MID_RANGE_PHONE -> 800.0;
            case LAPTOP -> 1200.0;
        };
    }
}