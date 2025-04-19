package com.shipco.domain.carrier.ship;

import java.math.BigDecimal;
import java.util.function.Function;

public class CapacityFunctions {

    public final static Function<BigDecimal, BigDecimal> increaseCapacity = capacity -> capacity.add(new BigDecimal( 10));

    public final static Function<BigDecimal, BigDecimal> multiplyCapacity = capacity -> capacity.multiply(new BigDecimal("1.5"));

    public final static Function<BigDecimal, BigDecimal> increaseThenMultiply = increaseCapacity.andThen(multiplyCapacity);

}
