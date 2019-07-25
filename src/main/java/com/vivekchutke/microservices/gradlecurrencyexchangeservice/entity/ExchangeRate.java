package com.vivekchutke.microservices.gradlecurrencyexchangeservice.entity;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="from_currency")
    private String from;

    @Column(name="to_currency")
    private String to;

    private BigDecimal conversitionValue;

    private int portNumber;

    @Transient
    private String propertyValueFromGitMinimum;

    @Transient
    private String propertyValueFromGitMaximun;

    public ExchangeRate() {

    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "id=" + id +
                ", from='" + from + '\'' +
                ", to='" + to + '\'' +
                ", conversitionValue=" + conversitionValue +
                ", portNumber=" + portNumber +
                '}';
    }

    public ExchangeRate(long id, String from, String to, BigDecimal conversitionValue, int portNumber) {
        this.id = id;
        this.from = from;
        this.to = to;
        this.conversitionValue = conversitionValue;
        this.portNumber = portNumber;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public BigDecimal getConversitionValue() {
        return conversitionValue;
    }

    public void setConversitionValue(BigDecimal conversitionValue) {
        this.conversitionValue = conversitionValue;
    }

    public int getPortNumber() {
        return portNumber;
    }

    public void setPortNumber(int portNumber) {
        this.portNumber = portNumber;
    }

    public String getPropertyValueFromGitMinimum() {
        return propertyValueFromGitMinimum;
    }

    public void setPropertyValueFromGitMinimum(String propertyValueFromGitMinimum) {
        this.propertyValueFromGitMinimum = propertyValueFromGitMinimum;
    }

    public String getPropertyValueFromGitMaximun() {
        return propertyValueFromGitMaximun;
    }

    public void setPropertyValueFromGitMaximun(String propertyValueFromGitMaximun) {
        this.propertyValueFromGitMaximun = propertyValueFromGitMaximun;
    }
}


