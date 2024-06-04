package pl.marika.pjatk.mas.bikes;

import static java.math.BigDecimal.valueOf;
import static java.time.LocalDate.now;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;

import lombok.extern.slf4j.Slf4j;
import pl.marika.pjatk.mas.bikes.model.Bike;
import pl.marika.pjatk.mas.bikes.model.Bike.Size;
import pl.marika.pjatk.mas.bikes.model.Client;
import pl.marika.pjatk.mas.bikes.model.Employee;
import pl.marika.pjatk.mas.bikes.model.GravelBike;
import pl.marika.pjatk.mas.bikes.model.Guide;
import pl.marika.pjatk.mas.bikes.model.Mechanic;
import pl.marika.pjatk.mas.bikes.model.MountainBike;
import pl.marika.pjatk.mas.bikes.model.RoadBike;
import pl.marika.pjatk.mas.bikes.model.Trip;

@Slf4j
@SpringBootApplication
@EnableConfigurationProperties(ClientProperties.class)
public class BikesApplication {

    // Ta sztuczna klasa woła serwisy, żeby nie wyciągać ich tu do maina.
    DemoOperator demoOperator;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(BikesApplication.class, args);

        DemoOperator operator = context.getBean(DemoOperator.class);

        // Dodajemy rowery różnego typu (dziedziczenie) - zapis do bazy ze strategią dziedziczenia SINGLE_TABLE
        List<Bike> bikes = Arrays.asList(
            new MountainBike("Santa Cruz", "Nomad 5 CC X01 AXS Reserve", Size.of(17), false, new BigDecimal("65.50"), "SCN89274J93", 100),
            new MountainBike("Giant", "Reign Advanced Pro 1", Size.of(22), true, new BigDecimal("55.50"), "GNT83758", 120),
            new RoadBike("Cannondale", "SuperSix", Size.of(51), false, new BigDecimal("50.00"), "CD00763437", 22),
            new GravelBike("Rondo", "Ruut X", Size.of(56), false, new BigDecimal("48.00"), "SN02KL9522", 14.5, 45)
        );
        operator.saveAllBikes(bikes);

        // Dodajemy klientów i pracowników
        // Zapis osób do bazy ze strategią dziedziczenia TABLE_PER_CLASS
        List<Client> clients = Arrays.asList(
        new Client("Janina", "Nowak", "janina.nowak@wp.pl", "+48 987654321", LocalDate.of(1990, 8, 20)),
        new Client("Hermes", "Kowalski", "hermes.kowalski@o2.pl", "+48 123456789", LocalDate.of(1985, 5, 15)),
        new Client("Tomasz", "Wiśniewski", "tomasz.wisniewski@interia.pl", "+48 555666777", LocalDate.of(1975, 2, 10)),
        new Client("Anna", "Wójcik", "anna.wojcik@onet.pl", "+48 888999000", LocalDate.of(2000, 12, 5))
        );
        operator.saveAllClients(clients);

        List<Employee> employees = Arrays.asList(
            new Guide("Leonard", "Kościółek", "l.kosciolek@biketours.pl", "+48 852115392", LocalDate.of(1982, 11, 5), "82110300456", now(), 5000.00, true),
            new Mechanic("Sobiesława", "Borczyk", "s.borczyk@biketours.pl", "+48 653470764", LocalDate.of(2004, 2, 13), "04321907961", now(), 5500.00, "GH33452", false),
            new Mechanic("Felicjan", "Durda", "f.durda@biketours.pl", "+48 329437686", LocalDate.of(1995, 8, 2), "95120214675", now(), 6000.00, "ZYG6-AZ", true)
        );
        operator.saveAllEmployees(employees);

        // Dodajemy wycieczkę do systemu
        String jezioroNidzkie = "Jezioro Nidzkie";
        operator.saveTrip(new Trip(jezioroNidzkie, 80, 3, LocalDateTime.of(2024, 7, 2, 9, 0)));

        //-------- DZIAŁANIE SERWISU -------//

        // Wycieczki mają uczestików [*:*]

        // Klienci zapisują się na wycieczkę
        operator.addClientToTrip("hermes.kowalski@o2.pl", jezioroNidzkie);
        operator.addClientToTrip("tomasz.wisniewski@interia.pl", jezioroNidzkie);
        operator.addClientToTrip("anna.wojcik@onet.pl", jezioroNidzkie);
        operator.addClientToTrip("janina.nowak@wp.pl", jezioroNidzkie); // przekracza limit - zaloguje ERROR

        // Dodajemy do wycieczki przewodnika
        operator.addGuideToTrip("l.kosciolek@biketours.pl", jezioroNidzkie);
        operator.addGuideToTrip("s.borczyk@biketours.pl", jezioroNidzkie); // To mechanik nie przewodnik - zaloguje ERROR

        // Klienci rezerwują rowery [1:*], email osoby i SN roweru są unique
        operator.saveBooking("janina.nowak@wp.pl", "SCN89274J93", LocalDate.of(2024, 6, 2), LocalDate.of(2024, 6, 6));
        operator.saveBooking("hermes.kowalski@o2.pl", "SCN89274J93", LocalDate.of(2024, 6, 1), LocalDate.of(2024, 6, 3)); // rower zajęty - zaloguje ERROR

        // Rowery bywaja w naprawie u mechaników [1:*]
        operator.sendBikeForRepair("s.borczyk@biketours.pl", "CD00763437");
        operator.sendBikeForRepair("l.kosciolek@biketours.pl", "SN02KL9522"); // Nie jest Mechanikiem - zaloguje ERROR
        operator.markBikeAsFixed("CD00763437", "Fixed fork, exchanged cranckset", 150);
        log.info("*** CLICK HERE! *** --> WPISY W BAZIE http://localhost:8080/h2-console/ JDBC URL: jdbc:h2:mem:bikes login 'sa', password: password");

    }

}
