package com.example.Appointment_Booking.Appointment_Booking.config;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.kafka.support.serializer.JsonSerializer;

import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;

import java.util.Map;
import java.util.HashMap;
@EnableKafka
@Configuration
public class kafkaPublicherConfig {

	@Bean
	public ProducerFactory<String, Object> producerFactory(){
		Map<String,Object> configs=new HashMap<>();
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
	    configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,StringSerializer.class);
	    configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,JsonSerializer.class);
		return new DefaultKafkaProducerFactory<String,Object>(configs);
	}
	@Bean
    public ConsumerFactory<Object,Object> consumerFactory(){
        Map<String,Object> config = new HashMap<>();
        config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
        config.put(ConsumerConfig.GROUP_ID_CONFIG,"sample-group");   
        config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringSerializer.class);
        config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, JsonSerializer.class);
//        return new DefaultKafkaConsumerFactory<>(config);
    
        return new DefaultKafkaConsumerFactory(config,new StringDeserializer(),
               new JsonDeserializer<>(HospitalAccount.class));
        		
       
	}
	
	@Bean
	public KafkaTemplate<String,Object> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
	   @Bean
	    public ConcurrentKafkaListenerContainerFactory<String, HospitalAccount> kafkaListener(){
	        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
	        factory.setConsumerFactory(consumerFactory());
	        return factory;
	    }
}
