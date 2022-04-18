package com.serverdeliveryapp.service;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class KafkaProducerServiceImpl implements KafkaProducerService {

    @Value("${kafka.topic}")
    private String kafkaTopic;

    @Autowired
    private Producer producer;

    private final KafkaTemplate<Long, String> kafkaTemplate;

    @Autowired
    public KafkaProducerServiceImpl(KafkaTemplate<Long, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @SneakyThrows
    @Override
    public void produce() {
        log.info("<= sending {}", "hello");
        ProducerRecord<Long, String> record = new ProducerRecord<Long, String>(kafkaTopic, null, "hello");
        producer.send(record).get();
    }
}
