package com.shipping.domain.carriers.shipment;

import java.util.List;
import java.util.Optional;

public interface ShipmentRepository {

    // Create, read, update, delete (CRUD)
    public Optional<Shipment> findById(String shipmentId);

    public Shipment save(Shipment shipment);

    public Shipment delete(Shipment shipment);

    public List<Shipment> findAll();

    public List<Shipment> findByName(String name);
}