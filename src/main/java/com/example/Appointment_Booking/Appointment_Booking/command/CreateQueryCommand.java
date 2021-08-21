package com.example.Appointment_Booking.Appointment_Booking.command;

import org.axonframework.modelling.command.TargetAggregateIdentifier;
import org.axonframework.spring.stereotype.Aggregate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Aggregate
public class CreateQueryCommand {
	@TargetAggregateIdentifier
	public int id;
	public String specializtion;
	public String slot1;
	public String slot2;
	public String hospital_private;
	public String state;               
	public String city;                
	public String category;            
	public String systems_of_medicine; 
	public String contact_details;     
	public String area_pin_code;       
	public String email_address;       
	public String website_link;        
	public String services;
	
	public CreateQueryCommand(int id) {
		super();
		this.id = id;
	}

	public CreateQueryCommand(int id, String specializtion, String slot1, String slot2, String hospital_private,
			String state, String city, String category, String systems_of_medicine, String contact_details,
			String area_pin_code, String email_address, String website_link, String services) {
		super();
		this.id = id;
		this.specializtion = specializtion;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.hospital_private = hospital_private;
		this.state = state;
		this.city = city;
		this.category = category;
		this.systems_of_medicine = systems_of_medicine;
		this.contact_details = contact_details;
		this.area_pin_code = area_pin_code;
		this.email_address = email_address;
		this.website_link = website_link;
		this.services = services;
	}
	
	
	
}
