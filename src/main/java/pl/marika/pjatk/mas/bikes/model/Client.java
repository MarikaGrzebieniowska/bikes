package pl.marika.pjatk.mas.bikes.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Client extends Person {

    public static int MAX_DISCOUNT_PERCENT;

    private int discountPercent;

    protected Client() {
    }

    public Client(String firstName,
                  String lastName,
                  String email,
                  String phoneNumber,
                  LocalDate birthDate) {
        super(firstName, lastName, email, phoneNumber, birthDate);
    }

    public int getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(int discountPercent) {
        this.discountPercent = discountPercent;
    }

}
