package logic;

import models.Order;

import java.math.BigDecimal;

public class MarkupCalculator {
    public BigDecimal calculateMarkupFor(Order order) {
        return new BigDecimal(1050);
    }
}
