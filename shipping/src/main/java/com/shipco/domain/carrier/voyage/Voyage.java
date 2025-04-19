package com.shipco.domain.carrier.voyage;

import com.shipco.domain.carrier.customer.CustomerId;
import com.shipco.domain.carrier.shipment.ShipmentAssignmentException;
import com.shipco.domain.carrier.price.Price;
import com.shipco.domain.carrier.route.Route;
import com.shipco.domain.carrier.ship.*;
import com.shipco.domain.carrier.shipment.Shipment;
import com.shipco.domain.carrier.shipment.ValidateShipmentRules;
import org.jmolecules.ddd.annotation.AggregateRoot;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

// Central coordinating aggregate root
@AggregateRoot
public class Voyage {

    private final VoyageId id;
    private final CustomerId customerId;
    private final List<Shipment> shipments;
    private final Route route;
    private final Price price;

    public Voyage(CustomerId customerId, List<Shipment> shipments, Route route, Price price) {
        this.id = new VoyageId(UUID.randomUUID());
        this.customerId = customerId;
        this.shipments = shipments;
        this.route = route;
        this.price = price;
    }

    public VoyageId getId() {
        return this.id;
    }

    public void assignShipment(Shipment shipment) throws ShipmentAssignmentException {
        //validate shipment
        ValidateShipmentRules validateShipmentRules = new ValidateShipmentRules();
        boolean isValid = validateShipmentRules.isValidShipment(shipment);

        // Ensure it meets capacity/constraints
        if (isValid && Objects.nonNull(checkCapacity(shipment))) {
            shipments.add(shipment);
        }
        throw new ShipmentAssignmentException("No ship capacity");
    }

    public Ship checkCapacity(Shipment shipment) {

        final ShipBuilder builder = new ShipBuilder();
        final List<Ship> ships = List.of(
                builder
                        .name(new ShipName(ShipConstants.THOR))
                        .capacity(new BigDecimal(101))
                        .shipId(new ShipId(UUID.randomUUID()))
                        .type(ShipType.CAUSTIC_SODA_BULK_SHIP)
                        .build(),
                builder
                        .name(new ShipName(ShipConstants.ODIN))
                        .capacity(new BigDecimal(99))
                        .shipId(new ShipId(UUID.randomUUID()))
                        .type(ShipType.CLEAN_PETROLEUM_PRODUCT_BULK_SHIP)
                        .build()
        );
        // One of the most powerful features in Java for functional programming is Streams
        final Optional<Ship> result = ships.stream()
                .filter(ship -> ship.getCapacity().compareTo(new BigDecimal("100")) > 0)  // Check if capacity > 100
                .findFirst();  // Return the first match in an Optional
        return result.orElse(null);
    }
}