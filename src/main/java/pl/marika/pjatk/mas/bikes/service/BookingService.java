package pl.marika.pjatk.mas.bikes.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Booking;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.repository.BookingRepository;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    private BikeService bikeService;

    private ClientService clientService;

    public BookingService(BookingRepository bookingRepository,
                          BikeService bikeService,
                          ClientService clientService) {
        this.bookingRepository = bookingRepository;
        this.bikeService = bikeService;
        this.clientService = clientService;
    }

    @Transactional
    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Transactional
    public void save(String clientEmail, String bikeSerialNumber, LocalDate startDate, LocalDate endDate) {
        Bike bike = bikeService.findBike(bikeSerialNumber);
        List<Booking> bikeAlreadyBooked = findConflictingBookings(bike, startDate, endDate);
        if (!bikeAlreadyBooked.isEmpty()) {
            throw new IllegalArgumentException("Bike not available for given period");
        }

        Client client = clientService.findClient(clientEmail);
        bookingRepository.save(new Booking(client, bike, startDate, endDate));
    }

    public List<Booking> findConflictingBookings(Bike bike, LocalDate startDate, LocalDate endDate) {
        return bookingRepository.findByBikeAndStartDateLessThanEqualAndEndDateGreaterThanEqual(bike, endDate, startDate);
    }

}
