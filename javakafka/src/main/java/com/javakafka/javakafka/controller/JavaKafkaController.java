package com.javakafka.javakafka.controller;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/javakafka")
public class JavaKafkaController {
	
	private KafkaTemplate<String,Object> kafkaTemplate;
	
	@Autowired
	public void JavaKafkaController(KafkaTemplate kafkaTemplate) {
		System.out.println("============================== constructor ==============================");
		this.kafkaTemplate = kafkaTemplate;
	}

	@RequestMapping("/producer")
	public String JavKafkaProducer(@RequestBody String data) {
		this.kafkaTemplate.send("java_kafka", data);
		
		System.out.println(" ================================================== KAFKA ================================================== ");
		
		return "Run Procedure kafka";
	}
	
	
	@RequestMapping("/consumer")
	public Object JavKafkaConsumer() {
		 Properties props = new Properties();
	     props.setProperty("bootstrap.servers", "localhost:9092");
	     props.setProperty("group.id", "test");
	     props.setProperty("enable.auto.commit", "true");
	     props.setProperty("auto.commit.interval.ms", "1000");
	     props.setProperty("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     props.setProperty("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
	     KafkaConsumer<String, String> consumer = new KafkaConsumer<>(props);
	     consumer.subscribe(Arrays.asList("java_kafka"));
	     ArrayList<Object> result = new ArrayList<Object>();
	     while (true) {
	    	 ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(100));
	         for (ConsumerRecord<String, String> record : records) {
	             System.out.printf("offset = %d, key = %s, value = %s%n", record.offset(), record.key(), record.value());
	         }
	     }
	}
	
}
