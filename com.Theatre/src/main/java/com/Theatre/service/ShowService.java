package com.Theatre.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;

import com.Theatre.enities.Shows;

public interface ShowService {

	
	List<Shows> getAllShows();
	void deleteShow(int id);
	Shows addShow(Shows s);
	
	
	
	@Query(value="select *from theatre_shows limit 4", nativeQuery=true)
	List<Shows> getFirstFourShows();
	
	@Query(value="select *from theatre_shows where show_name like %?1%", nativeQuery=true)
	List<Shows> getByNamecontaining(String name);
	
	List<Shows> getByDate(LocalDate date);
	
	@Query(value="select *from theatre_shows where price between ?1 and ?2", nativeQuery=true)
	List<Shows> getByPriceRange (double minPrice, double maxPrice);
	
	
	
}
