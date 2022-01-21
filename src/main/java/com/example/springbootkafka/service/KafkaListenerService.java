package com.example.springbootkafka.service;

import com.example.springbootkafka.dto.KafkaMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class KafkaListenerService {

    @KafkaListener(
            topics = "${detaysoft.kafka.topic}",
            groupId = "${detaysoft.kafka.group.id}"
    )
    public void listen(@Payload KafkaMessage message) {
        log.info("Message received.. MessageID : {} Message: {} Date : {}",
                message.getId(),
                message.getMessage(),
                message.getMessageDate());
    }
}
