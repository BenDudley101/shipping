package com.shipco.domain.carrier.shipment;

import com.shipco.domain.carrier.ship.ShipId;
import com.shipco.domain.carrier.voyage.VoyageId;
import org.jmolecules.ddd.annotation.AggregateRoot;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@AggregateRoot
public class Shipment {

    private final ShipmentId id;
    private final VoyageId voyageId;
    private final List<ShipmentItem> items = new ArrayList<>();
    private final ShipId shipId;
    private final ShipmentType shipmentType;

    public Shipment(final VoyageId voyageId, final ShipId shipId, final ShipmentType shipmentType) {
        this.id = new ShipmentId(UUID.randomUUID());
        this.voyageId = voyageId;
        this.shipId = shipId;
        this.shipmentType = shipmentType;
    }

    public ShipmentType getShipmentType() {
        return shipmentType;
    }

    public void addItem(ShipmentItem item) {
        items.add(item);
    }
}