package com.kafka.controller;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.producer.KafkaProducer;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController 
{

	@Autowired
	private KafkaProducer kafkaProducer;
	
	//http://localhost:8080/api/v1/kafka/publish?message=hello from kafka
	
	@GetMapping("/publish")
	public ResponseEntity<String> publish(@RequestParam("message") String message) 
	{
		kafkaProducer.sendMessage(message);
		return ResponseEntity.ok("Message send to the topic");
	}
	
}
