package com.shipping.service.carrier;

import com.shipping.domain.carrier.ship.Ship;
import com.shipping.domain.carrier.ship.ShipConstants;
import com.shipping.domain.carrier.ship.ShipName;
import com.shipping.domain.carrier.ship.ShipRepository;
import com.shipping.infrastructure.carrier.ShipRepositoryImpl;

public class ShipmentService {

    public void createShipment() {

        //TODO create a shipment, add shipment items to the shipment
        final ShipRepository shipRepository = new ShipRepositoryImpl();
        final Ship ship = shipRepository.findByName(new ShipName(ShipConstants.ODIN)).orElseThrow(() -> new RuntimeException("Ship not found"));
        //ship.addShipment(shipment);
        shipRepository.save(ship);
    }
}
