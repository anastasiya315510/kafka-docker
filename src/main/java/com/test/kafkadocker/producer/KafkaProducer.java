/*
 author Anastasiya
 created on 29/08/2021
 */


package com.test.kafkadocker.producer;

import com.test.kafkadocker.model.KafkaRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;



@Service
@Slf4j
public class KafkaProducer {
    private static final String TOPIC_INPUT = "my-cdc-input-topic";
    private static final String TOPIC_OUTPUT = "my-cdc-output-topic";

     @Autowired
    private KafkaTemplate<String, KafkaRecord> kafkaTemplate;


     public void writeMessage(KafkaRecord kafkaRecord){
         log.info(String.format("record create -> %s", kafkaRecord));
         this.kafkaTemplate.send(TOPIC_INPUT, kafkaRecord);
     }
}
