package com.example.springbootkafka.controller;

import com.example.springbootkafka.dto.KafkaMessage;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/kmessage")
@RequiredArgsConstructor
public class ResourceController {

    @Value("${detaysoft.kafka.topic}")
    private String topic;

    private final KafkaTemplate<String, KafkaMessage> kafkaTemplate;

    @PostMapping
    public void sendMessage(@RequestBody KafkaMessage kMessage) {
        kafkaTemplate.send(topic, UUID.randomUUID().toString(), kMessage);
    }// mesajı kuyruğa attack
}
