package pl.marika.pjatk.mas.bikes.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;

@Entity
public class Guide extends Employee {

    private boolean knowsFirstAid;

    protected Guide() {
    }

    public Guide(String firstName,
                 String lastName,
                 String email,
                 String phoneNumber,
                 LocalDate birthDate,
                 String pesel,
                 LocalDate employmentDate,
                 double salary,
                 boolean knowsFirstAid) {
        super(firstName, lastName, email, phoneNumber, birthDate, pesel, employmentDate, salary);
        this.knowsFirstAid = knowsFirstAid;
    }

    public boolean isKnowsFirstAid() {
        return knowsFirstAid;
    }

    public void setKnowsFirstAid(boolean knowsFirstAid) {
        this.knowsFirstAid = knowsFirstAid;
    }
}
