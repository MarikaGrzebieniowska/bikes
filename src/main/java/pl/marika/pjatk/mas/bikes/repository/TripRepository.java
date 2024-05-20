package pl.marika.pjatk.mas.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.marika.pjatk.mas.bikes.model.Trip;

public interface TripRepository extends JpaRepository<Trip, Long> {

}
