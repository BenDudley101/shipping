package com.shipping.service;

import com.shipping.domain.carriers.ship.Ship;
import com.shipping.domain.carriers.ship.ShipConstants;
import com.shipping.domain.carriers.ship.ShipName;
import com.shipping.domain.carriers.ship.ShipRepository;
import com.shipping.infrastructure.carriers.ShipRepositoryImpl;

public class ShipmentService {

    public void createShipment() {

        //TODO create a shipment, add shipment items to the shipment
        final ShipRepository shipRepository = new ShipRepositoryImpl();
        final Ship ship = shipRepository.findByName(new ShipName(ShipConstants.ODIN)).orElseThrow(() -> new RuntimeException("Ship not found"));
        //ship.addShipment(shipment);
        shipRepository.save(ship);
    }
}
