package pl.marika.pjatk.mas.bikes.model;

import java.math.BigDecimal;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("GRAVEL_BIKE")
public class GravelBike extends Bike {

    double weigh;

    protected GravelBike() {
    }

    public GravelBike(String brand,
                      String model,
                      Size size,
                      boolean electric,
                      BigDecimal pricePerDay,
                      String serialNumber,
                      double weigh) {
        super(brand, model, size, electric, pricePerDay, serialNumber);
        this.weigh = weigh;
    }

    public double getWeigh() {
        return weigh;
    }

    public void setWeigh(double weigh) {
        this.weigh = weigh;
    }

}
