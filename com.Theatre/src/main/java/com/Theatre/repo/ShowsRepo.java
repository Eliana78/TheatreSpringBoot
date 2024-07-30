package com.Theatre.repo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Theatre.enities.Shows;



@Repository
public interface ShowsRepo extends JpaRepository<Shows, Integer> {
	
	
	
	@Query(value="select *from theatre_shows limit 4", nativeQuery=true)
	List<Shows> findFirstFourShows();
	
	@Query(value="select *from theatre_shows where show_name like %?1%", nativeQuery=true)
	List<Shows> findByNamecontaining(String name);
	
	List<Shows> findByDate(LocalDate date);
	
	@Query(value="select *from theatre_shows where price between ?1 and ?2", nativeQuery=true)
	List<Shows> findByPriceRange (double minPrice, double maxPrice);
	
}
