package com.shipping.domain.carrier.ship;

import java.util.List;
import java.util.Optional;

public interface ShipRepository {

    // Create, read, update, delete (CRUD)

    public Optional<Ship> findById(Long shipId);

    public Ship save(Ship ship);

    public Ship delete(Ship ship);

    public List<Ship> findAll();

    public Optional<Ship> findByName(ShipName name);

}