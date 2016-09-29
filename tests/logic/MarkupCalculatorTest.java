package logic;

import models.Order;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class MarkupCalculatorTest {

    private static final BigDecimal ORIGINAL_COST = new BigDecimal("100");

    @Test
    public void shouldCalculateFivePercentBaseMarkupForNormalItem() {
        Order normalOrder = new Order(ORIGINAL_COST, 0);

        MarkupCalculator markupCalculator = new MarkupCalculator();
        BigDecimal markUpAmount = markupCalculator.calculateMarkupFor(normalOrder);

        assertTrue(markUpAmount.compareTo(new BigDecimal("5")) == 0);
    }

    @Test
    public void shouldAddOnePointTwoPercentMarkupPerWorker() {
        Order orderWithOneWorker = new Order(ORIGINAL_COST, 1);

        MarkupCalculator markupCalculator = new MarkupCalculator();
        BigDecimal markedUpPrice = markupCalculator.calculateMarkupFor(orderWithOneWorker);

        assertTrue(markedUpPrice.compareTo(new BigDecimal("6.2")) == 0);
    }
}