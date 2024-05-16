package com.aston.frontendpracticeservice.integration.producer;

import com.aston.frontendpracticeservice.kafka.event.InfoEvent;
import com.aston.frontendpracticeservice.kafka.producer.KafkaProducerService;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import static com.aston.frontendpracticeservice.utils.kafka.KafkaGeneratorConstant.infoEvent;
import static org.junit.Assert.assertEquals;

@DirtiesContext
@SpringBootTest(properties = "spring.kafka.bootstrap-servers=localhost:9092")
@ExtendWith(SpringExtension.class)
@EmbeddedKafka(partitions = 1, brokerProperties = {"listeners=PLAINTEXT://localhost:9092", "port=9092"})
class KafkaProducerServiceTest {

    public static final String TOPIC_NAME_SEND_CLIENT = "registration-notification";
    public static final String TOPIC_INFO_EVENT = "info-notification";


    @Autowired
    private KafkaProducerService kafkaProducerService;


    @Test
    @DisplayName("Kafka should send registration event")
    void testShouldSendRegistrationEvent() {

        InfoEvent infoEvent = infoEvent();
        kafkaProducerService.sendGetUserInfo(infoEvent);


        Properties properties = new Properties();
        properties.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        properties.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        properties.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class);
        properties.put(JsonDeserializer.TRUSTED_PACKAGES, "*");
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "group-java-test");
        properties.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");
        properties.put(JsonDeserializer.VALUE_DEFAULT_TYPE, InfoEvent.class);
        KafkaConsumer<String, InfoEvent> consumer = new KafkaConsumer<>(properties);
        consumer.subscribe(List.of(TOPIC_INFO_EVENT));
        ConsumerRecords<String, InfoEvent> records = consumer.poll(Duration.ofMillis(10000L));
        consumer.close();

        assertEquals(1, records.count());
        InfoEvent receivedEvent = records.iterator().next().value();
        assertEquals(infoEvent().firstName(), receivedEvent.firstName());
        assertEquals(infoEvent().kbk(), receivedEvent.kbk());
        assertEquals(infoEvent().settlementAccount(), receivedEvent.settlementAccount());
    }
}

