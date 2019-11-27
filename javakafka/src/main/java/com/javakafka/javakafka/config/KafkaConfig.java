package com.javakafka.javakafka.config;

import java.util.HashMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class KafkaConfig {
	
	@Bean
	public ProducerFactory<String,Object> producerFactory(){
		HashMap<String,Object> props = new HashMap<String,Object>();
		 props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		 props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		 props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
		 
		 return new DefaultKafkaProducerFactory<>(props);
	}
	
	@Bean
	public KafkaTemplate<String,Object> kafkaTemplate(){
		
		return new KafkaTemplate<>(this.producerFactory());
	}
	
}
