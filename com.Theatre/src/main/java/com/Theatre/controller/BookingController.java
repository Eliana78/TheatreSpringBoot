package com.Theatre.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Theatre.enities.Booking;
import com.Theatre.service.BookingService;

@RestController
@RequestMapping("/api")
public class BookingController {

	
	@Autowired
	BookingService bookingService;
	
	@GetMapping("/bookings")
	@CrossOrigin
	public List<Booking> getAllBooking(){
		return bookingService.getAllBooking();
	};
	
	
	 @DeleteMapping("/bookings/delete/{id}")
	    @CrossOrigin
	    public ResponseEntity<Void> deleteBookingById(@PathVariable int id) {
	        boolean isDeleted = bookingService.deleteBookingById(id);
	        if (isDeleted) {
	            return ResponseEntity.noContent().build();  // HTTP 204 No Content
	        } else {
	            return ResponseEntity.notFound().build();  // HTTP 404 Not Found
	        }
	    }
	
	
	@PostMapping("/bookings/add")
	@CrossOrigin
	public Booking addBooking(@RequestBody Booking b) {
		return bookingService.addBooking(b);
	};
	
	@PutMapping("/bookings/update")
	@CrossOrigin
	public Booking updateBooking(@RequestBody Booking b) {
		return bookingService.updateBooking(b);
	};
	
}
