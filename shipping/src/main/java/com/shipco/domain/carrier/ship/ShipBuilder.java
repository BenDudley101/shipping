package com.shipco.domain.carrier.ship;

import java.math.BigDecimal;

public class ShipBuilder {
    private ShipName shipName;
    private ShipType shipType;
    private ShipId shipId;
    private BigDecimal capacity;

    // Set the Ship's name
    public ShipBuilder name(final ShipName name) {
        this.shipName = name;
        return this;
    }

    public ShipBuilder shipId(final ShipId shipId) {
        this.shipId = shipId;
        return this;
    }

    public ShipBuilder capacity(final BigDecimal capacity) {
        this.capacity = capacity;
        return this;
    }

    public ShipBuilder type(final ShipType shipType) {
        this.shipType = shipType;
        return this;
    }

    public Ship build() {
        if (shipName == null) {
            throw new IllegalArgumentException("Ship name must be provided");
        }
        if (shipId == null) {
            throw new IllegalArgumentException("Ship id must be provided");
        }
        if (shipType == null) {
            throw new IllegalArgumentException("Ship type must be provided");
        }
        if (capacity == null) {
            throw new IllegalArgumentException("Ship capacity must be provided");
        }
        return new Ship(shipId, shipName, capacity, shipType);
    }
}