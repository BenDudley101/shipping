package com.shipco.domain.carrier.shipment;

import com.shipco.domain.carrier.voyage.VoyageId;
import org.jmolecules.ddd.annotation.Repository;
import java.util.Optional;
import java.util.List;


@Repository
// Repositories should return domain objects
public interface ShipmentRepository {
    Optional<Shipment> findById(ShipmentId id);

    List<Shipment> findByVoyageId(VoyageId voyageId);

    void save(Shipment shipment);
}
