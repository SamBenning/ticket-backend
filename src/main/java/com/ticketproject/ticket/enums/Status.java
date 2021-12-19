package com.ticketproject.ticket.enums;

public enum Status {
    OPEN("OPEN"),
    WAITING("WAITING"),
    SCHEDULED("SCHEDULED"),
    COMPLETED("COMPLETED");
    private final String status;

    Status(String status) {
        this.status = status;
    }

    public String getStatus() {
        return this.status;
    }




}
