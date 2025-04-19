package com.shipco.domain.carrier.payment;

import com.shipco.domain.carrier.voyage.VoyageId;
import org.jmolecules.ddd.annotation.Entity;
import java.math.BigDecimal;
import java.util.UUID;

@Entity
public class Payment {
    private final PaymentId id;
    private final VoyageId voyageId;
    private final BigDecimal amount;
    private final PaymentStatus status;

    public Payment(VoyageId voyageId, BigDecimal amount) {
        this.id = new PaymentId(UUID.randomUUID());
        this.voyageId = voyageId;
        this.amount = amount;
        this.status = PaymentStatus.PENDING;
    }
}
