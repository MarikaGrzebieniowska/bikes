package pl.marika.pjatk.mas.bikes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.marika.pjatk.mas.bikes.model.Bike;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Long> {
}
