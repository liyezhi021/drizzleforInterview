package com.example.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

@Slf4j
public class Listener {

    @KafkaListener(topics = {"test"})
    public void listen(ConsumerRecord<?,?> record){
        log.info("kafka's key :{}", record.key());
        log.info("kafka's value:{}", record.value().toString());
    }

}
