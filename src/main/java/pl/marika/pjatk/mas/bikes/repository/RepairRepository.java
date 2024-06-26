package pl.marika.pjatk.mas.bikes.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Repair;

@Repository
public interface RepairRepository extends JpaRepository<Repair, Long> {

    Optional<Repair> findTopByBikeOrderByStartDateDesc(Bike bike);
}
