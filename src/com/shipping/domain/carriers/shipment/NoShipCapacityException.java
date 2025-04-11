package com.shipping.domain.carriers.shipment;

public class NoShipCapacityException extends Exception {
    public NoShipCapacityException(String message) {
        super(message);
    }
}
