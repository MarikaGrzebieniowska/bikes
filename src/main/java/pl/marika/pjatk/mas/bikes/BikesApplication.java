package pl.marika.pjatk.mas.bikes;

import static java.math.BigDecimal.valueOf;
import static pl.marika.pjatk.mas.bikes.model.Client.MAX_DISCOUNT_PERCENT;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Bike.Size;
import pl.marika.pjatk.mas.bikes.model.Bike.Size.Unit;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.model.GravelBike;
import pl.marika.pjatk.mas.bikes.model.MountainBike;
import pl.marika.pjatk.mas.bikes.model.Person;
import pl.marika.pjatk.mas.bikes.model.RoadBike;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ClientProperties.class)
public class BikesApplication {

    DemoOperator demoOperator;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BikesApplication.class, args);
        log.info("DATABASE AT http://localhost:8080/h2-console/ JDBC URL: jdbc:h2:mem:biks login 'sa', password: password");

        // Ta sztuczna klasa woła serwisy, żeby nie wyciągać ich tu do maina.
        DemoOperator operator = context.getBean(DemoOperator.class);

        // Dodajemy rowery różnego typu - zapis do bazy ze strategią dziedziczenia SINGLE_TABLE
        Map<String, Bike> bikes = new HashMap<>();
        bikes.put("mountainBike", new MountainBike("Santa Cruz", "Nomad 5 CC X01 AXS Reserve", Size.of(17), false, new BigDecimal("65.50"), "SCN89274J93", 100));
        bikes.put("electricMountainBike", new MountainBike("Giant", "Reign Advanced Pro 1", Size.of(22), true, new BigDecimal("55.50"), "GNT83758", 120));
        bikes.put("roadBike", new RoadBike("Cannondale", "SuperSix", Size.of(51), false, new BigDecimal("50.00"), "CD00763437", 22));
        bikes.put("gravelBike", new GravelBike("Rondo", "Ruut X", Size.of(56), false, new BigDecimal("48.00"), "SN02KL9522", 14.5, 45));
        operator.saveAllBikes(bikes.values());

        // Dodajemy pracowników - zapis osób do bazy (Employee, Client) ze strategią dziedziczenia TABLE_PER_CLASS
        // A dla pracowników konkretnie (Mechanic, Guide) strategia JOINED

        List<Person> employees = new ArrayList<>();

        // Napisać, że static int jest w propertisach

        log.info(String.valueOf(MAX_DISCOUNT_PERCENT));
    }

}
