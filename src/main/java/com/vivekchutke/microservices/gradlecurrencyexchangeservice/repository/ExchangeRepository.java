package com.vivekchutke.microservices.gradlecurrencyexchangeservice.repository;

import com.vivekchutke.microservices.gradlecurrencyexchangeservice.entity.ExchangeRate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExchangeRepository extends JpaRepository<ExchangeRate, Long> {

    ExchangeRate findByFromAndTo(String from, String to);
}
