package models;

import java.math.BigDecimal;

public class Order {
    public final BigDecimal initialPrice;
    public final int numWorkers;
    public final boolean isPharmaceutical;


    public Order(BigDecimal initialPrice, int numWorkers, boolean isPharmaceutical) {
        this.initialPrice = initialPrice;
        this.numWorkers = numWorkers;
        this.isPharmaceutical = isPharmaceutical;
    }
}
