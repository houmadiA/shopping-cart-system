package com.shopping.cart.system.model.client;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class IndividualClient extends Client {
    private final String firstName;
    private final String lastName;

    public IndividualClient(String clientId, String firstName, String lastName) {
        super(clientId);
        if (firstName == null || firstName.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be null or empty");
        }
        if (lastName == null || lastName.trim().isEmpty()) {
            throw new IllegalArgumentException("Last name cannot be null or empty");
        }
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public ClientType getClientType() {
        return ClientType.INDIVIDUAL;
    }
}