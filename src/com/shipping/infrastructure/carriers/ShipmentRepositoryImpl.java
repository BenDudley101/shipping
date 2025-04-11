package com.shipping.infrastructure.carriers;

import com.shipping.domain.carriers.shipment.Shipment;
import com.shipping.domain.carriers.shipment.ShipmentRepository;

import java.util.List;
import java.util.Optional;

public class ShipmentRepositoryImpl implements ShipmentRepository {
    // Create, read, update, delete (CRUD)
    @Override
    public Optional<Shipment> findById(String cargoId) {
        return Optional.empty();
    }

    public Shipment save(Shipment shipment) {
        return shipment;
    }

    @Override
    public Shipment delete(Shipment ship) {
        return null;
    }

    @Override
    public List<Shipment> findAll() {
        return List.of();
    }

    @Override
    public List<Shipment> findByName(String name) {
        return List.of();
    }
}
