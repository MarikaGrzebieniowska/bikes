package pl.marika.pjatk.mas.bikes.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {

    List<Booking> findByBikeAndStartDateLessThanEqualAndEndDateGreaterThanEqual(Bike bike, LocalDate endDate, LocalDate startDate);

}
