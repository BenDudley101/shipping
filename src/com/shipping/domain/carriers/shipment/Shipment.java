package com.shipping.domain.carriers.shipment;

import java.util.ArrayList;
import java.util.List;

/*
|-------------------|  1..*      |-------------------|     1..*     |-------------------|
|       Ship        |------------>|    Shipment      |------------->|   ShipmentItem    |
|-------------------|            |-------------------|              |-------------------|
| id                |            | id                |              | id                |
| name              |            | shipId            |              | product_name      |
| capacity          |            | shipmentItemIds   |              | weight            |
|-------------------|            |-------------------|              |-------------------|
 */

public class Shipment {

    private final Long id;
    private final List<ShipmentItem> items;

    public Shipment(final Long id, List<ShipmentItem> items) {
        if (id.equals(0L)) {
            throw new IllegalArgumentException("Shipment must have an id");
        }
        this.id = id;
        this.items = items;
    }

    public Shipment(final Long id) {
        if (id.equals(0L)) {
            throw new IllegalArgumentException("Shipment must have an id");
        }
        this.id = id;
        this.items = new ArrayList<>();
    }

    public Long getId() {
        return id;
    }

    public List<ShipmentItem> getItems() {
        return items;
    }

    // Add an item to the shipment.
    public void addShipmentItem(ShipmentItem shipmentItem) {
        items.add(shipmentItem);
    }

    // TODO: example business rule: Calculate total weight of the shipment

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Shipment shipment = (Shipment) obj;
        return id.equals(shipment.id);
    }

    @Override
    public String toString() {
        return "Shipment{" +
                "id='" + id + '\'' +
                '}';
    }
}