package com.aston.frontendpracticeservice.kafka.event;


public record RegistrationEvent(
        String id,
        String fullName) {
}
