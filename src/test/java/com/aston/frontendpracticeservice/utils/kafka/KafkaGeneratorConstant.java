package com.aston.frontendpracticeservice.utils.kafka;

import com.aston.frontendpracticeservice.kafka.event.InfoEvent;
import com.aston.frontendpracticeservice.kafka.event.RegistrationEvent;
import lombok.experimental.UtilityClass;

import static com.aston.frontendpracticeservice.utils.kafka.KafkaGenerator.BIK_EXAMPLE;
import static com.aston.frontendpracticeservice.utils.kafka.KafkaGenerator.CONSUMER_ID;
import static com.aston.frontendpracticeservice.utils.kafka.KafkaGenerator.FIRST_NAME;
import static com.aston.frontendpracticeservice.utils.kafka.KafkaGenerator.FULL_NAME;
import static com.aston.frontendpracticeservice.utils.kafka.KafkaGenerator.SETTLEMENT_ACCOUNT_EXAMPLE;

@UtilityClass
public class KafkaGeneratorConstant {

    public static RegistrationEvent registrationEvent() {
        return new RegistrationEvent(
                CONSUMER_ID,
                FULL_NAME
        );
    }

    public static InfoEvent infoEvent() {
        return new InfoEvent(
                FIRST_NAME,
                SETTLEMENT_ACCOUNT_EXAMPLE,
                BIK_EXAMPLE
        );
    }


}
