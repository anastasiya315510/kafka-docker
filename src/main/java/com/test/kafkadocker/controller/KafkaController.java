/*
 author Anastasiya
 created on 29/08/2021
 */


package com.test.kafkadocker.controller;

import com.test.kafkadocker.model.HeaderKafkaRecord;
import com.test.kafkadocker.model.KafkaRecord;
import com.test.kafkadocker.producer.KafkaProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class KafkaController {

    private final KafkaProducer kafkaProducer;

    @Autowired
    public KafkaController(KafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping("/publish")
    public void writeMessageToTopic(@RequestBody KafkaRecord record){
        KafkaRecord build = KafkaRecord.builder()
                .pk(record.getPk())
                .data(LocalDateTime.now())
                .beforeData(record.getData())
                .headers(HeaderKafkaRecord.builder()
                        .streamPosition(record.getHeaders().getStreamPosition())
                        .operation(record.getHeaders().getOperation())
                        .timestamp(record.getHeaders().getTimestamp())
                        .build())
                .build();
        this.kafkaProducer.writeMessage(build);
    }
}
