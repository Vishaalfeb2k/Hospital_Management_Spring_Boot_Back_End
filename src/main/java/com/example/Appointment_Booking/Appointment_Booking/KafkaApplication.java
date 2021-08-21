package com.example.Appointment_Booking.Appointment_Booking;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;


@SpringBootApplication
@RestController
@CrossOrigin(origins="*")
public class KafkaApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;
	private HospitalAccount hospital1;
	private String topic="first_topic";
	public void produce(HospitalAccount account)
	{
		template.send(topic,account);
	}
	

}
