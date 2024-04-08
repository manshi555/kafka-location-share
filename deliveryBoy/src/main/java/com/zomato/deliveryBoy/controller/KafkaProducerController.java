package com.zomato.deliveryBoy.controller;

import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zomato.deliveryBoy.service.KafkaProducerService;

@RestController
@RequestMapping("/location")
public class KafkaProducerController {

	private Logger log = LoggerFactory.getLogger(KafkaProducerController.class);
	
	@Autowired
	private KafkaProducerService kafkaService;

	@PostMapping("/update")
	public ResponseEntity<?> updateLocation() {
		for(int i=0; i< 10000 ; i++)
		{
			log.info("under update location controller class");
			this.kafkaService.updateLocation(
					"( " + Math.round(Math.random() * 100) + "  ,  " + Math.round(Math.random() * 100) + ")");
		}
		return new ResponseEntity<>(Map.of("message", "Location updated"), HttpStatus.OK);
	}

}
