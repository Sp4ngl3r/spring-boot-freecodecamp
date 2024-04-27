package com.spangler.springfreecodecamp.model;

public record OrderRecord(
        String customerName,
        String productName,
        Integer quantity
) {
}
