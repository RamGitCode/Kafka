package com.kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.payload.Users;
import com.kafka.producer.JsonKafkaProducer;

@RestController
@RequestMapping("/api/v1/kafka")
public class JsonMessageController 
{
	
	@Autowired
	private JsonKafkaProducer jsonkafkaProducer;
	
	//http://localhost:8080/api/v1/kafka/publish?message=hello from kafka
	
	@PostMapping("/publish")
	public ResponseEntity<String> publish(@RequestBody Users user) 
	{
		jsonkafkaProducer.sendMessage(user);
		return ResponseEntity.ok("Json object send to the kafka topic");
	}
	

}
