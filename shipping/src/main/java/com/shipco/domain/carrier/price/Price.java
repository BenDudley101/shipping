package com.shipco.domain.carrier.price;

import org.jmolecules.ddd.annotation.ValueObject;
import java.math.BigDecimal;

@ValueObject
public record Price(BigDecimal amount, String currency) {
}