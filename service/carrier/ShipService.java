package com.shipping.service.carrier;

import com.shipping.domain.carrier.ship.*;
import com.shipping.service.carrier.dto.ShipDTO;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class ShipService {

    private ShipRepository shipRepository;
    private final List<Ship> ships;

    public ShipService() {
        final ShipBuilder builder = new ShipBuilder();
        this.ships = List.of(
                builder.name(new ShipName(ShipConstants.THOR)).id(1L).type(ShipType.CAUSTIC_SODA_BULK_SHIP).build(),
                builder.name(new ShipName(ShipConstants.ODIN)).id(1L).type(ShipType.CLEAN_PETROLEUM_PRODUCT_BULK_SHIP).build()
        );
    }

    public ShipDTO getShipById(Long shipId) {
        // Stream optional
        final Optional<Ship> ship = shipRepository.findById(shipId);
        // TODO Convert the ship entity to ShipDTO
        return null;
    }

    public void createShip(ShipDTO shipDTO) {

    }

    public void deleteShip(ShipDTO shipDTO) {

    }

    public List<ShipDTO> createShips() {
        if (ships == null || ships.isEmpty()) {
            return Collections.emptyList();
        }

        return ships.stream()
                .map(ship -> new ShipDTO(ship.getName()))
                .collect(Collectors.toList());
    }

    public String getShipName() {
        if (ships == null || ships.isEmpty()) {
            return "";
        }

        // One of the most powerful features in Java for functional programming is Streams
        Optional<String> result = ships.stream()
                .map(Ship::getName)  // Get ShipName for each ship
                .filter(shipName -> shipName.equals(new ShipName(ShipConstants.ODIN)))  // Filter by ship name
                .map(ShipName::shipName)  // Extract the 'shipName' string
                .findFirst();
        result.ifPresent(System.out::println);
        // Flatmap, if multiple ship lists
        return result.orElse(" ");
    }

    public String getShipNames() {
        if (ships == null || ships.isEmpty()) {
            return "";
        }

        return ships.stream()
                .map(ship -> ship.getName().shipName())
                .collect(Collectors.joining(", "));
    }
}