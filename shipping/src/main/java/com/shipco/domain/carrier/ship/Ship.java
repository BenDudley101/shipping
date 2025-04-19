package com.shipco.domain.carrier.ship;

import com.shipco.domain.carrier.route.Route;
import com.shipco.domain.carrier.shipment.ShipmentItem;
import org.jmolecules.ddd.annotation.Entity;

import java.math.BigDecimal;
import java.util.function.Function;

@Entity
public class Ship {
    private Route route;
    private final ShipId id;
    private final ShipName shipName;
    private final BigDecimal capacity;
    private final ShipType shipType;

    public Ship(final ShipId shipId, final ShipName shipName, final BigDecimal capacity, final ShipType shipType) {
        this.id = shipId;
        this.shipName = shipName;
        this.capacity = capacity;
        this.shipType = shipType;
    }

    public ShipName getShipName() {
        return shipName;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    private BigDecimal calculateOverAllocationCapacity() {

        BigDecimal finalCapacity = applyTransformation(CapacityFunctions.increaseThenMultiply, this.capacity);
        System.out.println("Initial capacity: " + this.capacity.toString());
        System.out.println("Overallocation capacity: " + finalCapacity);  // Should be (100 + 10) * 1.5 = 165
        return finalCapacity;
    }

    // Method that accepts a Function and an integer value, applies the function to the value, and returns the result
    private static BigDecimal applyTransformation(Function<BigDecimal, BigDecimal> transformation, BigDecimal value) {
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