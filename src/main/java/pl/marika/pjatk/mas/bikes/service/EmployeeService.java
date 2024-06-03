package pl.marika.pjatk.mas.bikes.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.marika.pjatk.mas.bikes.model.Employee;
import pl.marika.pjatk.mas.bikes.repository.EmployeeRepository;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Transactional
    public void saveAll(Collection<Employee> employees) {
        employeeRepository.saveAll(employees);
    }

    @Transactional
    public Employee findByEmail(String employeeEmail) {
        return employeeRepository.findByEmail(employeeEmail);
    }
}
