package com.zomato.deliveryBoy.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import com.zomato.deliveryBoy.constants.ProducerConstants;

@Configuration
public class KafkaProducerConfig {
	
	@Bean
	public NewTopic topic()
	{
		return TopicBuilder.name(ProducerConstants.TOPIC_NAME).build();
	}

}
