package com.example.Appointment_Booking.Appointment_Booking.service;

import java.util.UUID;
import java.util.concurrent.CompletableFuture;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.springframework.stereotype.Service;

import com.example.Appointment_Booking.Appointment_Booking.command.CreateSlotCommand;
import com.example.Appointment_Booking.Appointment_Booking.dto.SlotCreationDto;
import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HospitalCommandService
{

	private final CommandGateway commandGateway;
	
	
	 public CompletableFuture<HospitalAccount> createAccount(SlotCreationDto creationDTO) {
	        return this.commandGateway.send(new CreateSlotCommand(
	             	creationDTO.getId(),
	             	creationDTO.getHospital_private(),
	                creationDTO.getSlot1(),
	                creationDTO.getSlot2(),
	                creationDTO.getSpecializtion(),
	                creationDTO.getCategory(),
	                creationDTO.getCity(),
	                creationDTO.getContact_details(),
	                creationDTO.getEmail_address(),
	                creationDTO.getServices(),
	                creationDTO.getState(),
	                creationDTO.getSystems_of_medicine(),
	                creationDTO.getWebsite_link(),
	                creationDTO.getArea_pin_code()
	              
	        ));
	    }

}
