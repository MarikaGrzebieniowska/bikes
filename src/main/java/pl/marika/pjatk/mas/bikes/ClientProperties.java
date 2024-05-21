package pl.marika.pjatk.mas.bikes;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "client")
public class ClientProperties {

    private String maxDiscountPercent;

    public String getMaxDiscountPercent() {
        return maxDiscountPercent;
    }

    public void setMaxDiscountPercent(String maxDiscountPercent) {
        this.maxDiscountPercent = maxDiscountPercent;
    }
}
