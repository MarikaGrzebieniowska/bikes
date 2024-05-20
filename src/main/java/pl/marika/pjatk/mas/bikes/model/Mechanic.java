package pl.marika.pjatk.mas.bikes.model;

import jakarta.persistence.Entity;

import java.util.List;

@Entity
public class Mechanic extends Employee {

    private String licenceNr;

    private List<Bike.BikeType> specializations;

    public String getLicenceNr() {
        return licenceNr;
    }

    public void setLicenceNr(String licenceNr) {
        this.licenceNr = licenceNr;
    }

    public List<Bike.BikeType> getSpecializations() {
        return specializations;
    }

    public void setSpecializations(List<Bike.BikeType> specializations) {
        this.specializations = specializations;
    }
}
