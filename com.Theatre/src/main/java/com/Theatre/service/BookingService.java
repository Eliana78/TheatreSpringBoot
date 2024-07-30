package com.Theatre.service;

import java.util.List;

import com.Theatre.enities.Booking;
import com.Theatre.enities.Shows;

public interface BookingService {

	
	List<Booking> getAllBooking();
	boolean deleteBookingById(int id);
	Booking addBooking(Booking b);
	Booking updateBooking(Booking b);
	
	
	
}
