package pl.marika.pjatk.mas.bikes.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("ROAD_BIKE")
public class RoadBike extends Bike {

    private int gearCount;

    protected RoadBike() {
    }

    public RoadBike(String brand,
                    String model,
                    Size size,
                    boolean electric,
                    BigDecimal pricePerDay,
                    String serialNumber,
                    int gearCount) {
        super(brand, model, size, electric, pricePerDay, serialNumber);
        this.gearCount = gearCount;
    }

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }
}
