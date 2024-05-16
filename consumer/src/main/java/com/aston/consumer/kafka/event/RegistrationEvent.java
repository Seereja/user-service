package com.aston.consumer.kafka.event;


public record RegistrationEvent(
        String id,
        String fullName) {
}
