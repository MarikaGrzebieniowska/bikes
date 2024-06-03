package pl.marika.pjatk.mas.bikes;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import pl.marika.pjatk.mas.bikes.exception.MaximumParticipantsReachedException;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Booking;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.model.Employee;
import pl.marika.pjatk.mas.bikes.model.Trip;
import pl.marika.pjatk.mas.bikes.service.BikeService;
import pl.marika.pjatk.mas.bikes.service.BookingService;
import pl.marika.pjatk.mas.bikes.service.ClientService;
import pl.marika.pjatk.mas.bikes.service.EmployeeService;
import pl.marika.pjatk.mas.bikes.service.RepairService;
import pl.marika.pjatk.mas.bikes.service.TripService;

@Slf4j
@Component
public class DemoOperator {

    private final BikeService bikeService;

    private final BookingService bookingService;

    private final ClientService clientService;

    private final EmployeeService employeeService;

    private final TripService tripService;

    private final RepairService repairService;

    public DemoOperator(BikeService bikeService,
                        BookingService bookingService,
                        ClientService clientService,
                        EmployeeService employeeService,
                        TripService tripService,
                        RepairService repairService) {
        this.bikeService = bikeService;
        this.bookingService = bookingService;
        this.clientService = clientService;
        this.employeeService = employeeService;
        this.tripService = tripService;
        this.repairService = repairService;
    }

    public void saveAllBikes(Collection<Bike> bikes) {
        bikeService.saveAll(bikes);
    }

    public void saveAllClients(Collection<Client> clients) {
        clientService.saveAll(clients);
    }

    public void saveAllEmployees(Collection<Employee> employees) {
        employeeService.saveAll(employees);
    }

    public void saveBooking(String clientEmail, String bikeSerialNumber, LocalDate startDate, LocalDate endDate) {
        try {
            bookingService.save(clientEmail, bikeSerialNumber, startDate, endDate);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
    }

//    public void saveAllBookings(Collection<Booking> bookings) {
//        bookingService.saveAll(bookings);
//    }

    public List<Booking> findAllBookings() {
        return bookingService.findAll();
    }

    public List<Booking> findConflictingBookings(Bike bike, LocalDate startDate, LocalDate endDate) {
        return bookingService.findConflictingBookings(bike, endDate, startDate);
    }

    public Client findClient(String email) {
        return clientService.findClient(email);
    }

    public Bike findBike(String serialNumber) {
        return bikeService.findBike(serialNumber);
    }

    public void saveTrip(Trip trip) {
        tripService.saveTrip(trip);
    }

    public Trip findTrip(String name) {
        return tripService.findTrip(name);
    }

    public void addClientToTrip(String clientEmail, String tripName) {
        try {
            tripService.addClient(clientEmail, tripName);
        } catch (MaximumParticipantsReachedException e) {
            log.error(e.getMessage());
        }
    }

    public void addGuideToTrip(String employeeEmail, String tripName) {
        try {
            tripService.addGuide(employeeEmail, tripName);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
    }

    public void sendBikeForRepair(String mechanicEmail, String bikeSerialNumber) {
        try {
            repairService.addBikeRepairEntry(mechanicEmail, bikeSerialNumber);
        } catch (IllegalArgumentException e) {
            log.error(e.getMessage());
        }
    }
}
