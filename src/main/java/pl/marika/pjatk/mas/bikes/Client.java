package pl.marika.pjatk.mas.bikes;

import jakarta.persistence.Entity;

@Entity
public class Client extends Person {

    private static final int MAX_DISCOUNT_PERCENT = 45;

    private int discountPercent = 0;

}
