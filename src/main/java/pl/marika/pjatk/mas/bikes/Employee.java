package pl.marika.pjatk.mas.bikes;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Employee extends Person {

    private String pesel;

    private LocalDate employmentDate;

    private double salary;
}
