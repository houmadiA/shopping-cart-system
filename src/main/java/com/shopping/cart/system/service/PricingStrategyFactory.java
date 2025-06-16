package com.shopping.cart.system.service;

import com.shopping.cart.system.model.client.BusinessClient;
import com.shopping.cart.system.model.client.Client;
import com.shopping.cart.system.model.client.IndividualClient;
import com.shopping.cart.system.service.pricing.IndividualPricingStrategy;
import com.shopping.cart.system.service.pricing.LargeBusinessPricingStrategy;
import com.shopping.cart.system.service.pricing.PricingStrategy;
import com.shopping.cart.system.service.pricing.SmallBusinessPricingStrategy;

public class PricingStrategyFactory {
    public static PricingStrategy createPricingStrategy(Client client) {
        if (client instanceof IndividualClient) {
            return new IndividualPricingStrategy();
        } else if (client instanceof BusinessClient businessClient) {
            return businessClient.isLargeEnterprise()
                    ? new LargeBusinessPricingStrategy()
                    : new SmallBusinessPricingStrategy();
        } else {
            throw new IllegalArgumentException("Unknown client type: " + client.getClass());
        }
    }
}