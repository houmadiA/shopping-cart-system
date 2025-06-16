package com.shopping.cart.system.model.client;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class BusinessClient extends Client {
    private final String companyName;
    private final String vatNumber;
    private final String sirenNumber;
    private final double annualRevenue;

    public BusinessClient(String clientId, String companyName, String vatNumber,
                          String sirenNumber, double annualRevenue) {
        super(clientId);
        if (companyName == null || companyName.trim().isEmpty()) {
            throw new IllegalArgumentException("Company name cannot be null or empty");
        }
        if (sirenNumber == null || sirenNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("SIREN number cannot be null or empty");
        }
        if (annualRevenue < 0) {
            throw new IllegalArgumentException("Annual revenue cannot be negative");
        }

        this.companyName = companyName;
        this.vatNumber = vatNumber;
        this.sirenNumber = sirenNumber;
        this.annualRevenue = annualRevenue;
    }

    public boolean isLargeEnterprise() {
        return annualRevenue > 10_000_000;
    }

    @Override
    public ClientType getClientType() {
        return ClientType.BUSINESS;
    }
}