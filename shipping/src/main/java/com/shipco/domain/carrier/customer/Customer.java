package com.shipco.domain.carrier.customer;

import org.jmolecules.ddd.annotation.AggregateRoot;

@AggregateRoot
public class Customer {
    private final CustomerId id;
    private final String name;
    private final String email;

    public Customer(final CustomerId id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }
}
