package com.vivekchutke.microservices.gradlecurrencyexchangeservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<Object> handleAllException(Exception ex, WebRequest request) throws Exception {

        CustomizedExceptionResponse customizedExceptionResponse = new CustomizedExceptionResponse(new Date(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(customizedExceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(ExchangeServiceException.class)
    public final ResponseEntity<Object> handleExchangeServiceException(ExchangeServiceException ex, WebRequest request) throws Exception {

        CustomizedExceptionResponse customizedExceptionResponse = new CustomizedExceptionResponse(new Date(),
                ex.getMessage(), request.getDescription(false));

        return new ResponseEntity(customizedExceptionResponse, HttpStatus.NOT_FOUND);
    }
}
