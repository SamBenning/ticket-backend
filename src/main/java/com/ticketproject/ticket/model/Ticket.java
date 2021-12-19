package com.ticketproject.ticket.model;

import com.ticketproject.ticket.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

import static javax.persistence.GenerationType.AUTO;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data public class Ticket {
    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;
    @NotEmpty(message = "Brief Description cannot be empty or null")
    private String briefDescription;
    private String detailedDescription;
    @NotEmpty(message = "Status cannot be empty or null")
    private String ticketStatus;
}
