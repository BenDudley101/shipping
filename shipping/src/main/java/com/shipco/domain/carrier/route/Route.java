package com.shipco.domain.carrier.route;

import org.jmolecules.ddd.annotation.Entity;
import java.util.List;
import java.util.UUID;

@Entity
public class Route {
    private final RouteId id;
    private final List<String> stops;
    private final String startPort;
    private final String endPort;

    public Route(String startPort, String endPort, List<String> stops) {
        this.id = new RouteId(UUID.randomUUID());
        this.startPort = startPort;
        this.endPort = endPort;
        this.stops = List.copyOf(stops);
    }
}
