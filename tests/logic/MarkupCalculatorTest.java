package logic;

import models.Order;
import org.junit.Test;

import java.math.BigDecimal;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MarkupCalculatorTest {

    @Test
    public void shouldCalculateMarkupForNormalItem() {
        Order normalOrder = new Order(new BigDecimal(1000), 0);

        MarkupCalculator markupCalculator = new MarkupCalculator();
        BigDecimal markedUpPrice = markupCalculator.calculateMarkupFor(normalOrder);

        assertThat(markedUpPrice, is(new BigDecimal(1050)));
    }
}