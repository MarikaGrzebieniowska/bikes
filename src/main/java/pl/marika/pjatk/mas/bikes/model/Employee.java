package pl.marika.pjatk.mas.bikes.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;

@Entity
public abstract class Employee extends Person {

    @Column(nullable = false)
    private String pesel;

    @Column(nullable = false)
    private LocalDate employmentDate;

    @Min(value = 5000, message = "Salary must be at least 5000")
    private double salary;

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
