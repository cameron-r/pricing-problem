package models;

import java.math.BigDecimal;

public class Order {
    public final BigDecimal initialPrice;
    public final int numWorkers;
    public final boolean isPharmaceutical;
    public final boolean isFood;
    public final boolean isElectronic;


    public Order(BigDecimal initialPrice, int numWorkers, boolean isPharmaceutical, boolean isFood,
                 boolean isElectronic) {
        this.initialPrice = initialPrice;
        this.numWorkers = numWorkers;
        this.isPharmaceutical = isPharmaceutical;
        this.isFood = isFood;
        this.isElectronic = isElectronic;
    }
}
