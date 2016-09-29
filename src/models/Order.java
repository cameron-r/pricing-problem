package models;

import java.math.BigDecimal;

public class Order {
    public final BigDecimal initialPrice;
    public final int numWorkers;
    public final boolean isPharmaceutical;
    public final boolean isFood;


    public Order(BigDecimal initialPrice, int numWorkers, boolean isPharmaceutical, boolean isFood) {
        this.initialPrice = initialPrice;
        this.numWorkers = numWorkers;
        this.isPharmaceutical = isPharmaceutical;
        this.isFood = isFood;
    }
}
