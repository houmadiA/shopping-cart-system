package com.shopping.cart.system.model.client;

import lombok.Getter;

@Getter
public abstract class Client {
    protected final String clientId;

    public Client(String clientId) {
        if (clientId == null || clientId.trim().isEmpty()) {
            throw new IllegalArgumentException("Client ID cannot be null or empty");
        }
        this.clientId = clientId;
    }

    public abstract ClientType getClientType();
}