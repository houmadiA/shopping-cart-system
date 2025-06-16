package com.shopping.cart.system.service;

import com.shopping.cart.system.model.Product;
import com.shopping.cart.system.service.pricing.IndividualPricingStrategy;
import com.shopping.cart.system.service.pricing.LargeBusinessPricingStrategy;
import com.shopping.cart.system.service.pricing.SmallBusinessPricingStrategy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PricingStrategyTest {

    @Test
    public void testIndividualPricing() {
        var strategy = new IndividualPricingStrategy();

        assertEquals(1500.0, strategy.getPrice(Product.HIGH_END_PHONE));
        assertEquals(800.0, strategy.getPrice(Product.MID_RANGE_PHONE));
        assertEquals(1200.0, strategy.getPrice(Product.LAPTOP));
    }

    @Test
    public void testSmallBusinessPricing() {
        var strategy = new SmallBusinessPricingStrategy();

        assertEquals(1150.0, strategy.getPrice(Product.HIGH_END_PHONE));
        assertEquals(600.0, strategy.getPrice(Product.MID_RANGE_PHONE));
        assertEquals(1000.0, strategy.getPrice(Product.LAPTOP));
    }

    @Test
    public void testLargeBusinessPricing() {
        var strategy = new LargeBusinessPricingStrategy();

        assertEquals(1000.0, strategy.getPrice(Product.HIGH_END_PHONE));
        assertEquals(550.0, strategy.getPrice(Product.MID_RANGE_PHONE));
        assertEquals(900.0, strategy.getPrice(Product.LAPTOP));
    }
}