package pl.marika.pjatk.mas.bikes.model;

import jakarta.persistence.Entity;

@Entity
public class Client extends Person {

    public static int MAX_DISCOUNT_PERCENT;

    private int discountPercent;

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

}
