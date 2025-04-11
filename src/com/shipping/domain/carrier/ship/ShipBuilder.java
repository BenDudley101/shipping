package com.shipping.domain.carrier.ship;

public class ShipBuilder {

    private ShipName shipName;
    private ShipType shipType;
    private Long shipId;

    // Set the Ship's name
    public ShipBuilder name(final ShipName name) {
        this.shipName = name;
        return this;
    }

    public ShipBuilder id(final Long shipId) {
        this.shipId = shipId;
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
        if (shipId == 0L) {
            throw new IllegalArgumentException("Ship id must be provided");
        }
        if (shipType == null) {
            throw new IllegalArgumentException("Ship type must be provided");
        }
        return new Ship(shipName, shipId, shipType);
    }
}