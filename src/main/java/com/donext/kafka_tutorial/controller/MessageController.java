package com.donext.kafka_tutorial.controller;

import com.donext.kafka_tutorial.model.Student;
import com.donext.kafka_tutorial.producer.KafkaProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/messages")
public class MessageController {
    private final KafkaProducer kafkaProducer;

    public MessageController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping
    public ResponseEntity<String> sendMessage(@RequestBody Student student) {
        kafkaProducer.sendMessage(student);
        return ResponseEntity.ok("Message sent successfully");
    }
}
