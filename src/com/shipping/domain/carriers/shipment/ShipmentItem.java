package com.shipping.domain.carriers.shipment;

/*
|-------------------|  1..*      |-------------------|     1..*     |-------------------|
|       Ship        |------------>|    Shipment      |------------->|   ShipmentItem    |
|-------------------|            |-------------------|              |-------------------|
| id                |            | id                |              | id                |
| name              |            | shipId            |              | product_name      |
| capacity          |            | shipmentItemIds   |              | weight            |
|-------------------|            |-------------------|              |-------------------|
 */

public record ShipmentItem(Long productId, Long quantity) {
    public ShipmentItem {
        if (quantity <= 0) {
            throw new IllegalArgumentException("Quantity must be greater than zero");
        }
        if (productId == 0L) {
            throw new IllegalArgumentException("Shipment item must have a product id ");
        }
    }
}

