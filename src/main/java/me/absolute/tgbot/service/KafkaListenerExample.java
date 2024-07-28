package me.absolute.tgbot.service;

import lombok.RequiredArgsConstructor;

import me.absolute.tgbot.bot.BusinessBot;
import me.absolute.tgbot.model.Notification;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaListenerExample {
    private static final String notificationTopic = "${topic.name.notification}";

    private final BusinessBot businessBot;

    @KafkaListener(topics = notificationTopic, groupId = "myGroup")
    void listen(Notification notification) {
        businessBot.sendNotification(notification);
    }
}
