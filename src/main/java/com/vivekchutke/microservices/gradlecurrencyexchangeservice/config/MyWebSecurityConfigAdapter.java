package com.vivekchutke.microservices.gradlecurrencyexchangeservice.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class MyWebSecurityConfigAdapter extends WebSecurityConfigurerAdapter {

    // Enable the below Method if you want to disabled Spring Security while using Pivotal Cloud Libraries
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().anyRequest().permitAll();

        // Added so we can refresh through http://<AppName>/actuator/refresh. Without this is was giving me forbidden exception.
        // The issue is still not resolved as now I am getting 404 exception
        http.csrf().disable();
    }
}
