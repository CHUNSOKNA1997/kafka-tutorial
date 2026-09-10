package com.donext.kafka_tutorial.comsumer;

import com.donext.kafka_tutorial.model.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "my-topic", groupId = "myGroup")
    public void consumeMessage(Student student) {
      log.info("Received message: {}", student.toString());
    }

}
