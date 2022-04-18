package com.serverdeliveryapp.controller;


import com.serverdeliveryapp.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ControllerForKafka {

    @Autowired
    private KafkaProducerService producerService;

    @PostMapping("/produce")
    public ResponseEntity<?> produceMessage() {
        producerService.produce();
        return ResponseEntity.ok("Message produced");
    }
}
