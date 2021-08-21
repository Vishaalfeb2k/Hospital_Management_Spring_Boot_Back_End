package com.example.Appointment_Booking.Appointment_Booking.controller;

import java.util.concurrent.CompletableFuture;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.Appointment_Booking.Appointment_Booking.dto.SlotCreationDto;
import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;
import com.example.Appointment_Booking.Appointment_Booking.service.HospitalCommandService;

import lombok.AllArgsConstructor;

@RestController
@Service
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor
public class HospitalCommandController {

	@Autowired
	private final HospitalCommandService hospitalCommandService;
	

	

}