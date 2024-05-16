package com.aston.consumer.kafka.listener;

import com.aston.consumer.kafka.event.InfoEvent;
import com.aston.consumer.kafka.event.RegistrationEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import static com.aston.consumer.kafka.listener.utils.CONSUMER_GROUP_ID;
import static com.aston.consumer.kafka.listener.utils.INFO_NOTIFICATION_TOPIC;
import static com.aston.consumer.kafka.listener.utils.REGISTRATION_NOTIFICATION_TOPIC;

@Slf4j
@AllArgsConstructor
@Component
public class Listener {

    private final ObjectMapper objectMapper;


    @Transactional
    @KafkaListener(
            topics = REGISTRATION_NOTIFICATION_TOPIC,
            containerGroup = CONSUMER_GROUP_ID,
            properties = {"spring.json.value.default.type=com.aston.consumer.kafka.event.RegistrationEvent"}
    )
    public void createUser(RegistrationEvent registrationEvent) {

        try {
            registrationEvent = objectMapper.convertValue(registrationEvent, RegistrationEvent.class);
            log.info("User with ID {} and full name '{}' was successfully registered.",
                    registrationEvent.id(),
                    registrationEvent.fullName());
        } catch (Exception e) {
            log.error("Error processing UserRegistrationListener: {}", e.getMessage());

        }
    }

    @Transactional
    @KafkaListener(
            topics = INFO_NOTIFICATION_TOPIC,
            groupId = CONSUMER_GROUP_ID,
            properties = {"spring.json.value.default.type=com.aston.consumer.kafka.event.InfoEvent"})
    public void getInfoUser(InfoEvent infoEvent) {
        try {
            infoEvent = objectMapper.convertValue(infoEvent, InfoEvent.class);
            log.info("User with first name {} and settlementAccount '{}' and kbk '{}' was successfully get.",
                    infoEvent.firstName(),
                    infoEvent.settlementAccount(),
                    infoEvent.kbk());

        } catch (Exception e) {
            log.error("Error processing InfoEvent: {}", e.getMessage());
        }
    }

// этот метод нужен, если указываем полезную нагрузку
//    private  Map<String, Object> converterPayload(String payload) throws JsonProcessingException {
//        Map<String, Object> payloadMap = objectMapper.readValue(payload, new TypeReference<>() {
//        });
//        Map<String, Object> userRegistrationMap = (Map<String, Object>) payloadMap.get("payload");
//        return userRegistrationMap;
//    }
}
