package pl.marika.pjatk.mas.bikes.model;

import jakarta.persistence.Entity;

@Entity
public class MountainBike extends Bike {

    private int suspensionTravel;

    public int getSuspensionTravel() {
        return suspensionTravel;
    }

    public void setSuspensionTravel(int suspensionTravel) {
        this.suspensionTravel = suspensionTravel;
    }
}
