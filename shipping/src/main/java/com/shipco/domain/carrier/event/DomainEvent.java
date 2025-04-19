package com.shipco.domain.carrier.event;

import java.time.Instant;

public interface DomainEvent {
    Instant occurredAt();
}
