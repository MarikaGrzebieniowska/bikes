package pl.marika.pjatk.mas.bikes;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Mechanic extends Employee {

    private String licenceNr;

    private List<Bike.BikeType> specializations;

}
