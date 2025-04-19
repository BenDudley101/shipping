package com.shipco.domain.carrier.shipment;

import org.jmolecules.ddd.annotation.Entity;
import java.util.UUID;

@Entity
public class ShipmentItem {
    private final ShipmentItemId id;
    private final String productName;
    private final double weight;

    public ShipmentItem(String productName, double weight) {
        this.id = new ShipmentItemId(UUID.randomUUID());
        this.productName = productName;
        this.weight = weight;
    }
}
