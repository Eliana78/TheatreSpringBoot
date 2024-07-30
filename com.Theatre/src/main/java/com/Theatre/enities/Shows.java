package com.Theatre.enities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="theatre_shows")
public class Shows {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="show_name", nullable=false)
	private String showName;
	
	
	@Column(nullable=false, updatable=true)
	private LocalDate date;
	
	private String image;
	
	private double price;
	
	@Column(name="available_spots")
	private int availableSpots;
	
	
	@Enumerated(EnumType.STRING)
	private Type showtype;
	
	
	
	
	@OneToMany(mappedBy = "show",cascade = CascadeType.ALL, fetch = FetchType.EAGER)   //uno show-> molte prenotazioni
	@JsonIgnore
	private List<Booking> bookings;
	
	
	
	//method to decrease the available spots by tot.people when a booking is made
	 public void decreaseAvailableSpots(int spots) {
	        this.availableSpots -= spots;
	    }
	
	public Shows() {
		
	}
	
	
	
	
	public List<Booking> getBookings() {
		return bookings;
	}




	public void setBookings(List<Booking> bookings) {
		this.bookings = bookings;
	}




	public int getAvailableSpots() {
		return availableSpots;
	}



	public void setAvailableSpots(int availableSpots) {
		this.availableSpots = availableSpots;
	}



	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getShowName() {
		return showName;
	}



	public void setShowName(String showName) {
		this.showName = showName;
	}



	public LocalDate getDate() {
		return date;
	}



	public void setDate(LocalDate date) {
		this.date = date;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public Type getShowtype() {
		return showtype;
	}



	public void setShowtype(Type showtype) {
		this.showtype = showtype;
	}
	
	
}
