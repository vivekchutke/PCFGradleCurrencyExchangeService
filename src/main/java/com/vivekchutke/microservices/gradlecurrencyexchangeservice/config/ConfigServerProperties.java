package com.vivekchutke.microservices.gradlecurrencyexchangeservice.config;

import org.springframework.beans.factory.annotation.Value;
//import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
//@ConfigurationProperties("CFGradleCurrencyExchangeService")
@RefreshScope
public class ConfigServerProperties {

    @Value("${CFGradleCurrencyExchangeService.minimum}")
    private String minimum;

    @Value("${CFGradleCurrencyExchangeService.maximum}")
    private String maximum;

    public String getMinimum() {
        return minimum;
    }

    public void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getMaximum() {
        return maximum;
    }

    public void setMaximum(String maximum) {
        this.maximum = maximum;
    }
}
