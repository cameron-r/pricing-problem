package models;

import java.math.BigDecimal;

public class Order {
    final private BigDecimal initialPrice;
    final private int numWorkers;


    public Order(BigDecimal initialPrice, int numWorkers) {
        this.initialPrice = initialPrice;
        this.numWorkers = numWorkers;
    }
}
