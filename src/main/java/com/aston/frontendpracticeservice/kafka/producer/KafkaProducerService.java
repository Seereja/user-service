package com.aston.frontendpracticeservice.kafka.producer;

import com.aston.frontendpracticeservice.kafka.event.InfoEvent;
import com.aston.frontendpracticeservice.kafka.event.RegistrationEvent;
import com.aston.frontendpracticeservice.kafka.util.KafkaAdminClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
@Slf4j
@RequiredArgsConstructor
public class KafkaProducerService {

    @Value("${topic.info-notification}")
    private String getUserInfoTopic;

    @Value("${topic.registration-notification}")
    private String registrationNotificationTopic;

    private final KafkaTemplate<String, Object> kafkaTemplate;


//    private final KafkaAdminClient kafkaAdminClient;


    public void sendGetUserInfo(InfoEvent userSendEvent) {
        kafkaTemplate.send(getUserInfoTopic, userSendEvent.firstName(), userSendEvent);
    }

    public void sendUserRegistration(RegistrationEvent registrationEvent) {
//        if (kafkaAdminClient.verifyConnection()) {
        kafkaTemplate.send(registrationNotificationTopic, registrationEvent.id(), registrationEvent);

//        }
    }

    private void sendEvent(int partition, String topic, Object event, String eventId) {

        log.info("Sending event to Kafka topic: {} and partition: {}", topic, partition);
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send(topic, partition, eventId, event);
        future.whenComplete((result, ex) -> {
            if (ex == null) {
                log.info("Successfully sent event to Kafka topic: {} and partition: {} and event: {} ", topic, partition, event);
            } else {
                log.error("Failed to send event to Kafka topic: {} and partition: {}", topic, partition, ex);
            }
        });

    }
}
