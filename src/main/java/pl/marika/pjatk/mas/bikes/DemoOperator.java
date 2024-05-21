package pl.marika.pjatk.mas.bikes;

import java.util.Collection;

import org.springframework.stereotype.Component;

import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.service.BikeService;

@Component
public class DemoOperator {

    private final BikeService bikeService;

    public DemoOperator(BikeService bikeService) {
        this.bikeService = bikeService;
    }

    public void saveAllBikes(Collection<Bike> bikes) {
        bikeService.saveAll(bikes);
    }
}
