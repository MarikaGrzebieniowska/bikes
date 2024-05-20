package pl.marika.pjatk.mas.bikes;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.IDENTITY;

@Entity
public class Repair {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bike_id")
    private Bike bike;

    @ManyToOne
    @JoinColumn(name = "mechanic_id")
    private Mechanic mechanic;

    private LocalDate startDate;

    private LocalDate endDate;

    private String description;

    private double invoicedAmount = 0;

}
