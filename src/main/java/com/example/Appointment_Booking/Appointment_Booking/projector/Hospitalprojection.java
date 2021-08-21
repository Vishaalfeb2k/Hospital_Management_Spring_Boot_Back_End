package com.example.Appointment_Booking.Appointment_Booking.projector;

import org.springframework.stereotype.Component;

import org.axonframework.eventhandling.EventHandler;
import org.axonframework.queryhandling.QueryHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import com.example.Appointment_Booking.Appointment_Booking.event.Allocatedslotsevent;
import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;
import com.example.Appointment_Booking.Appointment_Booking.repository.HospitalRepository;
@Slf4j
@RequiredArgsConstructor
@Component
public class Hospitalprojection 
{
public final HospitalRepository repository;

	
@EventHandler
public void on(Allocatedslotsevent event) {
    log.debug("Handling a Hospital Account creation command {}", event.getId());
    HospitalAccount hospitalAccount = new HospitalAccount(
            event.getId(),
            event.getHospital_private(),
            event.getSlot1(),
            event.getSlot2(),
            event.getSpecializtion(),
            event.getCategory(),
			event.getCity(),
			event.getContact_details(),
			event.getEmail_address(),
			event.getServices(),
			event.getState(),
			event.getSystems_of_medicine(),
			event.getWebsite_link(),
			event.getArea_pin_code()
    );
    this.repository.save(hospitalAccount);
   // log.info(hospitalAccount.hospital_private);
}
}
