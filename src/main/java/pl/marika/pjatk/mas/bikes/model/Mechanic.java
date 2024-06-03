package pl.marika.pjatk.mas.bikes.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;

@Entity
public class Mechanic extends Employee {

    private String licenceNr;

    private boolean knowsElectricBikes;

    @OneToMany(mappedBy = "mechanic")
    private List<Repair> repairs;

    protected Mechanic() {
    }

    public Mechanic(String firstName,
                    String lastName,
                    String email,
                    String phoneNumber,
                    LocalDate birthDate,
                    String pesel,
                    LocalDate employmentDate,
                    double salary,
                    String licenceNr,
                    boolean knowsElectricBikes) {
        super(firstName, lastName, email, phoneNumber, birthDate, pesel, employmentDate, salary);
        this.licenceNr = licenceNr;
        this.knowsElectricBikes = knowsElectricBikes;
    }

    public String getLicenceNr() {
        return licenceNr;
    }

    public void setLicenceNr(String licenceNr) {
        this.licenceNr = licenceNr;
    }

}
