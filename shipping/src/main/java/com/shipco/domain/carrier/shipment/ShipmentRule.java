package com.shipco.domain.carrier.shipment;

import java.util.function.Predicate;

public class ShipmentRule {
    private final String name;
    private final Predicate<Shipment> rule;

    public ShipmentRule(String name, Predicate<Shipment> rule) {
        this.name = name;
        this.rule = rule;
    }

    public boolean test(Shipment shipment) {
        return rule.test(shipment);
    }

    public String getName() {
        return name;
    }
}