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
        Order normalOrder = new Order(INITIAL_AMOUNT, 0, "boxes");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(normalOrder);

        assertMarkupOf("1.05", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddOnePointTwoPercentMarkupPerWorker() {
        Order orderWithOneWorker = new Order(INITIAL_AMOUNT, 1, "boxes");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithOneWorker);

        assertMarkupOf("1.062", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddSevenPointFivePercentMarkupForPharmaceuticals() {
        Order orderWithPharmaceuticals = new Order(INITIAL_AMOUNT, 0, "drugs");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithPharmaceuticals);

        assertMarkupOf("1.125", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddThirteenPercentMarkupForFood() {
        Order orderWithFood = new Order(INITIAL_AMOUNT, 0, "food");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithFood);

        assertMarkupOf("1.18", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddTwoPercentMarkupForElectronics() {
        Order orderWithElectronics = new Order(INITIAL_AMOUNT, 0, "electronics");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithElectronics);

        assertMarkupOf("1.07", INITIAL_AMOUNT, markedUpAmount);
    }

    private void assertMarkupOf(String expectedMarkupPercent, BigDecimal initialAmount, BigDecimal markedUpAmount) {
        BigDecimal actualMarkupPercent = markedUpAmount.divide(initialAmount);

        assertTrue(String.format("Expected markup of %s but got markup of %s", expectedMarkupPercent, actualMarkupPercent),
                new BigDecimal(expectedMarkupPercent).compareTo(actualMarkupPercent) == 0);
    }
}