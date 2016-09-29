package logic;

import models.Order;

import java.math.BigDecimal;

public class MarkupCalculator {
    private static final BigDecimal BASE_MARKUP = new BigDecimal("0.05");
    private static final BigDecimal MARKUP_PER_WORKER = new BigDecimal("0.012");

    public BigDecimal calculateMarkupFor(Order order) {
        BigDecimal workerMarkup = MARKUP_PER_WORKER.multiply(new BigDecimal(order.numWorkers));

        BigDecimal totalMarkup = BASE_MARKUP.add(workerMarkup);
        return order.initialPrice.multiply(totalMarkup);
    }
}
