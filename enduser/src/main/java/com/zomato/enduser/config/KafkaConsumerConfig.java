package com.zomato.enduser.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

import com.zomato.enduser.constants.ConsumerConstants;

@Configuration
public class KafkaConsumerConfig {
	
	private Logger log = LoggerFactory.getLogger(KafkaConsumerConfig.class);
	
	@KafkaListener(topics = ConsumerConstants.TOPIC_NAME, groupId = ConsumerConstants.GROUP_ID)
	public void updatedLocation(String location)
	{
		log.info("Consumed location ..");
		System.out.println(location);
	}
	

}
