package pl.marika.pjatk.mas.bikes.model;

import jakarta.persistence.Entity;

@Entity
public class Guide extends Employee {

    private boolean knowsFirstAid;

    public boolean isKnowsFirstAid() {
        return knowsFirstAid;
    }

    public void setKnowsFirstAid(boolean knowsFirstAid) {
        this.knowsFirstAid = knowsFirstAid;
    }
}
