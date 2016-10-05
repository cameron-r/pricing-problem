package logic;

import models.Material;
import models.Order;

import java.math.BigDecimal;

public class MarkupCalculator {
    private static final BigDecimal BASE_MARKUP = new BigDecimal("0.05");
    private static final BigDecimal MARKUP_PER_WORKER = new BigDecimal("0.012");
    private static final BigDecimal PHARMACEUTICAL_MARKUP = new BigDecimal("0.075");
    private static final BigDecimal FOOD_MARKUP = new BigDecimal("0.13");
    private static final BigDecimal ELECTRONIC_MARKUP = new BigDecimal("0.02");

    public BigDecimal calculateMarkedUpCostFor(Order order) {
        BigDecimal workerMarkup = MARKUP_PER_WORKER.multiply(new BigDecimal(order.numWorkers));
        BigDecimal materialMarkup = calculateMaterialMarkup(order.materialType);

        BigDecimal totalMarkup = BASE_MARKUP.add(workerMarkup).add(materialMarkup);
        return order.initialPrice.add(order.initialPrice.multiply(totalMarkup));
    }

    private BigDecimal calculateMaterialMarkup(String materialType) {
        if (Material.PHARMACEUTICALS.contains(materialType)) {
            return PHARMACEUTICAL_MARKUP;
        }
        else if (Material.FOOD.contains(materialType)) {
            return FOOD_MARKUP;
        }
        else if (Material.ELECTRONICS.contains(materialType)) {
            return ELECTRONIC_MARKUP;
        }

        return BigDecimal.ZERO;
    }
}
