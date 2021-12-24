package com.ticketproject.ticket.service.implementation;

import com.ticketproject.ticket.model.Ticket;
import com.ticketproject.ticket.repository.TicketRepo;
import com.ticketproject.ticket.service.TicketService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Transactional
@Slf4j
public class TicketServiceImpl implements TicketService {
    private final TicketRepo ticketRepo;
    @Override
    public Ticket create(Ticket ticket) {
        log.info("Saving new ticket: {}", ticket.getId());
        return ticketRepo.save(ticket);
    }

    @Override
    public Collection<Ticket> list(int limit) {
        log.info("Fetching all tickets.");
        return ticketRepo.findAll(PageRequest.of(0, limit)).toList();
    }
    @Override
    public Ticket get(Long id) {
        log.info("Fetching ticket by id: {}", id);
        return ticketRepo.findById(id).get();
    }

    @Override
    public Ticket update(Ticket ticket) {
        log.info("Updating ticket: {}", ticket.getId());
        Ticket ticketInDb = ticketRepo.getById(ticket.getId());
        ticketInDb.setBriefDescription(ticket.getBriefDescription());
        ticketInDb.setDetailedDescription(ticket.getDetailedDescription());
        ticketInDb.setTicketStatus(ticket.getTicketStatus());
        return ticketRepo.save(ticketInDb);
    }

    @Override
    public Boolean delete(Long id) {
        log.info("Deleting ticket: {}", id);
        ticketRepo.deleteById(id);
        return true;
    }
}

