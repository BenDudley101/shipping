package com.shipco.presentation.carrier;

import com.shipco.domain.carrier.customer.CustomerId;
import com.shipco.domain.carrier.route.Route;
import com.shipco.service.carrier.voyage.BookVoyageService;
import com.shipco.service.carrier.voyage.VoyageDTO;
import java.util.Collections;
import java.util.UUID;

public class VoyageController {

    private final BookVoyageService bookVoyageService;

    public VoyageController(BookVoyageService bookVoyageService) {
        this.bookVoyageService = bookVoyageService;
    }

    //@PostMapping("/book")
    //public ResponseEntity<BookVoyageResponse> bookVoyage(@RequestBody BookVoyageRequest request) {
    public void bookVoyage() {
        //CustomerId customerId = new CustomerId(UUID.fromString(request.customerId()));
        final CustomerId customerId = new CustomerId(UUID.randomUUID());
        final Route route = new Route("startPort", "endPort", Collections.emptyList());
        final VoyageDTO voyageDTO = bookVoyageService.bookVoyage(customerId, route, Collections.emptyList());
        //return ResponseEntity.ok(new BookVoyageResponse(voyageId.value().toString()));
    }
}
