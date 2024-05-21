package pl.marika.pjatk.mas.bikes.service;

import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import pl.marika.pjatk.mas.bikes.model.Booking;
import pl.marika.pjatk.mas.bikes.repository.BookingRepository;

@Service
public class BookingService {

    private BookingRepository bookingRepository;

    BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> findAll() {
        return bookingRepository.findAll();
    }

    public Booking save(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void saveAll(Collection<Booking> bookings) {
        bookingRepository.saveAll(bookings);
    }
}
