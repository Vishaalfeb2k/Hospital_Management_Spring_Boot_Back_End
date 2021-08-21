package com.example.Appointment_Booking.Appointment_Booking.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;



@Repository
public interface HospitalRepository extends JpaRepository<HospitalAccount, Integer> {
HospitalAccount findByid(int id);
List<HospitalAccount> findAll();
@Query(value="select hospital_private from hospital",nativeQuery=true)
List<String> findhospitals();

List<HospitalAccount> findBycity(String city);


@Query(value="select distinct state from hospital",nativeQuery=true)
List<String> findStates();

@Query(value="select distinct city from hospital where state=?1",nativeQuery=true)
List<String> findcity(String state);

@Query(value="select hospital_private from hospital where city=?1",nativeQuery=true)
List<String> findhospital(String city);

@Query(value="select specializations from hospital where hospital_private=?1",nativeQuery=true)
List<String> findspecialzation(String hospital);
}
