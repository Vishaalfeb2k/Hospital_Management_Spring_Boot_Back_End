package com.example.Appointment_Booking.Appointment_Booking.hospitalaccount;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="hospital")
public class HospitalAccount 
{
	@Id
	@GeneratedValue
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
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getCity() {
		return city;
	}
	public String getSlot1() {
		return slot1;
	}
	public String getSlot2() {
		return slot2;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getHospital_private() {
		return hospital_private;
	}
	public void setHospital_private(String hospital_private) {
		this.hospital_private = hospital_private;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getSystems_of_medicine() {
		return systems_of_medicine;
	}
	public void setSystems_of_medicine(String systems_of_medicine) {
		this.systems_of_medicine = systems_of_medicine;
	}
	public String getContact_details() {
		return contact_details;
	}
	public void setContact_details(String contact_details) {
		this.contact_details = contact_details;
	}
	public String getArea_pin_code() {
		return area_pin_code;
	}
	public void setArea_pin_code(String area_pin_code) {
		this.area_pin_code = area_pin_code;
	}
	public String getEmail_address() {
		return email_address;
	}
	public void setEmail_address(String email_address) {
		this.email_address = email_address;
	}
	public String getWebsite_link() {
		return website_link;
	}
	public void setWebsite_link(String website_link) {
		this.website_link = website_link;
	}
	public String getSpecializtion() {
		return specializtion;
	}
	public void setSpecializtion(String specializtion) {
		this.specializtion = specializtion;
	}
	public String getServices() {
		return services;
	}
	public void setServices(String services) {
		this.services = services;
	}
	public String setSlot1() {
		return slot1;
	}
	public String setSlot2() {
		return slot2;
	}
	
	

	public HospitalAccount(int id) {
		super();
		this.id = id;
	}
	@Override
	public String toString() {
		return "HospitalAccount [id=" + id + ", specializtion=" + specializtion + ", slot1=" + slot1 + ", slot2="
				+ slot2 + ", hospital_private=" + hospital_private + ", state=" + state + ", city=" + city
				+ ", category=" + category + ", systems_of_medicine=" + systems_of_medicine + ", contact_details="
				+ contact_details + ", area_pin_code=" + area_pin_code + ", email_address=" + email_address
				+ ", website_link=" + website_link + ", services=" + services + "]";
	}
	
	
	
	
	
}
