package com.vivekchutke.microservices.gradlecurrencyexchangeservice.exception;

import com.vivekchutke.microservices.gradlecurrencyexchangeservice.entity.ExchangeRate;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ExchangeServiceException extends RuntimeException {
    public ExchangeServiceException(String message) {
        super("Exchange Rate Value not found for the given combination of country codes:"+message);
    }
}
