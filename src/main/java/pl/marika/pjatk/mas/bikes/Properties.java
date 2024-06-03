package pl.marika.pjatk.mas.bikes;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "client")
public class Properties {

    private String maxDiscountPercent;

    // Getter and Setter
    public String getValue() {
        return maxDiscountPercent;
    }

    public void setValue(String maxDiscountPercent) {
        this.maxDiscountPercent = maxDiscountPercent;
    }

}
