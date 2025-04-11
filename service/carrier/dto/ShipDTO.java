package com.shipping.service.carrier.dto;

import com.shipping.domain.carrier.ship.ShipName;

public record ShipDTO(ShipName shipName) {

    public ShipDTO {
        if (shipName == null) {
            throw new IllegalArgumentException("Ship name cannot be null");
        }
    }
}