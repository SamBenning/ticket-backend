package com.ticketproject.ticket.resource;

import com.ticketproject.ticket.model.Response;
import com.ticketproject.ticket.model.Ticket;
import com.ticketproject.ticket.service.implementation.TicketServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Map;

import static java.time.LocalDateTime.now;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.of;

@RestController
@RequestMapping("/ticket")
@RequiredArgsConstructor
public class TicketResource {
    private final TicketServiceImpl ticketService;

    @GetMapping("/list")
    public ResponseEntity<Response> getTickets() {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("tickets", ticketService.list(30)))
                        .message("Tickets retrieved")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @PostMapping("/save")
    public ResponseEntity<Response> saveTicket(@RequestBody @Valid Ticket ticket) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ticket", ticketService.create(ticket)))
                        .message("Ticket created")
                        .status(CREATED)
                        .statusCode(CREATED.value())
                        .build()
        );
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<Response> getTicket(@PathVariable("id") Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("ticket", ticketService.get(id)))
                        .message("Ticket retrieved.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Response> deleteTicket(@PathVariable Long id) {
        return ResponseEntity.ok(
                Response.builder()
                        .timeStamp(now())
                        .data(Map.of("deleted", ticketService.delete(id)))
                        .message("Ticket deleted.")
                        .status(OK)
                        .statusCode(OK.value())
                        .build()
        );
    }
}
