package com.kafka.producer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

import com.kafka.payload.Users;

@Service
public class JsonKafkaProducer 
{
	private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaProducer.class);
	
	@Autowired
	 private KafkaTemplate<String, Users> kafkaTemplate;
	
	public void sendMessage(Users data) {
		
		LOGGER.info(String.format("Message send for json -> %s", data));
        Message<Users> message = MessageBuilder
                .withPayload(data)
                .setHeader("topic", "jsontopic") // Optional, not used by KafkaTemplate by default
                .build();

        kafkaTemplate.send("jsontopic", data); // This is the actual sending part
    }

}
