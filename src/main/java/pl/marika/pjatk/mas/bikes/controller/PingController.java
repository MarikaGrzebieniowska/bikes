package pl.marika.pjatk.mas.bikes.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PingController {

    /**
     * http://localhost:8080/ping
     */
    @GetMapping("/ping")
    public String ping() {
        return "Up and running!";
    }
}
