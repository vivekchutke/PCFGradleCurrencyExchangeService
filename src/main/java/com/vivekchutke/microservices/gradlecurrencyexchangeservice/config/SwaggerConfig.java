package com.vivekchutke.microservices.gradlecurrencyexchangeservice.config;

import org.springframework.context.annotation.Configuration;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    // Access the Swgger Ui by going to http://localhost:8000/swagger-ui.html
    // To access APi documentation http://localhost:8000/v2/api-docs
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2);
    }
}
