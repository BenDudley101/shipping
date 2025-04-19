package com.shipco.service.carrier.voyage;

import com.shipco.domain.carrier.customer.CustomerId;
import com.shipco.domain.carrier.price.Price;
import com.shipco.domain.carrier.route.Route;
import com.shipco.domain.carrier.shipment.Shipment;
import com.shipco.domain.carrier.voyage.Voyage;
import com.shipco.domain.carrier.voyage.VoyageBuilder;
import com.shipco.domain.carrier.voyage.VoyageRepository;
import org.jmolecules.ddd.annotation.Service;
import java.math.BigDecimal;
import java.util.List;

@Service
public class BookVoyageService {

    private final VoyageRepository voyageRepository;

    public BookVoyageService(VoyageRepository voyageRepository) {
        this.voyageRepository = voyageRepository;
    }

    public VoyageDTO bookVoyage(CustomerId customerId, Route route, List<Shipment> shipments) {
        // calculate the price
        final Price price = new Price(new BigDecimal(1), "NOK");
        final VoyageBuilder voyageBuilder = new VoyageBuilder();
        final Voyage voyage = voyageBuilder.customerId(customerId).route(route).price(price).shipments(shipments).build();
        voyageRepository.save(voyage);
        return new VoyageDTO(voyage.getId());
    }
}