package pl.marika.pjatk.mas.bikes.service;

import java.util.Collection;

import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.repository.BikeRepository;

@Service
public class BikeService {

    private final BikeRepository bikeRepository;

    public BikeService(BikeRepository bikeRepository) {
        this.bikeRepository = bikeRepository;
    }

    @Transactional
    public void saveAll(Collection<Bike> bikes) {
        bikeRepository.saveAll(bikes);
    }

    @Transactional
    public Bike findBike(String serialNumber) {
        return bikeRepository.findBySerialNumber(serialNumber);
    }
}
