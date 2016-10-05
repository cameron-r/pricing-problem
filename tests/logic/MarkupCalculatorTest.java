package logic;

import models.Order;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.assertTrue;

public class MarkupCalculatorTest {

    private static final BigDecimal INITIAL_AMOUNT = new BigDecimal("100");
    private MarkupCalculator markupCalculator;

    @Before
    public void setUp() throws Exception {
        markupCalculator = new MarkupCalculator();
    }

    @Test
    public void shouldCalculateFivePercentBaseMarkupForNormalItem() {
        Order normalOrder = new Order(INITIAL_AMOUNT, 0, false, false, false);

        BigDecimal markedUpAmount = markupCalculator.calculateMarkupFor(normalOrder);

        assertMarkupOf("0.05", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddOnePointTwoPercentMarkupPerWorker() {
        Order orderWithOneWorker = new Order(INITIAL_AMOUNT, 1, false, false, false);

        BigDecimal markedUpAmount = markupCalculator.calculateMarkupFor(orderWithOneWorker);

        assertMarkupOf("0.062", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddSevenPointFivePercentMarkupForPharmaceuticals() {
        Order orderWithPharmaceuticals = new Order(INITIAL_AMOUNT, 0, true, false, false);

        BigDecimal markedUpAmount = markupCalculator.calculateMarkupFor(orderWithPharmaceuticals);

        assertMarkupOf("0.125", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddThirteenPercentMarkupForFood() {
        Order orderWithFood = new Order(INITIAL_AMOUNT, 0, false, true, false);

        BigDecimal markedUpAmount = markupCalculator.calculateMarkupFor(orderWithFood);

        assertMarkupOf("0.18", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddTwoPercentMarkupForElectronics() {
        Order orderWithElectronics = new Order(INITIAL_AMOUNT, 0, false, false, true);

        BigDecimal markedUpAmount = markupCalculator.calculateMarkupFor(orderWithElectronics);

        assertMarkupOf("0.07", INITIAL_AMOUNT, markedUpAmount);
    }

    private void assertMarkupOf(String expectedMarkupPercent, BigDecimal initialAmount, BigDecimal markedUpAmount) {
        BigDecimal actualMarkupPercent = markedUpAmount.divide(initialAmount);

        assertTrue(String.format("Expected markup of %s but got markup of %s", expectedMarkupPercent, actualMarkupPercent),
                new BigDecimal(expectedMarkupPercent).compareTo(actualMarkupPercent) == 0);
    }
}