package com.shipco.domain.carrier.shipment;

import java.util.List;
import java.util.function.Predicate;

public class ValidateShipmentRules {
    private final List<ShipmentRule> rules;

    public ValidateShipmentRules() {
        final Predicate<Shipment> petroleum = s -> s.getShipmentType().equals(ShipmentType.CLEAN_PETROLEUM);
        final Predicate<Shipment> causticSoda = s -> s.getShipmentType().equals(ShipmentType.CAUSTIC_SODA);

        this.rules = List.of(
                new ShipmentRule("Petroleum Carrier", petroleum),
                new ShipmentRule("Caustic Soda Carrier", causticSoda)
        );
    }

    public boolean isValidShipment(Shipment shipment) throws ShipmentAssignmentException {
        for (ShipmentRule rule : rules) {
            if (rule.test(shipment)) {
                return true;
            } else {
                throw new ShipmentAssignmentException("Rule failed: " + rule.getName());
            }
        }
        return false;
    }
}
