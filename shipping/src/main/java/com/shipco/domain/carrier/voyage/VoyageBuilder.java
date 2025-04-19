package com.shipco.domain.carrier.voyage;

import com.shipco.domain.carrier.customer.CustomerId;
import com.shipco.domain.carrier.price.Price;
import com.shipco.domain.carrier.route.Route;
import com.shipco.domain.carrier.shipment.Shipment;

import java.util.List;

public class VoyageBuilder {

    private Route route;
    private List<Shipment> shipments;
    private CustomerId customerId;
    private Price price;

    public VoyageBuilder route(final Route route) {
        this.route = route;
        return this;
    }

    public VoyageBuilder shipments(final List<Shipment> shipments) {
        this.shipments = shipments;
        return this;
    }

    public VoyageBuilder customerId(final CustomerId customerId) {
        this.customerId = customerId;
        return this;
    }

    public VoyageBuilder price(final Price price) {
        this.price = price;
        return this;
    }

    public Voyage build() {

        if (price == null) {
            throw new IllegalArgumentException("Price id must be provided");
        }

        if (customerId == null) {
            throw new IllegalArgumentException("Customer id must be provided");
        }

        if (shipments == null || (shipments.isEmpty())) {
            throw new IllegalArgumentException("Shipments must be provided");
        }

        if (route == null) {
            throw new IllegalArgumentException("Route must be provided");
        }

        return new Voyage(customerId, shipments, route, price);
    }

}
