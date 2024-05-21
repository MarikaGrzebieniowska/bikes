package pl.marika.pjatk.mas.bikes;

import java.math.BigDecimal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Bike.Size;
import pl.marika.pjatk.mas.bikes.model.Bike.Size.Unit;
import pl.marika.pjatk.mas.bikes.model.RoadBike;

@Slf4j
@SpringBootApplication
public class BikesApplication {

    public static void main(String[] args) {
        SpringApplication.run(BikesApplication.class, args);
        log.info("DATABASE AT http://localhost:8080/h2-console/ JDBC URL: jdbc:h2:mem:biks login 'sa', password: password");

        /* Napisać, że mamy 3 strategie jak diedziczenie jest przekłądane na ORM:
        Bike - SINGLE_TABLE
        Person (Employee, Client) - TABLE_PER_CLASS
        Employee (Mechanic, Guide) - JOINED
        */

        Bike road = new RoadBike("Cannondale", "SuperSix", new Size(51, Unit.CM), false, new BigDecimal("50.00"), "CD0032424", 22);
        log.info("bike: " + road + "goto ");
    }

}
