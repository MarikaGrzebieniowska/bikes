package pl.marika.pjatk.mas.bikes.model;

import jakarta.persistence.Entity;

@Entity
public class RoadBike extends Bike {

    private int gearCount;

    public int getGearCount() {
        return gearCount;
    }

    public void setGearCount(int gearCount) {
        this.gearCount = gearCount;
    }
}
