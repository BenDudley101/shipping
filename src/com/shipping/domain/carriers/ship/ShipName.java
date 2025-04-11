package com.shipping.domain.carriers.ship;

public record ShipName(String shipName) {
    public ShipName {
        if (shipName == null || shipName.isBlank()) {
            throw new IllegalArgumentException("Ship name cannot be null or blank.");
        }
    }
}