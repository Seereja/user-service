package com.aston.consumer.kafka.event;



public record InfoEvent(
        String firstName,
        String settlementAccount,
        String kbk
) {
}
