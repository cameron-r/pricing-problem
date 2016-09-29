package logic;

import models.Order;

import java.math.BigDecimal;

public class MarkupCalculator {
    private static final BigDecimal BASE_MARKUP = new BigDecimal("0.05");
    private static final BigDecimal MARKUP_PER_WORKER = new BigDecimal("0.012");
    private static final BigDecimal PHARMACEUTICAL_MARKUP = new BigDecimal("0.075");

    public BigDecimal calculateMarkupFor(Order order) {
        BigDecimal workerMarkup = MARKUP_PER_WORKER.multiply(new BigDecimal(order.numWorkers));
        BigDecimal pharmaceuticalMarkup = order.isPharmaceutical? PHARMACEUTICAL_MARKUP : BigDecimal.ZERO;

        BigDecimal totalMarkup = BASE_MARKUP.add(workerMarkup).add(pharmaceuticalMarkup);
        return order.initialPrice.multiply(totalMarkup);
    }
}
