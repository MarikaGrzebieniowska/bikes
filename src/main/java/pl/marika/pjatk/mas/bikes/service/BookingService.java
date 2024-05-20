package pl.marika.pjatk.mas.bikes.service;

import org.springframework.stereotype.Service;
import pl.marika.pjatk.mas.bikes.model.Booking;
import pl.marika.pjatk.mas.bikes.repository.BookingRepository;

import java.util.List;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }
}
