package com.vivekchutke.microservices.gradlecurrencyexchangeservice.exception;

import java.util.Date;

public class CustomizedExceptionResponse {

    private java.util.Date Date;

    private String message;

    private String details;

    public CustomizedExceptionResponse(Date date, String message, String details) {
        Date = date;
        this.message = message;
        this.details = details;
    }

    public Date getDate() {
        return Date;
    }

    public void setDate(Date date) {
        Date = date;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "CustomizedExceptionResponse{" +
                "Date='" + Date + '\'' +
                ", message='" + message + '\'' +
                ", details='" + details + '\'' +
                '}';
    }
}
