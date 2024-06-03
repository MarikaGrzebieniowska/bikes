package pl.marika.pjatk.mas.bikes.service;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.marika.pjatk.mas.bikes.exception.MaximumParticipantsReachedException;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.model.Employee;
import pl.marika.pjatk.mas.bikes.model.Guide;
import pl.marika.pjatk.mas.bikes.model.Trip;
import pl.marika.pjatk.mas.bikes.repository.TripRepository;

@Service
public class TripService {

    private final TripRepository tripRepository;

    private final ClientService clientService;

    private final EmployeeService employeeService;

    public TripService(TripRepository tripRepository,
                       ClientService clientService,
                       EmployeeService employeeService) {
        this.tripRepository = tripRepository;
        this.clientService = clientService;
        this.employeeService = employeeService;
    }

    @Transactional
    public void saveTrip(Trip trip) {
        tripRepository.save(trip);
    }

    @Transactional
    public Trip findTrip(String name) {
        return tripRepository.findByName(name);
    }

    @Transactional
    public void addClient(String clientEmail, String tripName) throws MaximumParticipantsReachedException {
        Trip trip = tripRepository.findByName(tripName);
        if (trip.maxClientsReached()) {
            throw new MaximumParticipantsReachedException(trip.getMaxClients());
        }
        Client client = clientService.findClient(clientEmail);
        trip.addParticipant(client);
    }

    @Transactional
    public void addGuide(String employeeEmail, String tripName) throws IllegalArgumentException {
        Employee employee = employeeService.findByEmail(employeeEmail);
        if (!(employee instanceof Guide)) {
            throw new IllegalArgumentException("Employee is not a Guide!");
        }
        Trip trip = tripRepository.findByName(tripName);
        trip.addParticipant(employee);
    }

}
