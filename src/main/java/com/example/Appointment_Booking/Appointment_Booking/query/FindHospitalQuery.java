package com.example.Appointment_Booking.Appointment_Booking.query;

import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FindHospitalQuery {

	 public Integer id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		@Override
		public String toString() {
			return "FindHospitalQuery [id=" + id + "]";
		}
		public FindHospitalQuery(int id) {
			super();
			this.id = id;
		}
		
		
}