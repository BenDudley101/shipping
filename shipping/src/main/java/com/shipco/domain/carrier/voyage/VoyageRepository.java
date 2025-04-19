package com.shipco.domain.carrier.voyage;

import com.shipco.domain.carrier.customer.CustomerId;
import java.util.List;
import java.util.Optional;

public interface VoyageRepository {
    Optional<Voyage> findById(VoyageId id);

    List<Voyage> findByCustomerId(CustomerId customerId);

    void save(Voyage voyage);

    void delete(VoyageId id);
}