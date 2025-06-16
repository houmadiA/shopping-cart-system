package com.shopping.cart.system.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Product {
    HIGH_END_PHONE("High-End Phone"),
    MID_RANGE_PHONE("Mid-Range Phone"),
    LAPTOP("Laptop");

    private final String displayName;
}