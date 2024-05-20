package pl.marika.pjatk.mas.bikes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    private Client client;

    @ManyToOne
    private Bike bike;

    private LocalDate startDate;

    private LocalDate endDate;

}
