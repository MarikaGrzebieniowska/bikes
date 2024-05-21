package pl.marika.pjatk.mas.bikes;

import java.util.Collection;

import org.springframework.stereotype.Component;

import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Booking;
import pl.marika.pjatk.mas.bikes.model.Person;
import pl.marika.pjatk.mas.bikes.service.BikeService;
import pl.marika.pjatk.mas.bikes.service.BookingService;
import pl.marika.pjatk.mas.bikes.service.PersonService;

@Component
public class DemoOperator {

    private final BikeService bikeService;

    private final PersonService personService;

    private final BookingService bookingService;

    public DemoOperator(BikeService bikeService, PersonService personService, BookingService bookingService) {
        this.bikeService = bikeService;
        this.personService = personService;
        this.bookingService = bookingService;
    }

    public void saveAllBikes(Collection<Bike> bikes) {
        bikeService.saveAll(bikes);
    }

    public void savePerson(Person person) {
        personService.save(person);
    }

    public void saveAllPersons(Collection<Person> persons) {
        personService.saveAll(persons);
    }

    public void saveAllBookings(Collection<Booking> bookings) {
        bookingService.saveAll(bookings);
    }
}
