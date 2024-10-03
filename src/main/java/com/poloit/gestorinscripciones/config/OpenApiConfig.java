package com.poloit.gestorinscripciones.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("MVP - Sistema de Inscripciones")
                        .version("0.1")
                        .description("ACELERADOR 2024 - POLO IT")
                        .termsOfService("http://swagger.io/terms")
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org"))
                );
    }
}
