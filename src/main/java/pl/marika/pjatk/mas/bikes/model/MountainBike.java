package pl.marika.pjatk.mas.bikes.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("MOUNTAIN_BIKE")
public class MountainBike extends Bike {

    private int suspensionTravel;

    protected MountainBike() {
    }

    public MountainBike(String brand,
                        String model,
                        Size size,
                        boolean electric,
                        BigDecimal pricePerDay,
                        String serialNumber,
                        int suspensionTravel) {
        super(brand, model, size, electric, pricePerDay, serialNumber);
        this.suspensionTravel = suspensionTravel;
    }

    public int getSuspensionTravel() {
        return suspensionTravel;
    }

    public void setSuspensionTravel(int suspensionTravel) {
        this.suspensionTravel = suspensionTravel;
    }
}
