package com.ticketproject.ticket.service;

import com.ticketproject.ticket.model.Ticket;

import java.util.Collection;

public interface TicketService {
    Ticket create(Ticket ticket);
    Collection<Ticket> list(int limit);
    Ticket get(Long id);
    Ticket update(Ticket ticket);
    Boolean delete(Long id);
}
