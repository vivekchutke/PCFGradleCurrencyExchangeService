package com.vivekchutke.microservices.gradlecurrencyexchangeservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.vivekchutke.microservices.gradlecurrencyexchangeservice.entity.ExchangeRate;
import com.vivekchutke.microservices.gradlecurrencyexchangeservice.exception.ExchangeServiceException;
import com.vivekchutke.microservices.gradlecurrencyexchangeservice.repository.ExchangeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
public class CurrencyExchangeController {
    @Autowired
    private Environment environment;

    @Autowired
    private ExchangeRepository exchangeRepository;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/currency-exchange/from/{from}/to/{to}")
    @HystrixCommand(fallbackMethod = "retrieveDefaultExchangeValue")
    public ExchangeRate retrieveExchangeValue(@PathVariable String from, @PathVariable String to) {
        ExchangeRate exchangeRate = exchangeRepository.findByFromAndTo(from, to);
        if(exchangeRate == null) {
            throw new ExchangeServiceException("Exchange Rate for the given combination of country codes not found");
        }
        exchangeRate.setPortNumber(Integer.parseInt(environment.getProperty("local.server.port")));

        logger.info("Active Profile are: "+environment.getActiveProfiles());
        logger.info("**Request: {}", exchangeRate);
        return exchangeRate;
    }

    /**
     * Acts like an default method whenever there is an exception fetching the exchange values
     *
     * @param from
     * @param to
     * @return
     */
    public ExchangeRate retrieveDefaultExchangeValue(String from, String to) {

        ExchangeRate exchangeRate =  new ExchangeRate(100, from, to,new BigDecimal(68.65),  Integer.parseInt(environment.getProperty("local.server.port")));
        return exchangeRate;

    }

}
