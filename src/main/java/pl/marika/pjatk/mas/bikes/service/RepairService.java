package pl.marika.pjatk.mas.bikes.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Employee;
import pl.marika.pjatk.mas.bikes.model.Mechanic;
import pl.marika.pjatk.mas.bikes.model.Repair;
import pl.marika.pjatk.mas.bikes.repository.RepairRepository;

@Service
public class RepairService {

    private final RepairRepository repairRepository;

    private final EmployeeService employeeService;

    private final BikeService bikeService;

    public RepairService(RepairRepository repairRepository, EmployeeService employeeService, BikeService bikeService) {
        this.repairRepository = repairRepository;
        this.employeeService = employeeService;
        this.bikeService = bikeService;
    }

    @Transactional
    public void addBikeRepairEntry(String mechanicEmail, String bikeSerialNumber) {
        Employee employee = employeeService.findByEmail(mechanicEmail);
        if (!(employee instanceof Mechanic)) {
            throw new IllegalArgumentException("Employee is not a Mechanic, can't create Repair entry.");
        }
        Bike bike = bikeService.findBike(bikeSerialNumber);
        Repair repair = new Repair(bike, (Mechanic) employee, LocalDate.now());
        repairRepository.save(repair);
    }
}
