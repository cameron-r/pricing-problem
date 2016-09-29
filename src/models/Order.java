package models;

import java.math.BigDecimal;

public class Order {
    final public BigDecimal initialPrice;
    final public int numWorkers;


    public Order(BigDecimal initialPrice, int numWorkers) {
        this.initialPrice = initialPrice;
        this.numWorkers = numWorkers;
    }
}
