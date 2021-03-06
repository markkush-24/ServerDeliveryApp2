package com.serverdeliveryapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@SpringBootApplication
@EnableKafka
public class ServerDeliveryApp {

	public static void main(String[] args) {
		SpringApplication.run(ServerDeliveryApp.class, args);
	}

}
