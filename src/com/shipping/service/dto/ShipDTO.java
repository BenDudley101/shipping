package com.shipping.service.dto;

import com.shipping.domain.carriers.ship.ShipName;

public record ShipDTO(ShipName shipName) {

    public ShipDTO {
        if (shipName == null) {
            throw new IllegalArgumentException("Ship name cannot be null");
        }
    }
}