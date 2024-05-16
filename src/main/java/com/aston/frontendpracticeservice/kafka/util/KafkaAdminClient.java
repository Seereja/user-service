package com.aston.frontendpracticeservice.kafka.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.common.Node;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Properties;

/**
 * Класс для проверки соединения с кафкой.
 */
@Component
@Slf4j
public class KafkaAdminClient {
    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrap;

    /**
     * Проверяет соединение с кафкой.
     *
     * @return true - кафка доступна, false - недоступна
     */
    public boolean verifyConnection() {
        log.info("Verify Kafka connection, URL: {}", bootstrap);

        Properties props = new Properties();
        props.put("bootstrap.servers", bootstrap);
        props.put("request.timeout.ms", 3000);
        props.put("connections.max.idle.ms", 5000);
        props.put("default.api.timeout.ms", 5000);

        Collection<Node> nodes;
        try (AdminClient client = AdminClient.create(props)) {
            nodes = client.describeCluster().nodes().get();
        } catch (Exception e) {
            log.warn("Kafka connection fail");
            return false;
        }

        boolean connected = nodes != null && nodes.size() > 0;
        if (connected) {
            log.info("Kafka connection success");
        } else {
            log.warn("Kafka connection fail");
        }
        return connected;
    }
}
