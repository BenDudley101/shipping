package com.shipping.domain.carriers.ship;

import com.shipping.domain.carriers.shipment.NoShipCapacityException;
import com.shipping.domain.carriers.shipment.Shipment;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/*
|-------------------|  1..*      |-------------------|     1..*     |-------------------|
|       Ship        |------------>|    Shipment      |------------->|   ShipmentItem    |
|-------------------|            |-------------------|              |-------------------|
| id                |            | id                |              | id                |
| name              |            | shipId            |              | product_name      |
| capacity          |            | shipmentItemIds   |              | weight            |
|-------------------|            |-------------------|              |-------------------|
 */
public class Ship {

    private final ShipName shipName;
    private final Long id;
    private final ShipType shipType;
    private final List<Shipment> shipments;
    // TODO ship capacity, etc

    protected Ship(final ShipName shipName, Long id, ShipType shipType) {
        if (shipName == null) {
            throw new IllegalArgumentException("Ship must have a name");
        }
        this.shipName = shipName;
        if (id.equals(0L)) {
            throw new IllegalArgumentException("Ship must have an id");
        }
        this.id = id;
        if (shipType == null) {
            throw new IllegalArgumentException("Ship must have a type");
        }
        this.shipType = shipType;
        this.shipments = new ArrayList<>();
    }

    public ShipName getName() {
        return shipName;
    }

    public List<Shipment> getShipments() {
        return shipments;
    }

    public Shipment addShipment(Shipment shipment) throws NoShipCapacityException {
        //TODO check capacity of this ship
        if (calculateCapacity() > 0) {
            throw new NoShipCapacityException("Not enough capacity on the ship.");
        }
        System.out.println("Shipment added to the ship.");
        shipments.add(shipment);
        return shipment;
    }

    private int calculateCapacity() {

        final Function<Integer, Integer> increaseCapacity = capacity -> capacity + 10;
        final Function<Integer, Integer> multiplyCapacity = capacity -> (int) (capacity * 1.5);
        final Function<Integer, Integer> increaseThenMultiply = increaseCapacity.andThen(multiplyCapacity);
        int initialCapacity = 100;

        int finalCapacity = applyTransformation(increaseThenMultiply, initialCapacity);

        System.out.println("Initial capacity: " + initialCapacity);
        System.out.println("Final capacity after operations: " + finalCapacity);  // Should be (100 + 10) * 1.5 = 165
        return finalCapacity;
    }

    // Method that accepts a Function and an integer value, applies the function to the value, and returns the result
    private static int applyTransformation(Function<Integer, Integer> transformation, int value) {
        return transformation.apply(value);  // Applies the function to the value
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ship ship = (Ship) obj;
        if (!id.equals(ship.id)) return false;
        if (!shipType.equals(ship.shipType)) return false;
        return shipName.equals(ship.shipName);
    }

    @Override
    public String toString() {
        return "Ship{" +
                "id='" + id + '\'' +
                "name='" + shipName + '\'' +
                '}';
    }
}