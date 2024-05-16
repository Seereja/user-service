package com.aston.consumer.kafka.listener;

import lombok.experimental.UtilityClass;

@UtilityClass
public class utils {

    public static final String INFO_NOTIFICATION_TOPIC = "${topic.info-notification}";

    public static final String REGISTRATION_NOTIFICATION_TOPIC = "${topic.registration-notification}";

    public static final String CONSUMER_GROUP_ID = "${spring.kafka.consumer.group-id}";

}
