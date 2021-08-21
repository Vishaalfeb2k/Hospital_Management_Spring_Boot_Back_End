package com.example.Appointment_Booking.Appointment_Booking.exception;

import java.util.UUID;

@SuppressWarnings("serial")
public class Slotnotfoundexception extends Throwable {
    public Slotnotfoundexception(int slot) {
        super("Cannot found slot [" + slot + "]");
    }
}