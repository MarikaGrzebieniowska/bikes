package pl.marika.pjatk.mas.bikes.model;

import static jakarta.persistence.DiscriminatorType.STRING;
import static jakarta.persistence.GenerationType.IDENTITY;
import static jakarta.persistence.InheritanceType.SINGLE_TABLE;
import static pl.marika.pjatk.mas.bikes.model.Bike.BikeStatus.AVAILABLE;
import static pl.marika.pjatk.mas.bikes.model.Bike.Size.Unit.CM;
import static pl.marika.pjatk.mas.bikes.model.Bike.Size.Unit.INCH;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.OneToMany;

@Entity
@Inheritance(strategy = SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = STRING)
public abstract class Bike {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String brand;

    private String model;

    @Embedded
    @Column(nullable = false)
    private Size size;

    private boolean electric;

    private BigDecimal pricePerDay;

    @Column(unique = true, nullable = false)
    private String serialNumber;

    @OneToMany(mappedBy = "bike")
    private List<Booking> bookings;

    @OneToMany(mappedBy = "bike")
    private List<Repair> repairs;

    @Enumerated(EnumType.STRING)
    private BikeStatus status = AVAILABLE;

    public enum BikeStatus {
        AVAILABLE, RENTED, IN_REPAIR
    }

    protected Bike() {
    }

    protected Bike(String brand,
                String model,
                Size size,
                boolean electric,
                BigDecimal pricePerDay,
                String serialNumber) {
        this.brand = brand;
        this.model = model;
        this.size = size;
        this.electric = electric;
        this.pricePerDay = pricePerDay;
        this.serialNumber = serialNumber;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public boolean isElectric() {
        return electric;
    }

    public void setElectric(boolean electric) {
        this.electric = electric;
    }

    public BigDecimal getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(BigDecimal pricePerDay) {
        this.pricePerDay = pricePerDay;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Repair> getRepairs() {
        return repairs;
    }

    public void setRepairs(List<Repair> repairs) {
        this.repairs = repairs;
    }

    public BikeStatus getStatus() {
        return status;
    }

    public void setStatus(BikeStatus status) {
        this.status = status;
    }

    @Embeddable
    public static class Size {

        @Column(name = "size")
        private int number;

        @Enumerated(EnumType.STRING)
        @Column(name = "size_unit")
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

        private Size(int number, Unit unit) {
            this.number = number;
            this.unit = unit;
        }

        public static Size of(int size) {
            return size >= 35 ? new Size(size, CM) : new Size(size, INCH);
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
