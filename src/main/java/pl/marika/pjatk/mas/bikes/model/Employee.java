package pl.marika.pjatk.mas.bikes.model;

import jakarta.persistence.Entity;

import java.time.LocalDate;

@Entity
public class Employee extends Person {

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
}
