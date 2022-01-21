package com.example.springbootkafka.dto;

import java.time.LocalDate;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(of = {"id", "message", "messageDate"})
public class KafkaMessage {
    private String message;
    private String id = UUID.randomUUID().toString();
    private LocalDate messageDate = LocalDate.now();
}