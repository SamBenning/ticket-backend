package com.ticketproject.ticket;

import com.ticketproject.ticket.enums.Status;
import com.ticketproject.ticket.model.Ticket;
import com.ticketproject.ticket.repository.TicketRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.Arrays;

@SpringBootApplication
public class TicketApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketApplication.class, args);
	}

	@Bean
	CommandLineRunner run(TicketRepo ticketRepo) {
		return args -> {
			ticketRepo.save(new Ticket(null, "Fan broken",
					"Fan is busted", "OPEN"));
			ticketRepo.save(new Ticket(null, "Toilet running",
					"The toilet is continuously running", "OPEN"));
			ticketRepo.save(new Ticket(null, "Fridge not cooling",
					"All my food is going bad!", "OPEN"));
			ticketRepo.save(new Ticket(null, "Heater making noise",
					"When it kicks on, makes grinding noise", "OPEN"));
			ticketRepo.save(new Ticket(null, "Sink leak",
					"Steady drip from the faucet at all times", "OPEN"));

		};
	}

	@Bean
	public CorsFilter corsFilter() {
		UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.setAllowCredentials(true);
		corsConfiguration.setAllowedOrigins(Arrays.asList("http://localhost:3000", "http://localhost:4200"));
		corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
				"Accept", "Jwt-Token", "Authorization", "Origin, Accept", "X-Requested-With",
				"Access-Control-Request-Method", "Access-Control-Request-Headers"));
		corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Jwt Token", "Authorization",
				"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials", "Filename"));
		corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
		return new CorsFilter(urlBasedCorsConfigurationSource);
	}

}
