package com.zomato.deliveryBoy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.zomato.deliveryBoy.constants.ProducerConstants;
import com.zomato.deliveryBoy.controller.KafkaProducerController;

@Service
public class KafkaProducerService {
	
	private Logger log = LoggerFactory.getLogger(KafkaProducerController.class);
	
	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;
	
	public boolean updateLocation(String location)
	{
		this.kafkaTemplate.send(ProducerConstants.TOPIC_NAME,location);
		log.info("location message produced");
		return true;
		
		
	}

}
