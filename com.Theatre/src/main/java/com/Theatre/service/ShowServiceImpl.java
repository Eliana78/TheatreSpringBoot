package com.Theatre.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Theatre.enities.Shows;
import com.Theatre.repo.ShowsRepo;


@Service
public class ShowServiceImpl implements ShowService {

	
	@Autowired
	ShowsRepo showRepo;
	
	
	@Override
	public List<Shows> getAllShows() {
		
		return showRepo.findAll();
	}

	@Override
	public void deleteShow(int id) {
		showRepo.deleteById(id);

	}

	@Override
	public Shows addShow(Shows s) {
		
		return showRepo.save(s);
	}

	@Override
	public List<Shows> getFirstFourShows() {
		
		return showRepo.findFirstFourShows();
	}

	@Override
	public List<Shows> getByNamecontaining(String name) {
		
		return showRepo.findByNamecontaining(name);
	}

	@Override
	public List<Shows> getByDate(LocalDate date) {
		
		return showRepo.findByDate(date);
	}

	@Override
	public List<Shows> getByPriceRange(double minPrice, double maxPrice) {
		
		return showRepo.findByPriceRange(minPrice, maxPrice);
	}

	
}
