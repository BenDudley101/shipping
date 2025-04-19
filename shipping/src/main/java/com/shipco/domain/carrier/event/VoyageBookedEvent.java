package com.shipco.domain.carrier.event;

import java.time.Instant;

public class VoyageBookedEvent implements DomainEvent{
    @Override
    public Instant occurredAt() {
        return null;
    }
}
