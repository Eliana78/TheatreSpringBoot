package com.Theatre.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Theatre.enities.Booking;
import com.Theatre.enities.Shows;
import com.Theatre.repo.BookingRepo;
import com.Theatre.repo.ShowsRepo;

import jakarta.transaction.Transactional;


@Service
public class BookingServiceImpl implements BookingService {

	
	@Autowired
	BookingRepo bookingRepo;
	
	
	@Autowired
	ShowsRepo showRepo;
	
	@Override
	public List<Booking> getAllBooking() {
		
		return bookingRepo.findAll();
	}

	@Override
	 public boolean deleteBookingById(int id) {
        if (bookingRepo.existsById(id)) {
            bookingRepo.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

	@Transactional
	@Override
	public Booking addBooking(Booking b) {
	    
	        // Retrieve the show related to the booking
	        Shows show = b.getShow();

	        // Decrease available spots
	        show.decreaseAvailableSpots(b.getTotPeople());

	        // Save the updated show
	        showRepo.save(show);

	        // Save the booking
	        return bookingRepo.save(b);
	    }

	

	@Override
	public Booking updateBooking(Booking b) {
		
		return bookingRepo.save(b);
	}

}
