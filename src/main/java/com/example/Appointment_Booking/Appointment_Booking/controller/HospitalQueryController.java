package com.example.Appointment_Booking.Appointment_Booking.controller;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Appointment_Booking.Appointment_Booking.KafkaApplication;
import com.example.Appointment_Booking.Appointment_Booking.command.CreateQueryCommand;
import com.example.Appointment_Booking.Appointment_Booking.command.CreateSlotCommand;
import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;
import com.example.Appointment_Booking.Appointment_Booking.query.FindHospitalQuery;
import com.example.Appointment_Booking.Appointment_Booking.repository.HospitalRepository;
import com.example.Appointment_Booking.Appointment_Booking.service.HospitalQueryService;


import io.swagger.annotations.Api;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/hospitals")
@Api(value = "Hospital Account Queries", description = "Hospital Account Query Events API")
@AllArgsConstructor
public class HospitalQueryController {
@Autowired
private HospitalRepository repo;
	 private final HospitalQueryService hospitalQueryService;
	 private final CommandGateway commandGateway;
		private final QueryGateway queryGateway;
		@Autowired
		private final HospitalRepository repository;
	    @GetMapping("/{id}")
	    public CompletableFuture<HospitalAccount> findById(@PathVariable int id) throws InterruptedException, ExecutionException {
//	    	return this.repo.findByid(id);
	        return this.hospitalQueryService.findById(id);
	    }
//	    @PostMapping("/api/library")
//		public String addLibrary(@RequestBody CreateSlotCommand slot) {
//			commandGateway.send(new HospitalAccount(slot.getId(),slot.getSpecializtion(), slot.getSlot1(), slot.getSlot2(), slot.getHospital_private()));
//			return "Saved";
//		} 
//	    @Autowired
//	   KakfaApplication kafka=
	    @PostMapping("/Slotupload/{id}")
		public String addLibrary1(@RequestBody HospitalAccount slot,@PathVariable int id) {
	    	System.out.println(slot);
			commandGateway.send(new CreateSlotCommand(id,slot.getSpecializtion(), slot.getSlot1(), slot.getSlot2(), slot.getHospital_private(),slot.getCategory(),
					 slot.getCity(),
					 slot.getContact_details(),
					 slot.getEmail_address(),
					 slot.getServices(),
					 slot.getState(),
					 slot.getSystems_of_medicine(),
					 slot.getWebsite_link(),
					 slot.getArea_pin_code()));
			new KafkaApplication().produce(slot);
			this.repository.save(slot);
			return "Saved";
		}
	    @GetMapping("/api/Hospitalslot/{id}")
		public HospitalAccount getLibrary(@PathVariable Integer id) throws InterruptedException, ExecutionException {
//	    	queryGateway.query(new CreateQueryCommand(id), ResponseTypes.instanceOf(HospitalAccount.class)).get();
			return this.repository.findByid(id);
//	    	return queryGateway.query(new CreateQueryCommand(id), ResponseTypes.instanceOf(HospitalAccount.class)).get();
			
			
		}
	    @GetMapping("/{id}/events")
	    public List<Object> listEventsForAccount(@PathVariable(value = "id") String id) {
	        return this.hospitalQueryService.listEventsForAccount(id);
	    }
	    @GetMapping("/sample")
	    public String fn()
	    {
	    	return "Hello";
	    }
	    @GetMapping("/samp")
	    public List<String> samp()
	    {
	    	return this.repo.findhospitals();
	    }
	    @Autowired
		private HospitalRepository hospitalrepo;
		
		@GetMapping("/getdetails/{city}")
		public List<HospitalAccount> getdetails(@PathVariable String city)
		{
		return hospitalrepo.findBycity(city);	
		}
		@GetMapping("/getAll")
		public List<HospitalAccount> getAll()
		{
			return hospitalrepo.findAll(); 
		}
		@GetMapping("/getStates")
		public List<String> getStates()
		{
			return hospitalrepo.findStates();
		}
		@GetMapping("/getcity/{state}")
		public List<String> getcity(@PathVariable String state)
		{
			return hospitalrepo.findcity(state);
		}
		@GetMapping("/gethospital/{city}")
		public List<String> gethospital(@PathVariable String city)
		{
			return hospitalrepo.findhospital(city);
		}
		@GetMapping("/getdoctorspecialization/{hospital}")
		public List<String> getspecialization(@PathVariable String hospital)
		{
			return hospitalrepo.findspecialzation(hospital);
		}
		
	    
}