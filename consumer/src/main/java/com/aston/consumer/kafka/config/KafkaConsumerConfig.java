//package com.aston.consumer.kafka.config;
//
//import org.apache.kafka.clients.consumer.ConsumerConfig;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
//import org.springframework.kafka.config.KafkaListenerContainerFactory;
//import org.springframework.kafka.core.ConsumerFactory;
//import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
//import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
//import org.springframework.kafka.support.serializer.JsonDeserializer;
//
//
//import java.util.Map;
//
//@Configuration
//public class KafkaConsumerConfig {
//
//    @Value("${spring.kafka.bootstrap-servers}")
//    private String bootstrapServers;
//
//    /**
//     * The group ID for Kafka consumer.
//     */
//    @Value("${spring.kafka.consumer.group-id}")
//    private String groupId;
//
//    /**
//     * Returns the configuration properties for the Kafka consumer.
//     *
//     * @return The configuration properties.
//     */
//    public Map<String, Object> consumerConfig() {
//        return Map.of(
//                ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers,
//                ConsumerConfig.GROUP_ID_CONFIG, groupId,
//                ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonDeserializer.class,
//                JsonDeserializer.TRUSTED_PACKAGES, "com.aston.consumer.kafka.event"
//
//        );
//    }
//
//    /**
//     * Creates a new instance of the Kafka consumer factory.
//     *
//     * @return The Kafka consumer factory.
//     */
//    @Bean
//    public ConsumerFactory<String, Object> consumerFactory() {
//        return new DefaultKafkaConsumerFactory<>(consumerConfig());
//    }
//
//    /**
//     * Creates a new instance of the Kafka listener container factory.
//     *
//     * @param consumerFactory The Kafka consumer factory.
//     * @return The Kafka listener container factory.
//     */
//    @Bean
//    public KafkaListenerContainerFactory<
//            ConcurrentMessageListenerContainer<String, Object>> factory(
//            ConsumerFactory<String, Object> consumerFactory) {
//
//        ConcurrentKafkaListenerContainerFactory<String, Object> factory =
//                new ConcurrentKafkaListenerContainerFactory<>();
//        factory.setConsumerFactory(consumerFactory);
//        return factory;
//    }
//}
