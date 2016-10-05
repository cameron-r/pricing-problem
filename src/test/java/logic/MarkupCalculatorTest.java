package logic;

import models.Order;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class MarkupCalculatorTest {

    private static final BigDecimal INITIAL_AMOUNT = new BigDecimal("100");
    private static final BigDecimal BASE_MARKUP = new BigDecimal("1.05");
    private MarkupCalculator markupCalculator;

    @Before
    public void setUp() throws Exception {
        markupCalculator = new MarkupCalculator();
    }

    @Test
    public void shouldCalculateCorrectMarkedUpAmountForNulogyExample1() {
        Order order = new Order(new BigDecimal("1299.99"), 3, "food");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(order);

        BigDecimal expectedAmount = new BigDecimal("1591.58");
        assertThat(markedUpAmount.compareTo(expectedAmount), is(0));
    }

    @Test
    public void shouldCalculateFivePercentBaseMarkupForNormalItem() {
        Order normalOrder = new Order(INITIAL_AMOUNT, 0, "boxes");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(normalOrder);

        BigDecimal expectedAmount = INITIAL_AMOUNT.multiply(BASE_MARKUP);
        assertThat(markedUpAmount.compareTo(expectedAmount), is(0));
        assertAdditionalMarkupOf("1", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddOnePointTwoPercentMarkupPerWorker() {
        Order orderWithOneWorker = new Order(INITIAL_AMOUNT, 1, "boxes");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithOneWorker);

        assertAdditionalMarkupOf("1.012", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddSevenPointFivePercentMarkupForPharmaceuticals() {
        Order orderWithPharmaceuticals = new Order(INITIAL_AMOUNT, 0, "drugs");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithPharmaceuticals);

        assertAdditionalMarkupOf("1.075", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddThirteenPercentMarkupForFood() {
        Order orderWithFood = new Order(INITIAL_AMOUNT, 0, "food");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithFood);

        assertAdditionalMarkupOf("1.13", INITIAL_AMOUNT, markedUpAmount);
    }

    @Test
    public void shouldAddTwoPercentMarkupForElectronics() {
        Order orderWithElectronics = new Order(INITIAL_AMOUNT, 0, "electronics");

        BigDecimal markedUpAmount = markupCalculator.calculateMarkedUpCostFor(orderWithElectronics);

        assertAdditionalMarkupOf("1.02", INITIAL_AMOUNT, markedUpAmount);
    }

    // since markedUpAmount = initialAmount * baseMarkup * additionalMarkup,
    //  then additionalMarkup = markedUpAmount / initialAmount / baseMarkup
    private void assertAdditionalMarkupOf(String expectedMarkupPercent, BigDecimal initialAmount, BigDecimal markedUpAmount) {
        BigDecimal actualMarkupPercent = markedUpAmount.divide(initialAmount, 3, RoundingMode.HALF_EVEN)
                                                       .divide(BASE_MARKUP, 3, RoundingMode.HALF_EVEN);

        assertTrue(String.format("Expected markup of %s but got markup of %s", expectedMarkupPercent, actualMarkupPercent),
                new BigDecimal(expectedMarkupPercent).compareTo(actualMarkupPercent) == 0);
    }
}