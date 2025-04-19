package com.shipco.infrastructure.carrier;

import com.shipco.domain.carrier.customer.CustomerId;
import com.shipco.domain.carrier.voyage.Voyage;
import com.shipco.domain.carrier.voyage.VoyageId;
import com.shipco.domain.carrier.voyage.VoyageRepository;
import java.util.List;
import java.util.Optional;

public class VoyageRepositoryImpl implements VoyageRepository {

    @Override
    public Optional<Voyage> findById(VoyageId id) {
        return Optional.empty();
    }

    @Override
    public List<Voyage> findByCustomerId(CustomerId customerId) {
        return List.of();
    }

    @Override
    public void save(Voyage voyage) {

    }

    @Override
    public void delete(VoyageId id) {

    }
}