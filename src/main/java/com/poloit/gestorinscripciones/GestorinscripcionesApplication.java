package com.poloit.gestorinscripciones;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class}) //excluyo la configuracion de Security hasta tenerla ok
public class GestorinscripcionesApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestorinscripcionesApplication.class, args);
	}

}
