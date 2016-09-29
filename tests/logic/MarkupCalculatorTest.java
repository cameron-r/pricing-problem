package logic;

import models.Order;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertTrue;

public class MarkupCalculatorTest {

    private static final BigDecimal ONE_HUNDRED = new BigDecimal("100");
    private MarkupCalculator markupCalculator;

    @Before
    public void setUp() throws Exception {
        markupCalculator = new MarkupCalculator();
    }

    @Test
    public void shouldCalculateFivePercentBaseMarkupForNormalItem() {
        Order normalOrder = new Order(ONE_HUNDRED, 0, false);

        BigDecimal markUpAmount = markupCalculator.calculateMarkupFor(normalOrder);

        assertTrue(markUpAmount.compareTo(new BigDecimal("5")) == 0);
    }

    @Test
    public void shouldAddOnePointTwoPercentMarkupPerWorker() {
        Order orderWithOneWorker = new Order(ONE_HUNDRED, 1, false);

        BigDecimal markUpAmount = markupCalculator.calculateMarkupFor(orderWithOneWorker);

        assertTrue(markUpAmount.compareTo(new BigDecimal("6.2")) == 0);
    }

    @Test
    public void shouldAddSevenPointFivePercentMarkupForPharmaceuticals() {
        Order orderWithPharmaceuticals = new Order(ONE_HUNDRED, 0, true);

        BigDecimal markUpAmount = markupCalculator.calculateMarkupFor(orderWithPharmaceuticals);

        assertTrue(markUpAmount.compareTo(new BigDecimal("12.5")) == 0);
    }
}