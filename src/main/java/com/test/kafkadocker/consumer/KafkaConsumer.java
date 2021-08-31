/*
 author Anastasiya
 created on 29/08/2021
 */


package com.test.kafkadocker.consumer;

import com.test.kafkadocker.model.KafkaRecord;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaConsumer {
    @KafkaListener(topics = "my-cdc-output-topic",groupId = "my_group_id")
    public void getMessage(KafkaRecord record){
    log.info(String.format("consumer record -> %s", record));
    }
}
