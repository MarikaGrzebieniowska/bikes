package pl.marika.pjatk.mas.bikes;

import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;
import static pl.marika.pjatk.mas.bikes.model.Client.MAX_DISCOUNT_PERCENT;

import java.awt.print.Book;
import java.math.BigDecimal;
import java.time.LocalDate;
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
import pl.marika.pjatk.mas.bikes.model.Booking;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.model.Employee;
import pl.marika.pjatk.mas.bikes.model.GravelBike;
import pl.marika.pjatk.mas.bikes.model.Guide;
import pl.marika.pjatk.mas.bikes.model.Mechanic;
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
        Map<String, Employee> employees = new HashMap<>();
        employees.put("leo", new Guide("Leonard", "Kościółek", "l.kosciolek@biketours.pl", "+48 852115392", LocalDate.of(1982, 11, 5), "82110300456", now(), 5000.00, true));
        employees.put("sobieslawa", new Mechanic("Sobiesława", "Borczyk", "s.borczyk@biketours.pl", "+48 653470764", LocalDate.of(2004, 2, 13), "04321907961", now(), 4500.00, "GH33452", false));
        employees.put("felicjan", new Mechanic("Felicjan", "Durda", "f.durda@biketours.pl", "+48 329437686", LocalDate.of(1995, 8, 2), "95120214675", now(), 6000.00, "ZYG6-AZ", true));
        employees.values().forEach(operator::savePerson);


        Map<String, Client> clients = new HashMap<>();
        clients.put("janina", new Client("Janina", "Nowak", "janina.nowak@wp.pl", "+48 987654321", LocalDate.of(1990, 8, 20)));
        clients.put("hermek", new Client("Hermes", "Kowalski", "hermes.kowalski@o2.pl", "+48 123456789", LocalDate.of(1985, 5, 15)));
        clients.put("tomasz", new Client("Tomasz", "Wiśniewski", "tomasz.wisniewski@interia.pl", "+48 555666777", LocalDate.of(1975, 2, 10)));
        clients.put("anna", new Client("Anna", "Wójcik", "anna.wojcik@onet.pl", "+48 888999000", LocalDate.of(2000, 12, 5)));
        clients.values().forEach(operator::savePerson);

        // Klienci rezerwują rowery:
        Map<String, Booking> bookings = new HashMap<>();
        bookings.put("rezerwacjaHermka", new Booking(clients.get("hermek"), bikes.get("mountainBike"), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 5)));
        bookings.put("rezerwacjaHermkaInnyRowerTenSamTermin", new Booking(clients.get("hermek"), bikes.get("roadBike"), LocalDate.of(2023, 6, 1), LocalDate.of(2023, 6, 5)));
        bookings.put("rezerwacjaHermkaInnyRowerInnyTermin", new Booking(clients.get("hermek"), bikes.get("roadBike"), LocalDate.of(2023, 6, 14), LocalDate.of(2023, 6, 18)));
        bookings.put("rezerwacjaJaniny", new Booking(clients.get("janina"), bikes.get("electricMountainBike"), LocalDate.of(2023, 6, 2), LocalDate.of(2023, 6, 6)));
        bookings.put("rezerwacjaJaninyInnyRowerInnyTermin", new Booking(clients.get("janina"), bikes.get("mountainBike"), LocalDate.of(2023, 6, 19), LocalDate.of(2023, 6, 23)));
        bookings.put("rezerwacjaTomka", new Booking(clients.get("tomasz"), bikes.get("roadBike"), LocalDate.of(2023, 6, 3), LocalDate.of(2023, 6, 7)));
        bookings.put("rezerwacjaTomkaInnyRowerInnyTermin", new Booking(clients.get("tomasz"), bikes.get("mountainBike"), LocalDate.of(2023, 6, 24), LocalDate.of(2023, 6, 28)));
        bookings.put("rezerwacjaAnny", new Booking(clients.get("anna"), bikes.get("gravelBike"), LocalDate.of(2023, 6, 4), LocalDate.of(2023, 6, 8)));

        // Example usage of the map
        bookings.forEach((key, booking) -> System.out.println(key + ": " + booking));


        // Napisać, że static int jest w propertisach

        log.info(String.valueOf(MAX_DISCOUNT_PERCENT));
    }

}
