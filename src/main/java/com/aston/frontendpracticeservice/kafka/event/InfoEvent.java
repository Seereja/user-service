package com.aston.frontendpracticeservice.kafka.event;


public record InfoEvent(
        String firstName,
        String settlementAccount,
        String kbk
) {
}
