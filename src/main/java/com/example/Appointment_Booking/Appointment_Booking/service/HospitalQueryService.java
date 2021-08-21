package com.example.Appointment_Booking.Appointment_Booking.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.axonframework.eventsourcing.eventstore.EventStore;
import org.axonframework.messaging.responsetypes.ResponseTypes;
import org.axonframework.queryhandling.QueryGateway;
import org.springframework.stereotype.Service;
import org.axonframework.messaging.Message;
import com.example.Appointment_Booking.Appointment_Booking.hospitalaccount.HospitalAccount;
import com.example.Appointment_Booking.Appointment_Booking.query.FindHospitalQuery;
import java.util.stream.Collectors;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class HospitalQueryService {

	private final QueryGateway queryGateway;
    private final EventStore eventStore;

    public CompletableFuture<HospitalAccount> findById(int id) {
        return this.queryGateway.query(
                new FindHospitalQuery(id),
                ResponseTypes.instanceOf(HospitalAccount.class)
        );
    }
    
//    
//    private UUID formatUuid(String id) {
//      	 id = id.replace("-", "");
//           String formatted = String.format(
//                  id.substring(0, 8) + "-" +
//                		   id.substring(8, 12) + "-" +
//                		   id.substring(12, 16) + "-" +
//                		   id.substring(16, 20) + "-" +
//                		   id.substring(20, 32)
//           );
//           return UUID.fromString(formatted);
//   	}

    public List<Object> listEventsForAccount(String id) {
        return this.eventStore
                .readEvents(id)
                .asStream()
                .map(Message::getPayload)
                .collect(Collectors.toList());
    }
}