package com.Theatre.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Theatre.enities.Booking;



@Repository
public interface BookingRepo extends JpaRepository<Booking, Integer> {

}
