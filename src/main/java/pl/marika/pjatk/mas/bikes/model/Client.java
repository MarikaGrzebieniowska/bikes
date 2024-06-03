package pl.marika.pjatk.mas.bikes.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Client extends Person {

    public static int MAX_DISCOUNT_PERCENT;

    private int discountPercent;

    @OneToMany(mappedBy = "client")
    private List<Booking> bookings;

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

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

}
