package com.ticketproject.ticket;

import com.ticketproject.ticket.enums.Status;
import com.ticketproject.ticket.model.Ticket;
import com.ticketproject.ticket.repository.TicketRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

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

}
