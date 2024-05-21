package pl.marika.pjatk.mas.bikes.model;

import static jakarta.persistence.InheritanceType.JOINED;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Inheritance;

@Entity
@Inheritance(strategy = JOINED)
public abstract class Employee extends Person {

    private String pesel;

    private LocalDate employmentDate;

    private double salary;

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }

    public LocalDate getEmploymentDate() {
        return employmentDate;
    }

    public void setEmploymentDate(LocalDate employmentDate) {
        this.employmentDate = employmentDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    protected Employee() {
    }

    protected Employee(String firstName,
                       String lastName,
                       String email,
                       String phoneNumber,
                       LocalDate birthDate,
                       String pesel,
                       LocalDate employmentDate,
                       double salary) {
        super(firstName, lastName, email, phoneNumber, birthDate);
        this.pesel = pesel;
        this.employmentDate = employmentDate;
        this.salary = salary;
    }
}
