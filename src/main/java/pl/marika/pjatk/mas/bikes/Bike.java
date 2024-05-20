package pl.marika.pjatk.mas.bikes;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;

import java.math.BigDecimal;

import static jakarta.persistence.EnumType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.InheritanceType.JOINED;

@Entity
@Inheritance(strategy = JOINED)
public class Bike {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    private String brand;

    private String model;

    @Embedded
    private Size size;

    private boolean electric;

    private BigDecimal pricePerDay;

    private String SN;

    @Enumerated(STRING)
    private BikeStatus status = BikeStatus.AVAILABLE;

    public enum BikeType {
        MTB,
        ROAD,
        GRAVEL,
    }

    public enum BikeStatus {
        AVAILABLE, RENTED, IN_REPAIR
    }

    @Embeddable
    public static class Size {

        private int number;

        @Enumerated(STRING)
        private Unit unit;

        public enum Unit {

            CM("cm"),
            INCH("″");

            private final String desc;

            Unit(String desc) {
                this.desc = desc;
            }

            @Override
            public String toString() {
                return desc;
            }
        }

        public Size() {
        }

        public Size(int number, Unit unit) {
            this.number = number;
            this.unit = unit;
        }

        public int getNumber() {
            return number;
        }

        public Unit getUnit() {
            return unit;
        }

        @Override
        public String toString() {
            return number + " " + unit;
        }
    }

}
