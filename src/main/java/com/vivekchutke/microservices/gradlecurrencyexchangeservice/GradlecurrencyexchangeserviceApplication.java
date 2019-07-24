package com.vivekchutke.microservices.gradlecurrencyexchangeservice;

import brave.sampler.Sampler;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.context.annotation.Bean;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) // One way of excluding security dependencies. Chec the other in application.properties or through manifest file
@SpringBootApplication
@EnableDiscoveryClient
@EnableEurekaClient
@EnableHystrix
public class GradlecurrencyexchangeserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(GradlecurrencyexchangeserviceApplication.class, args);
	}

	/**
	 * This method is used for sleuth to capture common logging across calls
	 *
	 * @return
	 */
	@Bean
	public Sampler defaultSampler() {
		return Sampler.ALWAYS_SAMPLE;
	}
}
