package com.shipping.infrastructure.carriers;

import com.shipping.domain.carriers.ship.Ship;
import com.shipping.domain.carriers.ship.ShipName;
import com.shipping.domain.carriers.ship.ShipRepository;

import java.util.List;
import java.util.Optional;

public class ShipRepositoryImpl implements ShipRepository {

    // Create, read, update, delete (CRUD)
    public Optional<Ship> findById(Long shipId) {
        return Optional.empty();
    }

    public Ship save(Ship ship) {
        return ship;
    }

    @Override
    public Ship delete(Ship ship) {
        return null;
    }

    @Override
    public List<Ship> findAll() {
        return List.of();
    }

    @Override
    public Optional<Ship> findByName(ShipName name) {
        return Optional.empty();
    }
}
