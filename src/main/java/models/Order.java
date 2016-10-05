package models;

import java.math.BigDecimal;

public class Order {
    public final BigDecimal initialPrice;
    public final int numWorkers;
    public final String materialType;

    public Order(BigDecimal initialPrice, int numWorkers, String materialType) {
        this.initialPrice = initialPrice;
        this.numWorkers = numWorkers;
        this.materialType = materialType;
    }
}
