package pl.marika.pjatk.mas.bikes;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import pl.marika.pjatk.mas.bikes.model.Client;

@Component
public class Configuration {

    private final ClientProperties clientProperties;

    public Configuration(ClientProperties clientProperties) {
        this.clientProperties = clientProperties;
    }

    @PostConstruct
    private void init() {
        Client.MAX_DISCOUNT_PERCENT = Integer.parseInt(clientProperties.getMaxDiscountPercent());
    }
}
