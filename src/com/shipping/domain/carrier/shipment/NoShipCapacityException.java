package com.shipping.domain.carrier.shipment;

public class NoShipCapacityException extends Exception {
    public NoShipCapacityException(String message) {
        super(message);
    }
}
